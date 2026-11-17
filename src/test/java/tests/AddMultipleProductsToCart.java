package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddMultipleProductsToCart extends TestBase {

    @Test
    public void testAddMultipleProductsToCart() {
        productsPage = new LoginPage(driver).loginSuccessfully();

//        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
//
//        driver.findElement(By.className("shopping_cart_badge")).click();
//        CheckoutInfoPage = new ProductsPage(driver).addMultipleProductsToCart();
        checkoutInfoPage = productsPage.addMultipleProductsToCart();
        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
        Assert.assertEquals(cartItems.size(), 2);
    }

}
