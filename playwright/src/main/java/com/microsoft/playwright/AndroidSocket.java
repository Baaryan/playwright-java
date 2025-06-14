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

import com.google.gson.JsonObject;

import java.nio.charset.StandardCharsets;

class AndroidSocket extends ChannelOwner {
  AndroidSocket(ChannelOwner parent, String type, String guid, JsonObject initializer) {
    super(parent, type, guid, initializer);
  }

  /**
   * Sends data to the Android socket.
   *
   * @param data The data to send.
   */
  public void write(byte[] data) {
    JsonObject params = new JsonObject();
    params.addProperty("data", new String(data, StandardCharsets.UTF_8));
    sendMessage("androidSocket.write", params);
  }

  /**
   * Closes the Android socket.
   */
  public void close() {
    sendMessage("androidSocket.close");
  }
}
