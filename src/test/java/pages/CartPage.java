package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {
    // Locators
    private static final By CART_LIST = By.className("cart_list");
    private static final By CART_ITEMS = By.className("cart_item");
    private static final By ITEM_NAMES = By.className("inventory_item_name");
    private static final By REMOVE_BUTTONS = By.cssSelector("button[data-test^='remove']");
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By CONTINUE_SHOPPING = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify if the cart page is successfully loaded
     */
//    public boolean isLoaded() {
//        return waitVisible(CART_LIST).isDisplayed();
//    }

    /**
     * Get names of all items currently in the cart
     */
//    public List<String> getItemNames() {
//        return findAll(ITEM_NAMES).stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//    }

    /**
     * Get total count of items in the cart
     */
//    public int getItemCount() {
//        return findAll(CART_ITEMS).size();
//    }
//
//    /**
//     * Remove a specific number of items from the cart safely
//     */
//    public CartPage removeItems(int count) {
//        int initialCount = getItemCount();
//        for (int i = 1; i <= count; i++) {
//            List<WebElement> removeBtns = findAll(REMOVE_BUTTONS);
//            if (!removeBtns.isEmpty()) {
//                removeBtns.get(0).click(); // النقر على أول زر متاح، وتتحدث القائمة تلقائياً
//                // الانتظار حتى يتناقص عدد العناصر في السلة للتأكد من استقرار الصفحة
//                wait.until(ExpectedConditions.numberOfElementsToBe(CART_ITEMS, initialCount - i));
//            }
//        }
//        return this;
//    }

    /**
     * Click checkout button and navigate to Checkout Information page
     */
    public CheckoutInfoPage clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutInfoPage(driver);
    }


    /**
     * Click continue shopping button and return to Inventory page
     */
//    public InventoryPage continueShopping() {
//        click(CONTINUE_SHOPPING);
//        return new InventoryPage(driver);
//    }
}