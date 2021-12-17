package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    protected WebDriver driver;


    @FindBy(xpath = "//input[@id='LocationSearch_input']")
    protected WebElement searchField;

    @FindBy(xpath = "//*[@name='location']")
    protected WebElement findBtn;

    @FindBy(xpath = "//div[@id='LocationSearch_listbox']/button[1]")
    protected WebElement firstFoundOption;

    @FindBy(xpath = "//span[@data-testid='TemperatureValue']")
    protected WebElement fahrenheitTemperature;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage selectCity(String text) {

    new WebDriverWait(driver, 20).until(
                    ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys(text);
        Actions actions = new Actions(driver);
        actions.moveToElement(searchField)
                .clickAndHold()
                .click(firstFoundOption)
                .release()
                .perform();
        return new MainPage(driver);
    }

    public int getTemperature() {
        return (int) Integer.parseInt(fahrenheitTemperature.getText().substring(0,2));
    }
}
