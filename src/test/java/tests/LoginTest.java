package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void userCanLoginSuccssfully() {

        productsPage = new LoginPage(driver).loginSuccessfully();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));


    }

    @Test
    public void invalidUsername() {
        loginPage.addUsername("sta");
        loginPage.addPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.errorMsgVisible());
    }

    @Test
    public void invalidPassword() {
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
