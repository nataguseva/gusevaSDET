package ru.list.nataguseva;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.list.nataguseva.pages.BrowserStartPage;
import ru.list.nataguseva.pages.LoginPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.list.nataguseva.pages.ProfilePage;


public class MailBoxTest {
    static WebDriver driver;
    private  String login;
    private  String password;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    BrowserStartPage browserStartPage;
    LoginPage loginPage;
    ProfilePage profilePage;



    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("geckodriver"));
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = ConfProperties.getProperty("URL");
        driver.get(url);

    }

    @Test
    public void mailBoxTest() {
        browserStartPage = new BrowserStartPage(driver);
        browserStartPage.clickMailBtn();
        //wait.until(ExpectedConditions.titleIs("авторизация"));

        /**
         * позорный костыль
         */
        driver.get("https://passport.yandex.ru/auth");
        loginPage = new LoginPage(driver);
        login = loginPage.getLogin();
        password = loginPage.getPassword();
        loginPage.authorize(login, password);


        /**
         * позорный костыль
         */
        driver.get("https://passport.yandex.ru/profile");

        profilePage = new ProfilePage(driver);
        profilePage.clickAccountBtn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://mail.yandex.ru\"]")));
        profilePage.clickMailBtn();


        /*
        //получаем отображаемый логин
        //String user = profilePage.getUserName();
        //и сравниваем его с логином из файла настроек
        //Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }

    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    /*@AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userLogout();
        driver.quit();
    }
    */
    }
}