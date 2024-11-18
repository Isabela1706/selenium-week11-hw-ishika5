package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify the text ‘Welcome Back!’
        String expectedWelcomeMessage = "Welcome Back!";
        String actualWelcomeMessage = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals("Welcome Sign", expectedWelcomeMessage, actualWelcomeMessage);

    }

    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter the invalid username
        driver.findElement(By.id("user[email]")).sendKeys("Dexpatel123@gmail.com");
        //Enter the invalid password
        driver.findElement(By.name("user[password]")).sendKeys("dex123");

        //Click on the ‘Sign in’ button
        driver.findElement(By.xpath("//button [@type = 'submit']")).click();

        //Verify the error message ‘Invalid email or password.’
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//li [@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("Invalid message",expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();

    }
}
