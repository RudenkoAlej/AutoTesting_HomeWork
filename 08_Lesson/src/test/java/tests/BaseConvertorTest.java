package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.Config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public WebDriver driver;
    public final Properties config = Config.loadProperties("resource.properties");

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseurl"));
        }

    @AfterMethod
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
