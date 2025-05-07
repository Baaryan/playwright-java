/*
 * Copyright (c) Microsoft Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microsoft.playwright.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.Android;
import com.microsoft.playwright.AndroidDevice;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.ConnectOptions;
import com.google.gson.Gson;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.impl.AndroidDeviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.function.Consumer;

import static com.microsoft.playwright.impl.Serialization.gson;

class AndroidImpl extends ChannelOwner implements Android {
  AndroidImpl(ChannelOwner parent, String type, String guid, JsonObject initializer) {
    super(parent, type, guid, initializer);
  }

  @Override
  public List<AndroidDevice> devices() {
    return withLogging("Android.devices", this::devicesImpl);
  }

  private List<AndroidDevice> devicesImpl() {
    JsonElement result = sendMessage("android.devices");
    List<AndroidDevice> devices = new ArrayList<>();
    for (JsonElement deviceElement : result.getAsJsonArray()) {
      JsonObject deviceJson = deviceElement.getAsJsonObject();
      AndroidDevice device = connection.getExistingObject(deviceJson.get("guid").getAsString());
      devices.add(device);
    }
    return devices;
  }

  @Override
  public AndroidDevice connect(String host, int port) {
    return withLogging("Android.connect", () -> connectImpl(host, port));
  }

  @Override
  public AndroidDevice connect(String wsEndpoint, ConnectOptions options) {
    return withLogging("Android.connect", () -> connectImpl(wsEndpoint, options));
  }

  private AndroidDevice connectImpl(String wsEndpoint, ConnectOptions options) {
    if (options == null) {
        options = new ConnectOptions();
    }

    JsonObject params = new Gson().toJsonTree(options).getAsJsonObject();
    params.addProperty("wsEndpoint", wsEndpoint);

    System.out.println("Sending wsEndpoint to Android.connect: " + params);

    JsonObject result = connection.localUtils().sendMessage("connect", params).getAsJsonObject();

    System.out.println("Result from Android.connect: " + result);

    JsonObject pipe = result.getAsJsonObject("pipe");
    if (pipe == null || !pipe.has("guid")) {
        throw new PlaywrightException("Invalid response from Android.connect: missing 'pipe.guid'");
    }
    String guid = pipe.get("guid").getAsString();

    System.out.println("Extracted guid: " + guid);

    JsonPipe jsonPipe = connection.getExistingObject(guid);
    if (jsonPipe == null) {
        throw new PlaywrightException("Failed to retrieve JsonPipe object for guid: " + guid);
    }

    Connection androidConnection = new Connection(jsonPipe, connection.env, connection.localUtils);

    PlaywrightImpl playwright = androidConnection.initializePlaywright();

    if (!playwright.initializer.has("preConnectedAndroidDevice")) {
        try {
            androidConnection.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        throw new PlaywrightException("Malformed endpoint. Did you use the correct wsEndpoint?");
    }

    AndroidDeviceImpl androidDevice = androidConnection.getExistingObject(
        playwright.initializer.getAsJsonObject("preConnectedAndroidDevice").get("guid").getAsString()
    );

    return androidDevice;
  }

  private AndroidDevice connectImpl(String host, int port) {
    JsonObject params = new JsonObject();
    params.addProperty("host", host);
    params.addProperty("port", port);

    JsonElement result = sendMessage("android.connect", params);
    JsonObject deviceJson = result.getAsJsonObject();
    return connection.getExistingObject(deviceJson.get("guid").getAsString());
  }
}
