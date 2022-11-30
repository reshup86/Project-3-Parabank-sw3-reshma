package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"),"harekrishna1");
        sendTextToElement(By.name("password"),"hareram");
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        verifyText(By.xpath("//h1[contains(text(),'Accounts Overview')]"),"Accounts Overview");
    }

    @Test
    public void verifyTheErrorMessage() {
        sendTextToElement(By.name("username"),"");
        sendTextToElement(By.name("password"),"harekrishna");
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        verifyText(By.xpath("//p[contains(text(),'Please enter a username and password.')]"), "Please enter a username and password.");
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        sendTextToElement(By.name("username"),"harekrishna1");
        sendTextToElement(By.name("password"),"hareram");
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        verifyText(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
