package MyFinalProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties prop;  //instance variable

    public static WebDriver getDriver() throws IOException {   //method to get driver - browser
        prop = new Properties();     // initiating object
        FileInputStream fis = new FileInputStream("C:/Users/zhanna/IdeaProjects/MyFinalProject/src/test/java/MyFinalProject/global.properties");
        prop.load(fis);

      //  System.setProperty("webdriver.chrome.driver","C:/Users/zhanna/Downloads/chromedriver_win32/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        return driver;
    }

}
