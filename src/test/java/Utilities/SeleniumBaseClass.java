package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleniumBaseClass {
    Properties prop = null;
    ChromeDriver driver;

    public WebDriver setUp() throws IOException {
        Properties prop = readPropertiesFile(".\\resources\\Property\\essential.properties");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
//        this.getPropertyValue("url");
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;

    }

/*    public static Properties readPropertiesFile(String fileName) {

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
    }*/

    public Properties readPropertiesFile(String fileName) throws IOException {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource(fileName);
        props.load(url.openStream());
        System.out.println(props);
        return props;
    }

    public String getPropertyValue(String key){
        return this.prop.getProperty(key);
    }


}