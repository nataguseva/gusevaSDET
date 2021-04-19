package ru.list.nataguseva.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BrowserStartPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru']")
    WebElement mailBtn;

    public BrowserStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
/**
 * метод, возвращающий инстанс следующей страницы после нажатия кнопки
     public LoginPage clickMailBtn() throws InterruptedException {
        mailBtn.click();
         WebDriverWait wait = new WebDriverWait(driver, 15);
         wait.until(ExpectedConditions.urlContains("passport"));
         return new LoginPage(driver);
      }*/
public void clickMailBtn() {
    mailBtn.click();
    }
}


