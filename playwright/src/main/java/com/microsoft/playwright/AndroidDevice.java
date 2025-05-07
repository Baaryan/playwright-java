package com.microsoft.playwright;

// import com.microsoft.playwright.options.Point;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * AndroidDevice represents a connected Android device.
 * 
 * <p>
 * Devices can be obtained using {@link Android#devices()} or
 * {@link Android#devices(Android.DevicesOptions)}.
 */
public interface AndroidDevice {
  // /**
  // * Sets the default timeout in milliseconds for all Android device operations.
  // *
  // * @param timeout Timeout in milliseconds
  // */
  // void setDefaultTimeout(int timeout);

  // /**
  // * Returns the serial number of the device.
  // *
  // * @return Serial number of the device
  // */
  String serial();

  // /**
  // * Returns the device model.
  // *
  // * @return Device model
  // */
  String model();

  // /**
  // * Returns all currently available WebViews.
  // *
  // * @return List of WebViews
  // */
  // // List<AndroidWebView> webViews();

  // /**
  // * Returns a specific WebView matching the specified criteria.
  // *
  // * @param selector Selector to find the WebView
  // * @return WebView matching the selector
  // */
  // // AndroidWebView webView(WebViewSelector selector);

  // /**
  // * Returns a specific WebView matching the specified criteria with custom
  // timeout.
  // *
  // * @param selector Selector to find the WebView
  // * @param options Timeout options
  // * @return WebView matching the selector
  // */
  // // AndroidWebView webView(WebViewSelector selector, WebViewOptions options);

  // /**
  // * Waits for a UI element matching the given selector to appear.
  // *
  // * @param selector Element selector
  // */
  // // void wait(AndroidSelector selector);

  // /**
  // * Waits for a UI element matching the given selector to appear with custom
  // options.
  // *
  // * @param selector Element selector
  // * @param options Wait options
  // */
  // // void wait(AndroidSelector selector, WaitOptions options);

  // /**
  // * Fills in a text field with the given text.
  // *
  // * @param selector Element selector
  // * @param text Text to fill
  // */
  // // void fill(AndroidSelector selector, String text);

  // /**
  // * Fills in a text field with the given text with custom timeout.
  // *
  // * @param selector Element selector
  // * @param text Text to fill
  // * @param options Timeout options
  // */
  // // void fill(AndroidSelector selector, String text, TimeoutOptions options);

  // /**
  // * Presses a key on the element.
  // *
  // * @param selector Element selector
  // * @param key Key to press
  // */
  // // void press(AndroidSelector selector, String key);

  // /**
  // * Presses a key on the element with custom timeout.
  // *
  // * @param selector Element selector
  // * @param key Key to press
  // * @param options Timeout options
  // */
  // // void press(AndroidSelector selector, String key, TimeoutOptions options);

  // /**
  // * Taps on the element.
  // *
  // * @param selector Element selector
  // */
  // // void tap(AndroidSelector selector);

  // /**
  // * Taps on the element with custom options.
  // *
  // * @param selector Element selector
  // * @param options Tap options
  // */
  // // void tap(AndroidSelector selector, TapOptions options);

  /**
   * Performs a drag gesture on the element.
   * 
   * @param selector Element selector
   * @param dest     Destination point
   */
  void drag(AndroidSelector selector, Point dest);

  /**
   * Performs a drag gesture on the element with custom options.
   * 
   * @param selector Element selector
   * @param dest     Destination point
   * @param options  Drag options
   */
  // void drag(AndroidSelector selector, Point dest, DragOptions options);

  // /**
  // * Performs a fling gesture on the element in the specified direction.
  // *
  // * @param selector Element selector
  // * @param direction Direction of the fling
  // */
  // // void fling(AndroidSelector selector, Direction direction);

  // /**
  // * Performs a fling gesture on the element in the specified direction with
  // custom options.
  // *
  // * @param selector Element selector
  // * @param direction Direction of the fling
  // * @param options Fling options
  // */
  // // void fling(AndroidSelector selector, Direction direction, FlingOptions
  // options);

  // /**
  // * Performs a long tap on the element.
  // *
  // * @param selector Element selector
  // */
  // // void longTap(AndroidSelector selector);

  // /**
  // * Performs a long tap on the element with custom timeout.
  // *
  // * @param selector Element selector
  // * @param options Timeout options
  // */
  // // void longTap(AndroidSelector selector, TimeoutOptions options);

  // /**
  // * Performs a pinch close gesture on the element.
  // *
  // * @param selector Element selector
  // * @param percent Percentage to pinch close
  // */
  // // void pinchClose(AndroidSelector selector, double percent);

  // /**
  // * Performs a pinch close gesture on the element with custom options.
  // *
  // * @param selector Element selector
  // * @param percent Percentage to pinch close
  // * @param options Pinch options
  // */
  // // void pinchClose(AndroidSelector selector, double percent, PinchOptions
  // options);

  // /**
  // * Performs a pinch open gesture on the element.
  // *
  // * @param selector Element selector
  // * @param percent Percentage to pinch open
  // */
  // // void pinchOpen(AndroidSelector selector, double percent);

  // /**
  // * Performs a pinch open gesture on the element with custom options.
  // *
  // * @param selector Element selector
  // * @param percent Percentage to pinch open
  // * @param options Pinch options
  // */
  // // void pinchOpen(AndroidSelector selector, double percent, PinchOptions
  // options);

  // /**
  // * Performs a scroll gesture on the element in the specified direction.
  // *
  // * @param selector Element selector
  // * @param direction Direction of the scroll
  // * @param percent Percentage to scroll
  // */
  // // void scroll(AndroidSelector selector, Direction direction, double
  // percent);

  // /**
  // * Performs a scroll gesture on the element in the specified direction with
  // custom options.
  // *
  // * @param selector Element selector
  // * @param direction Direction of the scroll
  // * @param percent Percentage to scroll
  // * @param options Scroll options
  // */
  // // void scroll(AndroidSelector selector, Direction direction, double percent,
  // ScrollOptions options);

  // /**
  // * Performs a swipe gesture on the element in the specified direction.
  // *
  // * @param selector Element selector
  // * @param direction Direction of the swipe
  // * @param percent Percentage to swipe
  // */
  // // void swipe(AndroidSelector selector, Direction direction, double percent);

  // /**
  // * Performs a swipe gesture on the element in the specified direction with
  // custom options.
  // *
  // * @param selector Element selector
  // * @param direction Direction of the swipe
  // * @param percent Percentage to swipe
  // * @param options Swipe options
  // */
  // // void swipe(AndroidSelector selector, Direction direction, double percent,
  // SwipeOptions options);

  // /**
  // * Gets information about the element.
  // *
  // * @param selector Element selector
  // * @return Element information
  // */
  // // ElementInfo info(AndroidSelector selector);

  // /**
  // * Takes a screenshot of the device.
  // *
  // * @return Screenshot as byte array
  // */
  // byte[] screenshot();

  // /**
  // * Takes a screenshot of the device and saves it to the specified path.
  // *
  // * @param options Screenshot options
  // * @return Screenshot as byte array
  // */
  // byte[] screenshot(ScreenshotOptions options);

  // /**
  // * Closes the connection to the device.
  // */
  // void close();

  /**
   * Executes a shell command on the device.
   * 
   * @param command Command to execute
   * @return Command output as byte array
   */
  byte[] shell(String command);

  // /**
  // * Opens a socket connection to the device.
  // *
  // * @param command Command to execute
  // * @return Socket connection
  // */
  // // AndroidSocket open(String command);

  // /**
  // * Installs an APK on the device.
  // *
  // * @param file Path to the APK file or APK as byte array
  // */
  // void installApk(Path file);

  // /**
  // * Installs an APK on the device with custom options.
  // *
  // * @param file Path to the APK file or APK as byte array
  // * @param options Installation options
  // */
  // void installApk(Path file, InstallApkOptions options);

  // /**
  // * Installs an APK on the device.
  // *
  // * @param file APK as byte array
  // */
  // void installApk(byte[] file);

  // /**
  // * Installs an APK on the device with custom options.
  // *
  // * @param file APK as byte array
  // * @param options Installation options
  // */
  // void installApk(byte[] file, InstallApkOptions options);

  // /**
  // * Pushes a file to the device.
  // *
  // * @param file Path to the file or file as byte array
  // * @param path Target path on the device
  // */
  // void push(Path file, String path);

  // /**
  // * Pushes a file to the device with custom options.
  // *
  // * @param file Path to the file or file as byte array
  // * @param path Target path on the device
  // * @param options Push options
  // */
  // void push(Path file, String path, PushOptions options);

  // /**
  // * Pushes a file to the device.
  // *
  // * @param file File as byte array
  // * @param path Target path on the device
  // */
  // void push(byte[] file, String path);

  // /**
  // * Pushes a file to the device with custom options.
  // *
  // * @param file File as byte array
  // * @param path Target path on the device
  // * @param options Push options
  // */
  // void push(byte[] file, String path, PushOptions options);

  /**
   * Launches Chrome browser on the device.
   * 
   * @return Browser context
   */
  BrowserContext launchBrowser();

  // /**
  // * Launches Chrome browser on the device with custom options.
  // *
  // * @param options Browser context options
  // * @return Browser context
  // */
  // BrowserContext launchBrowser(LaunchBrowserOptions options);

  // /**
  // * Registers a listener for an event.
  // *
  // * @param event Event name
  // * @param handler Event handler
  // */
  // void on(String event, Consumer<Object> handler);

  // /**
  // * Unregisters a listener for an event.
  // *
  // * @param event Event name
  // * @param handler Event handler
  // */
  // void off(String event, Consumer<Object> handler);

  // /**
  // * Returns the input controller for the device.
  // */
  // // AndroidInput input();

  // /**
  // * Direction enum for swipe, scroll, and fling operations.
  // */
  // enum Direction {
  // UP,
  // DOWN,
  // LEFT,
  // RIGHT
  // }

  // /**
  // * Options for screenshot operation.
  // */
  // class ScreenshotOptions {
  // /**
  // * Path to save the screenshot to.
  // */
  // public Path path;

  // /**
  // * Path to save the screenshot to.
  // */
  // public ScreenshotOptions setPath(Path path) {
  // this.path = path;
  // return this;
  // }
  // }

  // /**
  // * Options for timeout operations.
  // */
  // class TimeoutOptions {
  // /**
  // * Timeout in milliseconds.
  // */
  // public Integer timeout;

  // /**
  // * Timeout in milliseconds.
  // */
  // public TimeoutOptions setTimeout(int timeout) {
  // this.timeout = timeout;
  // return this;
  // }
  // }

  // /**
  // * Options for wait operations.
  // */
  // class WaitOptions extends TimeoutOptions {
  // /**
  // * Wait state - present or gone.
  // */
  // public String state;

  // /**
  // * Wait state - present or gone.
  // */
  // public WaitOptions setState(String state) {
  // this.state = state;
  // return this;
  // }
  // }

  // /**
  // * Options for tap operations.
  // */
  // class TapOptions extends TimeoutOptions {
  // /**
  // * Duration of the tap in milliseconds.
  // */
  // public Integer duration;

  // /**
  // * Duration of the tap in milliseconds.
  // */
  // public TapOptions setDuration(int duration) {
  // this.duration = duration;
  // return this;
  // }
  // }

  // /**
  // * Options for speed-based operations.
  // */
  // class SpeedOptions extends TimeoutOptions {
  // /**
  // * Speed of the operation.
  // */
  // public Double speed;

  // /**
  // * Speed of the operation.
  // */
  // public SpeedOptions setSpeed(double speed) {
  // this.speed = speed;
  // return this;
  // }
  // }

  // /**
  // * Options for drag operations.
  // */
  // class DragOptions extends SpeedOptions {
  // }

  // /**
  // * Options for fling operations.
  // */
  // class FlingOptions extends SpeedOptions {
  // }

  // /**
  // * Options for pinch operations.
  // */
  // class PinchOptions extends SpeedOptions {
  // }

  // /**
  // * Options for scroll operations.
  // */
  // class ScrollOptions extends SpeedOptions {
  // }

  // /**
  // * Options for swipe operations.
  // */
  // class SwipeOptions extends SpeedOptions {
  // }

  // /**
  // * Options for installing APKs.
  // */
  // class InstallApkOptions {
  // /**
  // * Additional arguments for the install command.
  // */
  // public List<String> args;

  // /**
  // * Additional arguments for the install command.
  // */
  // public InstallApkOptions setArgs(List<String> args) {
  // this.args = args;
  // return this;
  // }
  // }

  // /**
  // * Options for pushing files.
  // */
  // class PushOptions {
  // /**
  // * File mode (permissions).
  // */
  // public Integer mode;

  // /**
  // * File mode (permissions).
  // */
  // public PushOptions setMode(int mode) {
  // this.mode = mode;
  // return this;
  // }
  // }

  // /**
  // * Selector for WebView.
  // */
  // class WebViewSelector {
  // /**
  // * Package name of the WebView.
  // */
  // public String pkg;

  // /**
  // * Socket name of the WebView.
  // */
  // public String socketName;

  // /**
  // * Package name of the WebView.
  // */
  // public WebViewSelector setPkg(String pkg) {
  // this.pkg = pkg;
  // return this;
  // }

  // /**
  // * Socket name of the WebView.
  // */
  // public WebViewSelector setSocketName(String socketName) {
  // this.socketName = socketName;
  // return this;
  // }
  // }

  // /**
  // * Options for WebView operations.
  // */
  // class WebViewOptions extends TimeoutOptions {
  // /**
  // * Predicate for filtering WebViews.
  // */
  // // public Predicate<AndroidWebView> predicate;

  // /**
  // * Predicate for filtering WebViews.
  // */
  // // public WebViewOptions setPredicate(Predicate<AndroidWebView> predicate) {
  // // this.predicate = predicate;
  // // return this;
  // // }
  // }

  // /**
  // * Options for launching browser.
  // */
  // class LaunchBrowserOptions extends Browser.NewContextOptions {
  // /**
  // * Package name to launch.
  // */
  // public String pkg;

  // /**
  // * Package name to launch.
  // */
  // public LaunchBrowserOptions setPkg(String pkg) {
  // this.pkg = pkg;
  // return this;
  // }
  // }

  // /**
  // * Information about an Android element.
  // */
  // class ElementInfo {
  // /**
  // * Java class of the element.
  // */
  // public String clazz;

  // /**
  // * Content description of the element.
  // */
  // public String desc;

  // /**
  // * Resource ID of the element.
  // */
  // public String res;

  // /**
  // * Package name of the element.
  // */
  // public String pkg;

  // /**
  // * Text of the element.
  // */
  // public String text;

  // /**
  // * Bounds of the element.
  // */
  // public Bounds bounds;

  // /**
  // * Whether the element is checkable.
  // */
  // public boolean checkable;

  // /**
  // * Whether the element is checked.
  // */
  // public boolean checked;

  // /**
  // * Whether the element is clickable.
  // */
  // public boolean clickable;

  // /**
  // * Whether the element is enabled.
  // */
  // public boolean enabled;

  // /**
  // * Whether the element is focusable.
  // */
  // public boolean focusable;

  // /**
  // * Whether the element is focused.
  // */
  // public boolean focused;

  // /**
  // * Whether the element is long-clickable.
  // */
  // public boolean longClickable;

  // /**
  // * Whether the element is scrollable.
  // */
  // public boolean scrollable;

  // /**
  // * Whether the element is selected.
  // */
  // public boolean selected;

  // /**
  // * Bounds of an element.
  // */
  // public static class Bounds {
  // /**
  // * X coordinate.
  // */
  // public int x;

  // /**
  // * Y coordinate.
  // */
  // public int y;

  // /**
  // * Width of the element.
  // */
  // public int width;

  // /**
  // * Height of the element.
  // */
  // public int height;
  // }
  // }

  class AndroidSelector {
    /**
     * Whether the element is checkable.
     */
    private Boolean checkable;

    /**
     * Whether the element is checked.
     */
    private Boolean checked;

    /**
     * Java class of the element.
     */
    private Object clazz;

    /**
     * Whether the element is clickable.
     */
    private Boolean clickable;

    /**
     * Depth of the element in the hierarchy.
     */
    private Integer depth;

    /**
     * Content description of the element.
     */
    private Object desc;

    /**
     * Whether the element is enabled.
     */
    private Boolean enabled;

    /**
     * Whether the element is focusable.
     */
    private Boolean focusable;

    /**
     * Whether the element is focused.
     */
    private Boolean focused;

    /**
     * Selector for a child element.
     */
    private HasChildOptions hasChild;

    /**
     * Selector for a descendant element.
     */
    private HasDescendantOptions hasDescendant;

    /**
     * Whether the element is long-clickable.
     */
    private Boolean longClickable;

    /**
     * Package name of the element.
     */
    private Object pkg;

    /**
     * Resource ID of the element.
     */
    private Object res;

    /**
     * Whether the element is scrollable.
     */
    private Boolean scrollable;

    /**
     * Whether the element is selected.
     */
    private Boolean selected;

    /**
     * Text of the element.
     */
    private Object text;

    /**
     * Sets whether the element is checkable.
     */
    public AndroidSelector setCheckable(boolean checkable) {
      this.checkable = checkable;
      return this;
    }

    /**
     * Sets whether the element is checked.
     */
    public AndroidSelector setChecked(boolean checked) {
      this.checked = checked;
      return this;
    }

    /**
     * Sets the Java class of the element.
     */
    public AndroidSelector setClazz(String clazz) {
      this.clazz = clazz;
      return this;
    }

    /**
     * Sets the Java class pattern of the element.
     */
    public AndroidSelector setClazz(Pattern clazz) {
      this.clazz = clazz;
      return this;
    }

    /**
     * Sets whether the element is clickable.
     */
    public AndroidSelector setClickable(boolean clickable) {
      this.clickable = clickable;
      return this;
    }

    /**
     * Sets the depth of the element in the hierarchy.
     */
    public AndroidSelector setDepth(int depth) {
      this.depth = depth;
      return this;
    }

    /**
     * Sets the content description of the element.
     */
    public AndroidSelector setDesc(String desc) {
      this.desc = desc;
      return this;
    }

    /**
     * Sets the content description pattern of the element.
     */
    public AndroidSelector setDesc(Pattern desc) {
      this.desc = desc;
      return this;
    }

    /**
     * Sets whether the element is enabled.
     */
    public AndroidSelector setEnabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Sets whether the element is focusable.
     */
    public AndroidSelector setFocusable(boolean focusable) {
      this.focusable = focusable;
      return this;
    }

    /**
     * Sets whether the element is focused.
     */
    public AndroidSelector setFocused(boolean focused) {
      this.focused = focused;
      return this;
    }

    /**
     * Sets the selector for a child element.
     */
    public AndroidSelector setHasChild(HasChildOptions hasChild) {
      this.hasChild = hasChild;
      return this;
    }

    /**
     * Sets the selector for a descendant element.
     */
    public AndroidSelector setHasDescendant(HasDescendantOptions hasDescendant) {
      this.hasDescendant = hasDescendant;
      return this;
    }

    /**
     * Sets whether the element is long-clickable.
     */
    public AndroidSelector setLongClickable(boolean longClickable) {
      this.longClickable = longClickable;
      return this;
    }

    /**
     * Sets the package name of the element.
     */
    public AndroidSelector setPkg(String pkg) {
      this.pkg = pkg;
      return this;
    }

    /**
     * Sets the package name pattern of the element.
     */
    public AndroidSelector setPkg(Pattern pkg) {
      this.pkg = pkg;
      return this;
    }

    /**
     * Sets the resource ID of the element.
     */
    public AndroidSelector setRes(String res) {
      this.res = res;
      return this;
    }

    /**
     * Sets the resource ID pattern of the element.
     */
    public AndroidSelector setRes(Pattern res) {
      this.res = res;
      return this;
    }

    /**
     * Sets whether the element is scrollable.
     */
    public AndroidSelector setScrollable(boolean scrollable) {
      this.scrollable = scrollable;
      return this;
    }

    /**
     * Sets whether the element is selected.
     */
    public AndroidSelector setSelected(boolean selected) {
      this.selected = selected;
      return this;
    }

    /**
     * Sets the text of the element.
     */
    public AndroidSelector setText(String text) {
      this.text = text;
      return this;
    }

    /**
     * Sets the text pattern of the element.
     */
    public AndroidSelector setText(Pattern text) {
      this.text = text;
      return this;
    }

    /**
     * Options for hasChild selector.
     */
    public static class HasChildOptions {
      /**
       * Selector for the child element.
       */
      public AndroidSelector selector;

      public HasChildOptions setSelector(AndroidSelector selector) {
        this.selector = selector;
        return this;
      }
    }

    /**
     * Options for hasDescendant selector.
     */
    public static class HasDescendantOptions {
      /**
       * Selector for the descendant element.
       */
      public AndroidSelector selector;

      /**
       * Maximum depth to search for descendants.
       */
      public Integer maxDepth;

      public HasDescendantOptions setSelector(AndroidSelector selector) {
        this.selector = selector;
        return this;
      }

      public HasDescendantOptions setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
        return this;
      }
    }
  }
}