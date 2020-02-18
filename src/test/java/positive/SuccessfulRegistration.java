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

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class SuccessfulRegistration {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver" , "C:\\Program Files\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg");

    }

    @Test
    public void successfulRegistrationTest() {

        driver.findElement(By.className("caret")).click();
        driver.findElement(By.linkText("Register")).click();
        assertEquals(driver.getTitle() , "Register Account");

        driver.findElement(By.name("firstname")).sendKeys("Kiril");
        driver.findElement(By.name("lastname")).sendKeys("Kirilov");
        driver.findElement(By.name("email")).sendKeys("kiril99kiril@abv.bg");
        driver.findElement(By.name("telephone")).sendKeys("0888010010");
        driver.findElement(By.name("password")).sendKeys("parola1parola");
        driver.findElement(By.name("confirm")).sendKeys("parola1parola");

        WebElement subscribeRadioButton = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value=1]"));

        if (!subscribeRadioButton.isSelected()) {
            subscribeRadioButton.click();
        }
        assertTrue(subscribeRadioButton.isSelected());

        WebElement privacyPolicyButton = driver.findElement(By.name("agree"));

        if (!privacyPolicyButton.isSelected()) {
            privacyPolicyButton.click();
        }
        assertTrue(privacyPolicyButton.isSelected());

        driver.findElement(By.cssSelector(".pull-right > .btn")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver , 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pull-right .btn")));

        assertEquals(driver.getTitle(), "Your Account Has Been Created!");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
