package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase {
    //    WebDriver driver;
    private WebDriver driver;
    private WebDriverWait wait ;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)) ;
    }

    // Locators
    @FindBy(id = "user-name")
    WebElement userNameTxtBox ;
    private By userNameTxtBoxNew = By.cssSelector("input[name='user-name']");
    private By passwordTxtBoxNew = By.cssSelector("input[type='password']");
    private By loginBtnNew = By.cssSelector("input[id='login-button']");
    private By loginBtnNew2 = By.cssSelector("input[class='btn_action']");
    private By loginBtnNew3 = By.cssSelector(".btn_action");
    private By errorMsg = By.xpath("//*[contains(text() , 'Epic sadface:')]");
    private By errorMsgEmptyPass = By.cssSelector("button.error-button");

    @FindBy(id = "password")
    WebElement passwordTxtBox ;
    @FindBy(className = "btn_action")
    WebElement loginBtn;



    // Methods
//    public void userLogin(String userName, String password){
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userNameTxtBoxNew));
//        System.out.println("wait succeeded");
//        setTextElementText(userNameTxtBox, userName);
//        setTextElementText(passwordTxtBox, password);
//        clickButton(loginBtn);
//    }
    public void addUsername(String userName){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userNameTxtBoxNew));
        driver.findElement(userNameTxtBoxNew).clear();
        driver.findElement(userNameTxtBoxNew).sendKeys(userName);
    }
    public void addPassword(String password){
        driver.findElement(passwordTxtBoxNew).clear();
        driver.findElement(passwordTxtBoxNew).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginBtnNew).click();
    }
    public boolean errorMsgVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMsg));
        return driver.findElement(errorMsg).isDisplayed();
    }
    public boolean errorMsgEmptyVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMsgEmptyPass));
        return driver.findElement(errorMsgEmptyPass).isDisplayed();
    }

    public ProductsPage loginSuccessfully() {
        addUsername("standard_user");
        addPassword("secret_sauce");
        clickLogin();
        return new ProductsPage(driver);
    }


}





//package pages;
//
//import base.BasePage;
//import utilities.ConfigReader;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class LoginPage extends BasePage {
//    private static final By USERNAME = By.id("user-name");
//    private static final By PASSWORD = By.id("password");
//    private static final By LOGIN_BUTTON = By.id("login-button");
//    private static final By ERROR = By.cssSelector("[data-test='error']");
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public LoginPage open() {
//        driver.get(ConfigReader.get("base.url"));
//        return this;
//    }
//
//    public InventoryPage loginAs(String username, String password) {
//        submit(username, password);
//        return new InventoryPage(driver);
//    }
//
//    public LoginPage loginExpectingError(String username, String password) {
//        submit(username, password);
//        return this;
//    }
//
//    public String getErrorMessage() {
//        return getText(ERROR);
//    }
//
//    public boolean isLoaded() {
//        return isDisplayed(LOGIN_BUTTON);
//    }
//
//    private void submit(String username, String password) {
//        type(USERNAME, username);
//        type(PASSWORD, password);
//        click(LOGIN_BUTTON);
//    }
//}