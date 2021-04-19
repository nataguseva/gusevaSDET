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


public class LoginPage {

    WebDriver driver;

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



    public void setLogin(String login) {
        (new WebDriverWait(driver, 4)).
                until(loginField.isDisplayed();
        System.out.println(loginField.getTagName());
        loginField.sendKeys(login, Keys.ENTER);

    }
    public void clickSubmitBtn() {
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.
                        presenceOfElementLocated(By.xpath(submitBtnLocator)));
        submitBtn.click();
    }

    public void setPassword(String password) {
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.
                        presenceOfElementLocated(By.xpath(passwordFieldLocator)));
        passwdField.sendKeys(password, Keys.ENTER);
    }


    public void authorize(String login, String password) {
        this.setLogin(login);
        (new WebDriverWait(driver, 6)).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath(passwordFieldLocator)));
        this.setPassword(password);
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.urlContains("profile"));
    }

}

