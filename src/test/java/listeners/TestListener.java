package listeners;

import utilities.DriverFactory;
import com.scb.saucedemo.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Path;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            Path file = ScreenshotUtil.capture(driver, result.getName());
            System.out.println("Screenshot saved: " + file.toAbsolutePath());
        }
    }
}