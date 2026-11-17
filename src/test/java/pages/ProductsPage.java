package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductsPage extends PageBase {
    public ProductsPage(WebDriver driver) {super(driver);
    }

    // Locators
    @FindBy(xpath = "//button[contains(.,'Open Menu')]")
    public WebElement menu;
     @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;
    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy(className = "title")
//    @FindBy(className = "product_label")
    public WebElement productsPageTitle ;
    @FindBy(id = "shopping_cart_container")
    WebElement cartBtn ;
    @FindBy(className = "product_sort_container")
    public WebElement dropDownSort;
//    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/select/option[3]")
//    public WebElement priceLowHighOption ;
    @FindBy(className = "btn_primary.btn_inventory")
    public WebElement addToCartBtn;

//    List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
//    List<WebElement> add = driver.findElements(By.className("btn_primary.btn_inventory"));

    // Methods
    public void userLogout(){

        clickButton(menu);
        clickButton(logoutLink);
    }

    public CheckoutInfoPage addMultipleProductsToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.className("shopping_cart_badge")).click();
        return new CheckoutInfoPage(driver);
    }

}
