//package tests;
//
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//import pages.InventoryPage;
//import base.TestBase;
//
//import java.util.List;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class CheckoutTests extends TestBase {
//
//    @Test(description = "TC-SD-06 Fill checkout form and complete the order")
//    public void testFillCheckoutFormAndCompleteOrder() {
//        InventoryPage inventory = loginAsStandardUser();
//        List<String> added = inventory.addFirstProducts(2);
//
//        CheckoutInfoPage info = inventory.goToCart().clickCheckout();
//        assertTrue(info.isLoaded());
//
//        CheckoutOverviewPage overview = info.fillInformation("Ahmed", "Samir", "11511").clickContinue();
//        assertTrue(overview.isLoaded());
//        assertEquals(overview.getItemNames(), added, "Overview should list the products in the cart");
//
//        CheckoutCompletePage complete = overview.clickFinish();
//        assertEquals(complete.getHeader(), "Thank you for your order!");
//    }
//
//    @Test(description = "TC-SD-06b Checkout form validation for missing fields")
//    public void testCheckoutFormValidation() {
//        InventoryPage inventory = loginAsStandardUser();
//        inventory.addFirstProducts(1);
//
//        CheckoutInfoPage info = inventory.goToCart().clickCheckout()
//                .fillInformation("", "Samir", "11511")
//                .clickContinueExpectingError();
//        assertTrue(info.getErrorMessage().contains("First Name is required"));
//    }
//
//    @Test(description = "TC-SD-07 Cancel checkout")
//    public void testCancelCheckout() {
//        InventoryPage inventory = loginAsStandardUser();
//        List<String> added = inventory.addFirstProducts(1);
//
//        CartPage cart = inventory.goToCart().clickCheckout()
//                .fillInformation("Ahmed", "Samir", "11511")
//                .clickCancel();
//        assertTrue(cart.getCurrentUrl().contains("cart.html"), "Cancel should return to the cart");
//        assertEquals(cart.getItemNames(), added, "Cart contents must be preserved after cancel");
//    }
//}