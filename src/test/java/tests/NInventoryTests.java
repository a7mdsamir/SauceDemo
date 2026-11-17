//package com.scb.saucedemo.tests;
//
//import com.scb.saucedemo.base.BaseTest;
//import com.scb.saucedemo.pages.InventoryPage;
//import com.scb.saucedemo.pages.InventoryPage.SortOption;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//import static org.testng.Assert.assertEquals;
//
//public class InventoryTests extends BaseTest {
//
//    @DataProvider(name = "sortOptions")
//    public Object[][] sortOptions() {
//        return Arrays.stream(SortOption.values()).map(o -> new Object[]{o}).toArray(Object[][]::new);
//    }
//
//    @Test(dataProvider = "sortOptions", description = "TC-SD-02 Sort the products")
//    public void testSortProducts(SortOption option) {
//        InventoryPage inventory = loginAsStandardUser().sortBy(option);
//        switch (option) {
//            case NAME_A_TO_Z -> assertSorted(inventory.getProductNames(), true);
//            case NAME_Z_TO_A -> assertSorted(inventory.getProductNames(), false);
//            case PRICE_LOW_TO_HIGH -> assertSorted(inventory.getProductPrices(), true);
//            case PRICE_HIGH_TO_LOW -> assertSorted(inventory.getProductPrices(), false);
//        }
//    }
//
//    @Test(description = "TC-SD-03 Add products from landing page")
//    public void testAddProductsFromLandingPage() {
//        InventoryPage inventory = loginAsStandardUser();
//        inventory.addFirstProducts(3);
//        assertEquals(inventory.getCartCount(), 3, "Cart badge should show 3");
//    }
//
//    @Test(description = "TC-SD-04 Remove product from landing page")
//    public void testRemoveProductFromLandingPage() {
//        InventoryPage inventory = loginAsStandardUser();
//        inventory.addFirstProducts(3);
//
//        inventory.removeProducts(1);
//        assertEquals(inventory.getCartCount(), 2, "Cart badge should show 2 after removing one");
//
//        inventory.removeProducts(2);
//        assertEquals(inventory.getCartCount(), 0, "Cart badge should disappear when cart is empty");
//    }
//
//    private <T extends Comparable<? super T>> void assertSorted(List<T> actual, boolean ascending) {
//        List<T> expected = new ArrayList<>(actual);
//        expected.sort(ascending ? Comparator.<T>naturalOrder() : Comparator.<T>reverseOrder());
//        assertEquals(actual, expected, "Products are not sorted as expected");
//    }
//}