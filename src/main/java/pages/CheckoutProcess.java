//package pages.sauceDemoPagesTCs;
//
//public class CheckoutProcess {
//    driver.findElement(By.className("shopping_cart_link")).click();
//driver.findElement(By.id("checkout")).click();
//
//driver.findElement(By.id("first-name")).sendKeys("John");
//driver.findElement(By.id("last-name")).sendKeys("Doe");
//driver.findElement(By.id("postal-code")).sendKeys("12345");
//driver.findElement(By.id("continue")).click();
//
//    // Verify checkout overview
//    String summary = driver.findElement(By.className("summary_total_label")).getText();
//Assert.assertTrue(summary.contains("Total:"));
//
//}
