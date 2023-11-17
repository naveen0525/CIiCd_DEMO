package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleniumBaseClass {
    EdgeDriver driver;

    public WebDriver setUp() {
        Properties prop = readPropertiesFile(".\\resources\\Property\\essential.properties");

        System.setProperty("webdriver.edge.driver", "\\E:\\F Drive\\amit\\CiCd_Testing\\FM_Test\\resources\\drivers\\edge\\msedgedriver.exe");

     /*   EdgeOptions options = new EdgeOptions();
        // ChromeDriver is just AWFUL because every version or two it breaks unless you pass cryptic arguments
        //AGRESSIVE: options.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
        options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
*/
        // Set up the wWebDriverManager for chrome driver
//        WebDriverManager.edgedriver().setup();
        // Create the driver object

        driver = new EdgeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
    }

    public static Properties readPropertiesFile(String fileName) {
        FileInputStream fis;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        }

        return prop;
    }
}