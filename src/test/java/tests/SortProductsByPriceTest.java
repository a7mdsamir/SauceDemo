package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortProductsByPriceTest extends TestBase {
    ProductsPage productsPage ;


    @Test
    public void testSortProductsByPrice() throws InterruptedException {
        productsPage = new LoginPage(driver).loginSuccessfully();

        System.out.println("Page Title: " + productsPage.productsPageTitle.getText());
        Assert.assertEquals(productsPage.productsPageTitle.getText() , "Products" , "Page title mismatch!");

        WebElement optionList = productsPage.dropDownSort;
        Select selectOptions = new Select(optionList);
        Assert.assertFalse(selectOptions.isMultiple(), "Dropdown allows multiple selection!");
        Assert.assertEquals(selectOptions.getOptions().size(), 4, "Unexpected dropdown options count!");
        Thread.sleep(2000);

        // Wait for dropdown to be visible and interactable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(optionList));

        selectOptions.selectByVisibleText("Price (low to high)");
        Assert.assertEquals(selectOptions.getFirstSelectedOption().getText(), "Price (low to high)");
        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElement(optionList, "Price (low to high)"));

        selectOptions.selectByIndex(1);
        Thread.sleep(2000);
        System.out.println("Dropdown selection validated: " + selectOptions.getFirstSelectedOption().getText());

        selectOptions.selectByIndex(2); // يختار الخيار الثالث في القائمة (Index 2)
        System.out.println("Dropdown selection validated: " + selectOptions.getFirstSelectedOption().getText());

        // Locate all product price elements
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("$", "").trim(); // Remove "$" if present
            prices.add(Double.parseDouble(priceText));
            System.out.println("priceText " + priceText);
        }
        // Check if prices are sorted in ascending order
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(prices, sortedPrices, "Prices are not sorted correctly!");
        if (prices.equals(sortedPrices)) {
            System.out.println("Prices are in ascending order.");
        } else {
            System.out.println("Prices are NOT in ascending order.");
        }

        selectOptions.selectByIndex(0);

        // Locate all product name elements
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));

        // Extract product names into a list of strings
        List<String> productNames = new ArrayList<>();
        for (WebElement element : productElements) {
            productNames.add(element.getText().trim()); // Get text and trim whitespace
            System.out.println("element.getText() " + element.getText());
        }

        // Verify if the product names are in alphabetical order
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames); // Sort alphabetically

        if (productNames.equals(sortedProductNames)) {
            System.out.println("Product names are in alphabetical order.");
        } else {
            System.out.println("Product names are NOT in alphabetical order.");
        }
//        double previousPrice = Double.MAX_VALUE;
//        for (WebElement price : prices) {
//            double currentPrice = Double.parseDouble(price.getText().replace("$", ""));
//            Assert.assertTrue(currentPrice <= previousPrice);
//            previousPrice = currentPrice;
//        }
    }

}
