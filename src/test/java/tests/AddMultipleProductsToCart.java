//package tests.sauceDemoTestCases;
//
//public class AddMultipleProductsToCart {
//    @Test
//    public void testAddMultipleProductsToCart() {
//        sauceDemoPage.enterUsername("standard_user");
//        sauceDemoPage.enterPassword("secret_sauce");
//        sauceDemoPage.clickLogin();
//
//        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/following-sibling::button")).click();
//        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/following-sibling::button")).click();
//
//        driver.findElement(By.className("shopping_cart_link")).click();
//        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
//        Assert.assertEquals(cartItems.size(), 2);
//    }
//
//}
