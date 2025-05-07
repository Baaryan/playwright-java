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
  public void close() {
    withLogging("AndroidDevice.close", this::closeImpl(options));
  }

  private void closeImpl() {
    if (isClosed) {
        System.out.println("AndroidDevice is already closed.");
        return;
    }

    isClosed = true;

    notifyRemoteClosed();

    try {
        sendMessage("close");
    } catch (PlaywrightException e) {
        if (e.getMessage().contains("Browser has been closed")) {
            System.out.println("AndroidDevice is already closed: " + e.getMessage());
        } else {
            throw e;
        }
    }

    if (jsonPipe != null) {
        jsonPipe.close();
    }
  }

  private void notifyRemoteClosed() {
      System.out.println("Notifying listeners about AndroidDevice disconnection.");
      emit("close");
  }

  @Override
  public String model() {
    return withLogging("AndroidDevice.model", this::modelImpl);
  }

  private String modelImpl() {
    return initializer.get("model").getAsString();
  }

  @Override
  public String serial() {
    return withLogging("AndroidDevice.serial", this::serialImpl);
  }

  private String serialImpl() {
    return initializer.get("serial").getAsString();
  }

}
