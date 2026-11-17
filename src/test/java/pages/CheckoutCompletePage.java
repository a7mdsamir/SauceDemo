package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends PageBase {
    private static final By HEADER = By.className("complete-header");
    private static final By BACK_HOME = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

//    public String getHeader() {
//        return getText(HEADER);
//    }
//
//    public InventoryPage backToProducts() {
//        click(BACK_HOME);
//        return new InventoryPage(driver);
//    }
}