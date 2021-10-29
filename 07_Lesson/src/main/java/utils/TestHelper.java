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

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public WebElement waitElementClickable(int seconds, String xpath) {
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
        );
    }

    public WebElement waitElementClickable(int seconds, WebElement element) {
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementDisplayed(int seconds, WebElement element) {
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementDisplayed(int seconds, String xpath) {
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
        );
    }

    public void scrollToItem(WebElement el){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", el);
    }

    public boolean isElementSelected(WebElement el) {
        String s = el.getAttribute("class");
        return s.equals("selected");
    }
}
