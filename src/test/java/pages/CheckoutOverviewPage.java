package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends PageBase {
    private static final By ITEM_NAMES = By.className("inventory_item_name");
    private static final By TOTAL_LABEL = By.className("summary_total_label");
    private static final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

//    public boolean isLoaded() {
//        return waitVisible(FINISH_BUTTON).isDisplayed();
//    }
//
//    public List<String> getItemNames() {
//        return findAll(ITEM_NAMES).stream().map(WebElement::getText).collect(Collectors.toList());
//    }
//
//    public String getTotalLabel() {
//        return getText(TOTAL_LABEL);
//    }

    public CheckoutCompletePage clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}