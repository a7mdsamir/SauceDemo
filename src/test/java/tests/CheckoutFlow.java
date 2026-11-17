package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import org.openqa.selenium.By;


public class CheckoutFlow extends TestBase {

    @Test
    public void testCheckoutFlow() {
        productsPage = new LoginPage(driver).loginSuccessfully();
        checkoutInfoPage = productsPage.addMultipleProductsToCart();
        checkoutInfoPage = new CartPage(driver).clickCheckout();
        checkoutInfoPage.fillInformation("John", "Doe", "12345");
        checkoutInfoPage.clickContinue();

        String totalPrice = driver.findElement(By.className("summary_total_label")).getText();
        Assert.assertTrue(totalPrice.contains("Total:"));
        driver.findElement(By.id("finish")).click();

        String confirmationMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertTrue(confirmationMessage.contains("Thank you for your order"));
    }

    @Test
    public void testCancelCheckoutFlow() {
        productsPage = new LoginPage(driver).loginSuccessfully();
        checkoutInfoPage = productsPage.addMultipleProductsToCart();
        checkoutInfoPage = new CartPage(driver).clickCheckout();

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        String totalPrice = driver.findElement(By.className("summary_total_label")).getText();
        Assert.assertTrue(totalPrice.contains("Total:"));
        driver.findElement(By.id("cancel")).click();

        // Verify navigation back to Products
        String pageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products");

    }

}
