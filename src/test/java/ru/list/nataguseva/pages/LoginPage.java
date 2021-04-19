package ru.list.nataguseva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.list.nataguseva.ConfProperties;

import java.time.Duration;
import java.util.Objects;

public class LoginPage {

    WebDriver driver;
    public WebDriverWait wait;
    private final String login  = ConfProperties.getProperty("login");
    private final String password = ConfProperties.getProperty("password");

    public String loginFieldLocator = "//input[@data-t='field:input-login']";
    public String passwordFieldLocator = "//input[@data-t='field:input-passwd']";
    public String submitBtnLocator = "//button[@type='submit']";


    @FindBy(xpath="//input[@data-t='field:input-login']")
    WebElement loginField;

    @FindBy(xpath= "//input[@data-t='field:input-passwd']")
    WebElement passwdField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    /**
     * конструктор
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    /**
    public String getLoginFieldLocator() {
        return loginFieldLocator;
    }

    public String getPasswordFieldLocator() {
        return passwordFieldLocator;
    }
*/

    public void setLogin(String login) {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginFieldLocator)));
        System.out.println(loginField.getTagName());
        loginField.sendKeys(login);

    }
    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordFieldLocator)));
        passwdField.sendKeys(password, Keys.ENTER);
    }


    public void authorize(String login, String password) {
        this.setLogin(login);
        this.clickSubmitBtn();
        this.setPassword(password);
        this.clickSubmitBtn();
       // wait.until(ExpectedConditions.urlContains(""))
    }

}

