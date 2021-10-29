package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class SearchPage {
    private WebDriver driver;
    private TestHelper helper;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper = new TestHelper(driver);
    }

    @FindBy(css = "#list")
    private WebElement listModeIcon;

    @FindBy(xpath = "//*[contains(@class, 'button-container col-xs-7')]/a[contains(@class, 'ajax')]")
    private WebElement addToChartBtn;

    @FindBy(xpath = "//*[@class='button-container']/a")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@class='button-container']/span")
    private WebElement continueShoppingBtn;

    @FindBy(css = "[class^='product_list'] [class='product-name'")
    private WebElement productLbl;

    public SearchPage listModeOn() {
        helper.waitElementDisplayed(2, listModeIcon);
        listModeIcon.click();
        helper.waitForSeconds(2);
        return this;
    }

    public CartPage addToChartAndCheckChart() {
        helper.waitElementClickable(5, addToChartBtn);
        addToChartBtn.click();
        proceedToCheckoutBtn.click();
        return new CartPage(driver);
    }
    public SearchPage addToChartAndProceedPurchases() {
        addToChartBtn.click();
        continueShoppingBtn.click();
        return new SearchPage(driver);
    }

    public String getProductName() {
        String productName = productLbl.getText();
        return productName;
    }

    public boolean isListViewSelected() {
        return helper.isElementSelected(listModeIcon);
    }

}
