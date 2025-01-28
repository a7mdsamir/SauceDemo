package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.Helper;

import java.time.Duration;

public class TestBase{
    public WebDriver driver;
    protected LoginPage loginPage ;
    protected ProductsPage productsPage ;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName)  {
        if (browserName.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();

//            WebDriver driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Unsupported browser: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");

        productsPage = new ProductsPage(driver);
        productsPage.userLogout();
        loginPage = new LoginPage(driver);


    }

//    @AfterSuite
//    public void stopDriver(){
//        driver.quit();
//    }

    // take screenshot on failure
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed, taking screenshot ...");
            Helper.captureScreenshot(driver, result.getName());
        }
    }
}
