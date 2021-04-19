package ru.list.nataguseva.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage {

    WebDriver driver;
    String mailBtnLocator = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/ul/ul/li[1]/a";
    String accountBtnLocator = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/a[1]";

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/a[1]")
    WebElement accountBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/ul/ul/li[1]/a")
    WebElement mailBtn;


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountBtn() {
        (new WebDriverWait(driver, 4)).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath(accountBtnLocator)));
        accountBtn.click();
    }
    public void clickMailBtn() {
        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath(mailBtnLocator)));
        mailBtn.click();
    }
}

