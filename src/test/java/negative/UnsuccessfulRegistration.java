package negative;

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

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UnsuccessfulRegistration {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver" , "C:\\Program Files\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://shop.pragmatic.bg");

    }

    @Test
    public void unsuccessfulRegistrationTest() {

        driver.findElement(By.className("caret")).click();
        driver.findElement(By.linkText("Register")).click();
        assertEquals(driver.getTitle() , "Register Account");

        driver.findElement(By.cssSelector(".pull-right > .btn")).click();

        WebElement firstNameMessage = driver.findElement(By.cssSelector("#input-firstname+div"));
        assertEquals(firstNameMessage.getText() , "First Name must be between 1 and 32 characters!");

        WebElement lastNameMessage = driver.findElement(By.cssSelector("#input-lastname+div"));
        assertEquals(lastNameMessage.getText() , "Last Name must be between 1 and 32 characters!");

        WebElement emailMessage = driver.findElement(By.cssSelector("#input-email+div"));
        assertEquals(emailMessage.getText() , "E-Mail Address does not appear to be valid!");

        WebElement telephoneMessage = driver.findElement(By.cssSelector("#input-telephone+div"));
        assertEquals(telephoneMessage.getText() , "Telephone must be between 3 and 32 characters!");

        WebElement passwordMessage = driver.findElement(By.cssSelector("#input-password+div"));
        assertEquals(passwordMessage.getText() , "Password must be between 4 and 20 characters!");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
