package TestClasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObjects_Methods.LoginPageObjects;
import PageObjects_Methods.RegistrationPageObject;
import Utilities.SeleniumBaseClass;

public class RegistrationTest {

	public class RegistraionTest extends SeleniumBaseClass {
		boolean registered;
		LoginPageObjects loginpg;
		RegistrationPageObject registrationpg;
		WebDriver driver;

		@Test
		public void registration() throws IOException, InterruptedException {
			registered=true;
			driver = setUp();
			loginpg = new LoginPageObjects(driver);
			registrationpg = new RegistrationPageObject(driver);
			Properties prop = readPropertiesFile(".\\resources\\Property\\essential.properties");

			registrationpg.registration(prop.getProperty("Fname"), prop.getProperty("Lname"),
					prop.getProperty("registerEmail"), prop.getProperty("company"), prop.getProperty("registerPassword"),
					prop.getProperty("cpassword"), prop.getProperty("phone"), prop.getProperty("provider") );
			
			loginpg.login(prop.getProperty("registerEmail"), prop.getProperty("registerPassword"), registered);
		}
	}

}