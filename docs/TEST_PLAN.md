# Test Plan: SauceDemo (https://www.saucedemo.com)

## 1. Objective
Verify the core shopping journey (login → browse → cart → checkout → logout) works correctly.

## 2. Scope
In scope: login, product sorting, add/remove products, cart, checkout, logout.
Out of scope: performance, security, visual-glitch/problem-user accounts, mobile browsers.

## 3. Approach
Automated UI tests (Selenium WebDriver, Java, TestNG, Page Object Model). Every test can also be executed manually from the table below.

## 4. Environment & Data
Chrome (latest; Firefox/Edge supported). Users: `standard_user` / `secret_sauce`, `locked_out_user` / `secret_sauce`.

## 5. Entry / Exit Criteria
Entry: site reachable, valid test users available. Exit: all cases executed, no open critical/high defects.

## 6. Risks
Public demo site may change locators; empty-cart checkout is a known application defect.

## 7. Test Cases
| ID | Scenario | Steps | Expected result | Automated in |
|---|---|---|---|---|
| TC-SD-01a | Valid login | Enter standard_user / secret_sauce → Login | Products page is displayed | LoginTests.testValidLogin |
| TC-SD-01b | Invalid login | Try locked user, wrong password, empty fields | Matching error message for each | LoginTests.testInvalidLogin |
| TC-SD-02 | Sort products | Choose each sort option | List ordered A-Z, Z-A, price asc, price desc | InventoryTests.testSortProducts |
| TC-SD-03 | Add from landing page | Click Add to cart on 3 products | Badge shows 3 | InventoryTests.testAddProductsFromLandingPage |
| TC-SD-04 | Remove from landing page | Add 3, remove 1, then remove rest | Badge 2, then disappears | InventoryTests.testRemoveProductFromLandingPage |
| TC-SD-05 | View cart products | Add 2 products → open cart | Cart lists the same 2 products | CartTests.testViewCartProducts |
| TC-SD-06 | Fill checkout form | Cart → Checkout → fill info → Continue → Finish | "Thank you for your order!" | CheckoutTests.testFillCheckoutFormAndCompleteOrder |
| TC-SD-06b | Checkout validation | Leave First Name empty → Continue | "First Name is required" | CheckoutTests.testCheckoutFormValidation |
| TC-SD-07 | Cancel checkout | Start checkout → Cancel | Back on cart, items preserved | CheckoutTests.testCancelCheckout |
| TC-SD-08 | Remove from cart | Add 3 → remove 2 → remove last | 1 item left, then empty | CartTests.testRemoveProductsFromCart |
| TC-SD-09 | Checkout of empty cart | Open empty cart → Checkout | Checkout is blocked (known defect: site allows it) | CartTests.testCheckoutOfEmptyCart |
| TC-SD-10 | Logout | Menu → Logout | Login page displayed | LoginTests.testLogout |