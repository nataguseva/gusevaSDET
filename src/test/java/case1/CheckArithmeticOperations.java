package case1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckArithmeticOperations {

    @Test
    public void checkArithmeticOperations() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_89.0.4389.23");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        WebElement editingViewPort;
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
        System.out.println(note);
         assert note.equals("(1 + 2) × 3 - 40 ÷ 5 =");
         String result = driver.findElement(By.cssSelector("span[jsname=\"VssY5c\"]")).getText();
         assert "1".equals(result);


        driver.quit();
    }
}
