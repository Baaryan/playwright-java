package com.microsoft.playwright.impl;

import com.microsoft.playwright.AndroidDevice;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.PlaywrightException;

import java.io.IOException;
import java.util.Base64;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class AndroidDeviceImpl extends ChannelOwner implements AndroidDevice {
  AndroidDeviceImpl(ChannelOwner parent, String type, String guid, JsonObject initializer) {
    super(parent, type, guid, initializer);
  }

  @Override
  public BrowserContext launchBrowser() {
    return withLogging("AndroidDevice.launchBrowser", () -> launchBrowserImpl());
  }

  private BrowserContext launchBrowserImpl() {
    JsonElement result = sendMessage("launchBrowser");
    if (result == null) {
      return null;
    }

    JsonObject browserContext = result.getAsJsonObject().getAsJsonObject("context");
    return connection.getExistingObject(browserContext.get("guid").getAsString());
  }

  @Override
  public byte[] shell(String command) {
    return withLogging("AndroidDevice.shell", () -> shellImpl(command));
  }

  byte[] shellImpl(String command) {
    JsonObject params = new JsonObject();
    params.addProperty("command", command);

    JsonObject json = sendMessage("shell", params).getAsJsonObject();
    byte[] buffer = Base64.getDecoder().decode(json.get("result").getAsString());
    return buffer;
  }

  @Override
  public String model() {
    return initializer.get("model").getAsString();
  }

  @Override
  public String serial() {
    return initializer.get("serial").getAsString();
  }

}
