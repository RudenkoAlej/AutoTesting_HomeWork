package pages.converter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.DressesPage;
import pages.SearchPage;
import pages.SignInPage;
import pages.WomanPage;
import utils.TestHelper;

public class ConvertorPage {
    protected WebDriver driver;
    private TestHelper helper;

    @FindBy(id = "currency_amount")
    private WebElement inputSum;

    @FindBy(xpath = "//p[@id='UAH']//input[@id='currency_rate']")
    private WebElement rateUAH;

    @FindBy(xpath = "//p[@id='UAH']//input[@id='currency_exchange']")
    private WebElement resultUAH;

    @FindBy(xpath = "//p[@id='EUR']//input[@id='currency_rate']")
    private WebElement rateEUR;

    @FindBy(xpath = "//p[@id='EUR']//input[@id='currency_exchange']")
    private WebElement resultEUR;

    @FindBy(xpath = "//p[@id='RUB']//input[@id='currency_rate']")
    private WebElement rateRUB;

    @FindBy(xpath = "//p[@id='RUB']//input[@id='currency_exchange']")
    private WebElement resultRUB;

    @FindBy(xpath = "//p[@id='PLN']//input[@id='currency_rate']")
    private WebElement ratePLN;

    @FindBy(xpath = "//p[@id='PLN']//input[@id='currency_exchange']")
    private WebElement resultPLN;

    private By advert = new By.ByClassName("achernar__closeControl");

    public ConvertorPage(WebDriver driver) {
        this.driver = driver;
        helper = new TestHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public ConvertorPage inputSum(String sum){
//        helper.
        inputSum.clear();
        inputSum.sendKeys(sum);
        return new ConvertorPage(driver);
    }

    public Double getRateUAH() {
        return Double.valueOf(rateUAH.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getResultUAH() {

        return Double.valueOf(resultUAH.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getRateEUR() {
        return Double.valueOf(rateEUR.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getResultEUR() {

        return Double.valueOf(resultEUR.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getRateRUB() {
        return Double.valueOf(rateRUB.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getResultRUB() {

        return Double.valueOf(resultRUB.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getRatePLN() {
        return Double.valueOf(ratePLN.getAttribute("value").replaceAll(" ", ""));
    }

    public Double getResultPLN() {

        return Double.valueOf(resultPLN.getAttribute("value").replaceAll(" ", ""));
    }
}
