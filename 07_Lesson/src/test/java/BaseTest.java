import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public WebDriver driver;
    public final Properties config = Config.loadProperties("resource.properties");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(config.getProperty("baseurl"));
        }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
