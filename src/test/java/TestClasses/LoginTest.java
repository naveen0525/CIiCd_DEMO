package TestClasses;

import PageObjects_Methods.LoginPageObjects;
import Utilities.SeleniumBaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class LoginTest extends SeleniumBaseClass {
    LoginPageObjects loginPg;
    WebDriver driver;


    @Test
    public void login() throws IOException, InterruptedException {
        driver = setUp();
        loginPg = new LoginPageObjects(driver);
//        Properties prop = readPropertiesFile(".\\resources\\Property\\essential.properties");

//        loginPg.login(prop.getProperty("loginEmail"),prop.getProperty("loginPassword"), false);
        loginPg.login("admin1@yopmail.com","Federal@123", false);
    }
}