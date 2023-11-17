package PageObjects_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageObject {

	final WebDriver driver;

	@FindBy(xpath = "//a[@class='nav-link']")
	private WebElement loginLink;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement clickOnRegistraitonButton;

	@FindBy(name = "firstname")
	private WebElement enterFirstName;

	@FindBy(name = "lastname")
	private WebElement enterLastName;

	@FindBy(name = "email")
	private WebElement enterEmail;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "password")
	private WebElement enterPassword;

	@FindBy(name = "cpass")
	private WebElement confirmPassword;

	@FindBy(name = "phone")
	private WebElement enterPhoneNumber;

	@FindBy(name = "search_provider")
	private WebElement enterProviderName;

	@FindBy(xpath = "//p[@data-id='5']")
	private WebElement suggestedName;

	@FindBy(id = "register")
	private WebElement clickOnSubmitBtn;

	public RegistrationPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void registration(String Fname, String Lname, String email, String company, String password,
			String cpassword, String phone, String provider) throws InterruptedException {
//		loginLink.click();
		clickOnRegistraitonButton.click();
		this.enterFirstName.sendKeys(Fname);
		this.enterLastName.sendKeys(Lname);
		this.enterEmail.sendKeys(email);
		this.companyName.sendKeys(company);
		this.enterPassword.sendKeys(password);
		this.confirmPassword.sendKeys(cpassword);
		this.enterPhoneNumber.sendKeys(phone);
		this.enterProviderName.sendKeys(provider);
		Thread.sleep(1000);
		suggestedName.click();
		Thread.sleep(100);
		this.clickOnSubmitBtn.click();
		
	}

}
