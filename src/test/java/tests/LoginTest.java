package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;


public class LoginTest extends TestBase {
//    private LoginPage loginPage ;

    @Test
    public void userCanLoginSuccssfully() {
//        productsPage = new ProductsPage(driver);
//        productsPage.userLogout();
//        loginPage = new LoginPage(driver);

        loginPage.addUsername("standard_user");
        loginPage.addPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/v1/inventory.html"));
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void invalidUsername() {
//        productsPage = new ProductsPage(driver);
//        productsPage.userLogout();
//        loginPage = new LoginPage(driver);

        loginPage.addUsername("sta");
        loginPage.addPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.errorMsgVisible());
    }

    @Test
    public void invalidPassword() {
//        productsPage = new ProductsPage(driver);
//        productsPage.userLogout();
//        loginPage = new LoginPage(driver);

        loginPage.addUsername("standard_user");
        loginPage.addPassword("secret");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.errorMsgVisible());
    }

    @Test
    public void emptyPassword() {

        loginPage.addUsername("standard_user");
        loginPage.addPassword("");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.errorMsgEmptyVisible());
    }

}
