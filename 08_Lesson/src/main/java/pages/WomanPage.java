package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

import java.util.List;

import static java.lang.Thread.sleep;

public class WomanPage extends SearchPage{
    private TestHelper helper = new TestHelper(driver);

    @FindBy(xpath = "//*[@id='layered_price_slider']/div")
    private WebElement priceSlider;

    @FindBy(xpath = "//*[@id='layered_price_range']")
    private WebElement priceSliderRange;

    @FindBy(xpath = "//*[@id='layered_price_slider']/a[1]")
    private WebElement priceSliderLeftControl;

    @FindBy(xpath = "//*[@id='layered_price_slider']/a[2]")
    private WebElement priceSliderRightControl;


    public WomanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String[] getPricesRange() {
        helper.waitElementDisplayed(5, priceSlider);
        helper.scrollToItem(priceSliderRange);
        String rangeLine = priceSliderRange.getAttribute("innerHTML");
        return rangeLine.split("\\$");
    }

    public int getMinInitRange() {
        String[] rangeParts = getPricesRange();
        String[] minBorder = rangeParts[1].split("\\.");

        return Integer.valueOf(minBorder[0]);
    }

    public int getMaxInitRange() {
        String[] rangeParts = getPricesRange();
        String[] maxBorder = rangeParts[2].split("\\.");

        return Integer.valueOf(maxBorder[0]);
    }

    public void setSliderRange (int minFilterPriceValue, int maxFilterPriceValue) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('style', 'left: 30%;')", priceSliderLeftControl);

        js.executeScript("arguments[0].setAttribute('style', 'left: 70%;')", priceSliderRightControl);
    }

    public WomanPage setMinPriceFilter(int minFilterPriceValue) {
        double priceRangeStepNumber = getMaxInitRange() - getMinInitRange();

        double persentForOneStep = 100/priceRangeStepNumber;
        double minFilterInPersents = (minFilterPriceValue - getMinInitRange()) * persentForOneStep;
        int width = priceSlider.getSize().getWidth();

        Actions move = new Actions(driver);
        move.dragAndDropBy(priceSliderLeftControl, (int) Math.round(width*minFilterInPersents/100), 0).perform();
        return new WomanPage(driver);
    }

    public WomanPage setMaxPriceFilter(int maxFilterPriceValue) {
        double priceRangeStepNumber = getMaxInitRange() - getMinInitRange();

        double persentForOneStep = 100/priceRangeStepNumber;
        double minFilterInPersents = (maxFilterPriceValue - getMaxInitRange()) * persentForOneStep;
        int width = priceSlider.getSize().getWidth();

        Actions move = new Actions(driver);
        move.dragAndDropBy(priceSliderRightControl, (int) Math.round(width*minFilterInPersents/100), 0).perform();
        return new WomanPage(driver);
    }


}
