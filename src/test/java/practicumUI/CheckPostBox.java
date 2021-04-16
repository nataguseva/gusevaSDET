package practicumUI;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPostBox {
    private final String login = new String("nataguseva.sdet.practicum");
    private final String password = new String("sdet.practicum.12.04.2021");
    private final String theme = new String("Simbirsoft theme");


        WebDriver driver;
        @Before
        public void Authorize() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_89.0.4389.23");

            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, 10);

            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://yandex.ru");

            WebElement enter;
            enter = driver.findElement(By.cssSelector("a[data-statlog=\"notifications.mail.logout.enter\"]"));
            enter.click();


            WebElement loginField;
            loginField = driver.findElement(By.id("passp-field-login"));
            loginField.click();
            loginField.sendKeys(login);
            loginField.sendKeys(Keys.ENTER);
            //driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

            WebElement passwordField;
            passwordField = driver.findElement(By.id("passp-field-passwd"));
            //passwordField.click();
            passwordField.sendKeys(password);
            passwordField.sendKeys(Keys.ENTER);

            WebElement postBox = driver.findElement(By.className("desk-notif-card__mail-title"));
            postBox.click();


            WebElement searchField = driver.findElement(By.className("textinput__control"));
            searchField.click();

            //searchField.sendKeys(theme);
            //searchField.sendKeys(Keys.ENTER);


        }

        @Test
        public void checkPostBox() {
            System.out.println(login);


//*[@id="root"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/ul[2]

            /*WebElement editingViewPort;
            editingViewPort = driver.findElement(By.cssSelector("input"));
            editingViewPort.sendKeys("калькулятор");
            editingViewPort.sendKeys(Keys.ENTER);


            driver.findElement(By.cssSelector("div[aria-label=\"открывающая скобка\"]")).click();
            driver.findElement(By.cssSelector("div[jsname=\"N10B9\"]")).click();//1
            driver.findElement(By.cssSelector("div[aria-label=\"сложение\"]")).click();
            driver.findElement(By.cssSelector("div[jsname=\"lVjWed\"]")).click();//2
            driver.findElement(By.cssSelector("div[aria-label=\"закрывающая скобка\"]")).click();

            driver.findElement(By.cssSelector("div[aria-label=\"умножение\"]")).click();
            driver.findElement(By.cssSelector("div[jsname=\"KN1kY\"]")).click();//3
            driver.findElement(By.cssSelector("div[aria-label=\"вычитание\"]")).click();
            driver.findElement(By.cssSelector("div[jsname=\"xAP7E\"]")).click();//4
            driver.findElement(By.cssSelector("div[jsname=\"bkEvMb\"]")).click();//0
            driver.findElement(By.cssSelector("div[aria-label=\"деление\"]")).click();
            driver.findElement(By.cssSelector("div[jsname=\"Ax5wH\"]")).click();//5
            driver.findElement(By.cssSelector("div[aria-label=\"равно\"]")).click();



            String note = driver.findElement(By.cssSelector("span[jsname=\"ubtiRe\"]")).getText();
            assert ("(1 + 2) × 3 - 40 ÷ 5 =").equals(note);

            String result = driver.findElement(By.cssSelector("span[jsname=\"VssY5c\"]")).getText();
            assert "1".equals(result);*/

            //driver.quit();
        }
    }

