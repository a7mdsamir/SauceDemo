//package com.scb.saucedemo.tests;
//
//import com.scb.saucedemo.base.BaseTest;
//import com.scb.saucedemo.pages.CartPage;
//import com.scb.saucedemo.pages.InventoryPage;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class CartTests extends BaseTest {
//
//    @Test(description = "TC-SD-05 View cart products")
//    public void testViewCartProducts() {
//        InventoryPage inventory = loginAsStandardUser();
//        List<String> added = inventory.addFirstProducts(2);
//
//        CartPage cart = inventory.goToCart();
//        assertTrue(cart.isLoaded());
//        assertEquals(cart.getItemNames(), added, "Cart should list exactly the added products");
//    }
//
//    @Test(description = "TC-SD-08 Remove products from cart")
//    public void testRemoveProductsFromCart() {
//        InventoryPage inventory = loginAsStandardUser();
//        inventory.addFirstProducts(3);
//
//        CartPage cart = inventory.goToCart().removeItems(2);
//        assertEquals(cart.getItemCount(), 1, "One item should remain");
//
//        cart.removeItems(1);
//        assertEquals(cart.getItemCount(), 0, "Cart should be empty");
//    }
//
//    /**
//     * Expected business behaviour: an empty cart must not proceed to checkout.
//     * NOTE: as far as I know the live SauceDemo site lets users continue to checkout with an
//     * empty cart. If this test fails, that is the application defect it is designed to expose.
//     */
//    @Test(description = "TC-SD-09 Checkout of empty cart")
//    public void testCheckoutOfEmptyCart() {
//        CartPage cart = loginAsStandardUser().goToCart();
//        assertEquals(cart.getItemCount(), 0, "Precondition: cart must be empty");
//
//        cart.clickCheckout();
//        assertTrue(cart.getCurrentUrl().contains("cart.html"),
//                "Checkout should be blocked for an empty cart, but navigated to: " + cart.getCurrentUrl());
//    }
//}