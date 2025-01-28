//package tests.sauceDemoTestCases;
//
//public class CancelingCheckout {
//    // Login first
//    loginToSauceDemo(driver, "standard_user", "secret_sauce");
//
//// Add a product to the cart
//driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
//
//// Navigate to cart and proceed to checkout
//driver.findElement(By.className("shopping_cart_link")).click();
//driver.findElement(By.id("checkout")).click();
//
//// Fill out the checkout form
//driver.findElement(By.id("first-name")).sendKeys("John");
//driver.findElement(By.id("last-name")).sendKeys("Doe");
//driver.findElement(By.id("postal-code")).sendKeys("12345");
//
//// Cancel the checkout
//driver.findElement(By.id("cancel")).click();
//
//    // Verify navigation back to cart
//    String pageTitle = driver.findElement(By.className("title")).getText();
//Assert.assertEquals(pageTitle, "Your Cart");
//
//}
