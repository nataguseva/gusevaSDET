package ru.list.nataguseva.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BrowserStartPage extends BasePage{

    WebDriver driver;

    @FindBy(css = "\".desk-notif-card__login-new-item_enter\"")
    WebElement mailButton;

    public BrowserStartPage(WebDriver driver) {
        super(driver);
    }
    public void clickMailBtn() {
    mailButton.click();
    }
}


