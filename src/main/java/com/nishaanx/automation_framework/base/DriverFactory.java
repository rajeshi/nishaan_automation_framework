package com.nishaanx.automation_framework.base;

import com.nishaanx.automation_framework.converters.Har2JmxConverter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    private static BrowserMobProxy proxy;

    public static void createWebDriverInstance() throws MalformedURLException {
        String browserName = Configurations.BROWSER;
        String testType = Configurations.TEST_TYPE;
        createWebDriverInstance(browserName, testType);
    }

    public static void createWebDriverInstance(String browserName, String testType) throws MalformedURLException {
        String thread = Thread.currentThread().getName();
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = null;

        if (testType.equalsIgnoreCase("WEB")) {
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    System.out.println(Configurations.CHROME_DRIVER_EXE);
                    System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_EXE);
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);
                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=chrome"), capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
                    drivers.put(thread, driver);
                    break;
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", Configurations.FIREFOX_DRIVER_EXE);
                    capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("marionette", true);

                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=firefox"), capabilities);
                    } else {
                        driver = new FirefoxDriver();
                    }
                    driver = new FirefoxDriver();
                    drivers.put(thread, driver);
                    break;
                case "IE":
                    System.setProperty("webdriver.ie.driver", Configurations.IE_DRIVER_EXE);
                    driver = new InternetExplorerDriver();

                    drivers.put(thread, driver);
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_EXE);
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);
                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=chrome"), capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
            }
        }
    }

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread().getName());
    }

    public static void getHttpTraffic() throws IOException {
        if (Configurations.BROWSER.equals("PERFORMANCE")) {
            Har har = proxy.getHar();
            proxy.stop();
            Har2JmxConverter converter = new Har2JmxConverter();
            converter.generateJmxFile(har);
        }
    }
}
