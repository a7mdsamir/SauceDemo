package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
    protected WebDriver driver;

    // create constructor
    public PageBase(WebDriver driver) {
        this.driver = driver ;
        PageFactory.initElements(driver, this);

    }

    protected static void clickButton(WebElement button){
        button.click();
    }
    protected static void setTextElementText(WebElement textElement, String value){

        if (value != null) {
            textElement.clear();
            textElement.sendKeys(value);
        } else {
            System.out.println("Warning: Trying to send null value to an input field.");
        }
//        textElement.sendKeys(value);
    }
}
