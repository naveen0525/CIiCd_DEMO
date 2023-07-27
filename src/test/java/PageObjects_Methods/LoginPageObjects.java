package PageObjects_Methods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageObjects {

    final WebDriver driver;

    @FindBy(name= "username")
    private WebElement email;

    @FindBy(id= "password")
    private WebElement password;

    @FindBy(xpath= "//button[@type='submit']")
    private WebElement login_button;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String superAdminEmail, String superAdminPassword, boolean registered) throws InterruptedException {
        Thread.sleep(1000);
        if (!registered) {
            List<WebElement> loginLink = driver.findElements(By.xpath("//a[@class=\"nav-link\"]"));
            loginLink.get(0).click();
        }

        this.email.sendKeys(superAdminEmail);
        this.password.sendKeys(superAdminPassword);
        Thread.sleep(2000);
        login_button.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Provider 1 | Dashboard");
    }

}
