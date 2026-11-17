package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends PageBase {

    public enum SortOption {
        NAME_A_TO_Z("az"), NAME_Z_TO_A("za"), PRICE_LOW_TO_HIGH("lohi"), PRICE_HIGH_TO_LOW("hilo");

        private final String value;

        SortOption(String value) { this.value = value; }

        public String getValue() { return value; }
    }

    private static final By INVENTORY_LIST = By.className("inventory_list");
    private static final By SORT_DROPDOWN = By.cssSelector("[data-test='product-sort-container']");
    private static final By PRODUCT_NAMES = By.className("inventory_item_name");
    private static final By PRODUCT_PRICES = By.className("inventory_item_price");
    private static final By ADD_BUTTONS = By.cssSelector("button[data-test^='add-to-cart']");
    private static final By REMOVE_BUTTONS = By.cssSelector("button[data-test^='remove']");
    private static final By CART_BADGE = By.className("shopping_cart_badge");
    private static final By CART_LINK = By.className("shopping_cart_link");
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    private static final By LOGOUT_LINK = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

//    public boolean isLoaded() {
//        try {
//            waitVisible(INVENTORY_LIST);
//            return true;
//        } catch (TimeoutException e) {
//            return false;
//        }
//    }
//
//    public InventoryPage sortBy(SortOption option) {
//        selectByValue(SORT_DROPDOWN, option.getValue());
//        return this;
//    }
//
//    public List<String> getProductNames() {
//        return findAll(PRODUCT_NAMES).stream().map(WebElement::getText).collect(Collectors.toList());
//    }
//
//    public List<Double> getProductPrices() {
//        return findAll(PRODUCT_PRICES).stream()
//                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
//                .collect(Collectors.toList());
//    }
//
//    /** Adds the first {@code count} products (assumes an empty cart) and returns their names. */
//    public List<String> addFirstProducts(int count) {
//        List<String> added = new ArrayList<>(getProductNames().subList(0, count));
//        for (int i = 1; i <= count; i++) {
//            click(ADD_BUTTONS); // a clicked "Add" turns into "Remove", so the first Add button is always the next product
//            wait.until(ExpectedConditions.numberOfElementsToBe(REMOVE_BUTTONS, i));
//        }
//        return added;
//    }
//
//    public InventoryPage removeProducts(int count) {
//        int before = findAll(REMOVE_BUTTONS).size();
//        for (int i = 1; i <= count; i++) {
//            click(REMOVE_BUTTONS);
//            wait.until(ExpectedConditions.numberOfElementsToBe(REMOVE_BUTTONS, before - i));
//        }
//        return this;
//    }
//
//    public int getCartCount() {
//        List<WebElement> badge = findAll(CART_BADGE);
//        return badge.isEmpty() ? 0 : Integer.parseInt(badge.get(0).getText());
//    }
//
//    public CartPage goToCart() {
//        click(CART_LINK);
//        return new CartPage(driver);
//    }
//
//    public LoginPage logout() {
//        click(MENU_BUTTON);
//        click(LOGOUT_LINK);
//        return new LoginPage(driver);
//    }
}