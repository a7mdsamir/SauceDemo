//package tests.sauceDemoTestCases;
//
//public class CheckoutFlow {
//    @Test
//    public void testCheckoutFlow() {
//        sauceDemoPage.enterUsername("standard_user");
//        sauceDemoPage.enterPassword("secret_sauce");
//        sauceDemoPage.clickLogin();
//
//        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/following-sibling::button")).click();
//        driver.findElement(By.className("shopping_cart_link")).click();
//        driver.findElement(By.id("checkout")).click();
//
//        driver.findElement(By.id("first-name")).sendKeys("John");
//        driver.findElement(By.id("last-name")).sendKeys("Doe");
//        driver.findElement(By.id("postal-code")).sendKeys("12345");
//        driver.findElement(By.id("continue")).click();
//
//        String totalPrice = driver.findElement(By.className("summary_total_label")).getText();
//        Assert.assertTrue(totalPrice.contains("Total:"));
//        driver.findElement(By.id("finish")).click();
//
//        String confirmationMessage = driver.findElement(By.className("complete-header")).getText();
//        Assert.assertTrue(confirmationMessage.contains("THANK YOU FOR YOUR ORDER"));
//    }
//
//}
