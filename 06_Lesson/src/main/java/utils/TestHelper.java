package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TestHelper {
    private WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static int randomInt(){
        Random rn = new Random();
        return rn.nextInt();
    }

    public WebElement waitOnElement(int seconds, String xpath) {
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
        );
    }

    public void scrollToItem(WebElement el){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", el);
    }
}
