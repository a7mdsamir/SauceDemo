//package utilities;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class DriverFactory {
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup(); // Automate ChromeDriver setup
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
//
//    public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
//
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}
