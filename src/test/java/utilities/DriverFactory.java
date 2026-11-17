package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() { }

    public static WebDriver initDriver() {
        boolean headless = ConfigReader.getBoolean("headless");
        WebDriver driver = switch (ConfigReader.get("browser").toLowerCase()) {
            case "firefox" -> createFirefox(headless);
            case "edge" -> createEdge(headless);
            default -> createChrome(headless);
        };
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        DRIVER.set(driver);
        return driver;
    }

    public static WebDriver getDriver() { return DRIVER.get(); }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }

    private static WebDriver createChrome(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--disable-notifications");
        options.addArguments(headless ? "--headless=new" : "--start-maximized");
        if (headless) options.addArguments("--window-size=1920,1080");

        // Stops Chrome's password-manager / "data breach" popups from covering the page
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefox(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) options.addArguments("-headless");
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdge(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments(headless ? "--headless=new" : "--start-maximized");
        if (headless) options.addArguments("--window-size=1920,1080");
        return new EdgeDriver(options);
    }
}