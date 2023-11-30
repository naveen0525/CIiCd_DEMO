package TestClasses;

import PageObjects_Methods.LoginPageObjects;
import Utilities.SeleniumBaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class LoginTest extends SeleniumBaseClass {
    LoginPageObjects loginPg;
    WebDriver driver;
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    //helps to generate the logs in the test report.
    ExtentTest test;

    @BeforeTest
    public static void beforeTest() {
 //        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/extentReport.html");
        htmlReporter = new ExtentHtmlReporter("test-output/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @Test
    public void login() throws IOException, InterruptedException, URISyntaxException {
        driver = setUp();
        loginPg = new LoginPageObjects(driver);
        Properties prop = readPropertiesFile("./src/resources/Property/essential.properties");

        loginPg.login(prop.getProperty("loginEmail"), prop.getProperty("loginPassword"), false);

        test = extent.createTest("Test Case 2", "The test case 2 has failed");
//        test.log(Status.PASS, result.getTestName());
        String expectedTitle = "Micro | Providers";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

        //to write or update test information to reporter
        extent.flush();

    }
}
