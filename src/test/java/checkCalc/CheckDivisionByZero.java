package checkCalc;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckDivisionByZero {
    WebDriver driver;

    @Test
    public void checkDivisionByZero() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_89.0.4389.23");

        driver = new ChromeDriver();
        driver.get("http://google.com");

        WebElement editingViewPort;
        editingViewPort = driver.findElement(By.cssSelector("input"));
        editingViewPort.sendKeys("калькулятор");
        editingViewPort.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("div[jsname=\"abcgof\"]")).click();//6
        driver.findElement(By.cssSelector("div[aria-label=\"деление\"]")).click();
        driver.findElement(By.cssSelector("div[jsname=\"bkEvMb\"]")).click();//0
        driver.findElement(By.cssSelector("div[aria-label=\"равно\"]")).click();

        String note = driver.findElement(By.cssSelector("span[jsname=\"ubtiRe\"]")).getText();
        assert note.equals("6 ÷ 0 =");

        String result = driver.findElement(By.cssSelector("span[jsname=\"VssY5c\"]")).getText();
        assert "Infinity".equals(result);

        driver.quit();
    }

}
