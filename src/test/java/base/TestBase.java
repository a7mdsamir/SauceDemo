package base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase{
    public WebDriver driver;
    protected LoginPage loginPage ;
    protected ProductsPage productsPage ;
    protected CheckoutInfoPage checkoutInfoPage ;

    @BeforeMethod
    @Parameters({"browser"})
    public void startDriver(@Optional("edge") String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("edge")) {
//            System.setProperty(
//                    "webdriver.edge.driver",
//                    "F:\\edgedriver_win64\\msedgedriver.exe"
//            );
//            driver = new EdgeDriver();
//            EdgeOptions options = new EdgeOptions();
//
//            driver = new RemoteWebDriver(
//                    new URL("http://localhost:9515"),
//                    options
//            );
            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException(
                    "Unsupported browser: " + browserName
            );
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
//
//        productsPage = new ProductsPage(driver);
//        productsPage.userLogout();
//        loginPage = new LoginPage(driver);
        driver.navigate().to("https://www.saucedemo.com/v1/");

        loginPage = new LoginPage(driver);


    }

    // take screenshot on failure
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed, taking screenshot ...");
            Helper.captureScreenshot(driver, result.getName());
        }

        driver.quit();
    }
}
