package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Verify the text ‘Signing up is easy!’
        verifyText(By.xpath("//h1[contains(text(),'Signing up is easy!')]"),"Signing up is easy!");
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Krishna");
        //Enter last name
        sendTextToElement(By.id("customer.lastName"),"Radhe");
        //Enter address
        sendTextToElement(By.name("customer.address.street"),"108 Gokul Vrindavan");
        sendTextToElement(By.name("customer.address.city"),"Mathura");
        sendTextToElement(By.name("customer.address.state"),"UP");
        sendTextToElement(By.name("customer.address.zipCode"),"50653");
        sendTextToElement(By.name("customer.phoneNumber"),"82436092");
        sendTextToElement(By.name("customer.ssn"),"0101010");
        sendTextToElement(By.name("customer.username"),"harekrishna1");
        sendTextToElement(By.name("customer.password"),"hareram");
        sendTextToElement(By.name("repeatedPassword"),"hareram");
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        verifyText(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"),"Your account was created successfully. You are now logged in.");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
