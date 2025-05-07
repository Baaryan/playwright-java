package com.microsoft.playwright;

import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.Proxy;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Playwright has **experimental** support for Android automation. This includes
 * Chrome for Android and Android
 * WebView.
 *
 * <p>
 * <strong>Requirements</strong>
 * <ul>
 * <li>Android device or AVD Emulator.</li>
 * <li><a href="https://developer.android.com/studio/command-line/adb">ADB
 * daemon</a> running and authenticated with your device.
 * Typically running {@code adb devices} is all you need to do.</li>
 * <li><a href=
 * "https://play.google.com/store/apps/details?id=com.android.chrome">Chrome
 * 87</a> or newer installed on the
 * device</li>
 * <li>"Enable command line on non-rooted devices" enabled in
 * {@code chrome://flags}.</li>
 * </ul>
 *
 * <p>
 * <strong>Known limitations</strong>
 * <ul>
 * <li>Raw USB operation is not yet supported, so you need ADB.</li>
 * <li>Device needs to be awake to produce screenshots. Enabling "Stay awake"
 * developer mode will help.</li>
 * <li>We didn't run all the tests against the device, so not everything
 * works.</li>
 * </ul>
 */
public interface Android {
  // /**
  // * Sets the default timeout in milliseconds for all Android operations.
  // *
  // * @param timeout Timeout in milliseconds
  // */
  // void setDefaultTimeout(int timeout);

  /**
   * Returns a list of connected Android devices.
   * 
   * @return List of connected Android devices
   */
  List<AndroidDevice> devices();

  /**
   * Returns a list of connected Android devices.
   * 
   * @param options Connection options with optional port
   * @return List of connected Android devices
   */
  List<AndroidDevice> devices(DevicesOptions options);

  // /**
  // * Launches a browser server process for Android automation.
  // *
  // * @return BrowserServer instance
  // */
  // BrowserServer launchServer();

  // /**
  // * Launches a browser server process for Android automation with custom
  // options.
  // *
  // * @param options Server launch options
  // * @return BrowserServer instance
  // */
  // BrowserServer launchServer(LaunchServerOptions options);

  // /**
  // * Connects to an Android device via WebSocket endpoint.
  // *
  // * @param wsEndpoint WebSocket endpoint to connect to
  // * @return Connected Android device
  // */
  // AndroidDevice connect(String wsEndpoint);

  // /**
  // * Connects to an Android device via WebSocket endpoint with custom options.
  // *
  // * @param wsEndpoint WebSocket endpoint to connect to
  // * @param options Connection options
  // * @return Connected Android device
  // */
  // AndroidDevice connect(String wsEndpoint, ConnectOptions options);

  /**
   * Options for {@link Android#devices(DevicesOptions)}.
   */
  class DevicesOptions {
    /**
     * Optional port to connect to ADB.
     */
    public Integer port;

    public String host;

    public Boolean omitDriverInstall;

    /**
     * Optional port to connect to ADB.
     */
    public DevicesOptions setPort(int port) {
      this.port = port;
      return this;
    }

    /**
     * t
     * Optional host to connect to ADB.
     */
    public DevicesOptions setHost(String host) {
      this.host = host;
      return this;
    }

    /**
     * Prevents automatic playwright driver installation on attach. Assumes that the
     * drivers have been installed already.
     */
    public DevicesOptions setOmitDriverInstall(boolean omitDriverInstall) {
      this.omitDriverInstall = omitDriverInstall;
      return this;
    }
  }

  // /**
  // * Options for {@link Android#launchServer(LaunchServerOptions)}.
  // */
  // class LaunchServerOptions {
  // /**
  // * Port to use for ADB connection.
  // */
  // public Integer port;

  // /**
  // * Additional environment variables to set for the ADB process.
  // */
  // public Map<String, String> env;

  // /**
  // * Port to use for ADB connection.
  // */
  // public LaunchServerOptions setPort(int port) {
  // this.port = port;
  // return this;
  // }

  // /**
  // * Additional environment variables to set for the ADB process.
  // */
  // public LaunchServerOptions setEnv(Map<String, String> env) {
  // this.env = env;
  // return this;
  // }
  // }

  // /**
  // * Options for {@link Android#connect(String, ConnectOptions)}.
  // */
  class ConnectOptions {
  /**
  * Timeout for the connection in milliseconds.
  */
  public Integer timeout;

  /**
  * Additional HTTP headers to send with the WebSocket connection.
  */
  public Map<String, String> headers;

  /**
  * Slows down operations by the specified amount of milliseconds.
  */
  public Double slowMo;

  /**
  * Timeout for the connection in milliseconds.
  */
  public ConnectOptions setTimeout(int timeout) {
  this.timeout = timeout;
  return this;
  }

  /**
  * Additional HTTP headers to send with the WebSocket connection.
  */
  public ConnectOptions setHeaders(Map<String, String> headers) {
  this.headers = headers;
  return this;
  }

  /**
  * Slows down operations by the specified amount of milliseconds.
  */
  public ConnectOptions setSlowMo(double slowMo) {
  this.slowMo = slowMo;
  return this;
  }
  }
}