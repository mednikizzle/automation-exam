package positive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver" , "C:\\Program Files\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg");

    }

    @Test
    public void successfulLoginTest() {

        driver.findElement(By.className("caret")).click();
        driver.findElement(By.linkText("Login")).click();
        assertEquals(driver.getTitle() , "Account Login");

        driver.findElement(By.name("email")).sendKeys("kiril99kiril@abv.bg");
        driver.findElement(By.name("password")).sendKeys("parola1parola");

        driver.findElement(By.cssSelector(".form-group+.btn")).click();

        assertEquals(driver.getTitle() , "My Account");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
