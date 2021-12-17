package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class CartPaymentPage extends CartSummaryPage {
    private TestHelper helper;

    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement chartIcon;

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@class='cart_total']/span[@class='price']")
    private WebElement generalTotalEl;

    public CartPaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        helper = new TestHelper(driver);
    }

    public boolean isCartPaymentTabOpened() {
        if (chartIcon.getText().equals("Your payment method")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getGeneralTotal() {
        Double generalTotal = Double.parseDouble(generalTotalEl.getText().substring(1));
        return generalTotal;
    }

    @Override
    public double getProductQuantity(String productName) {
        WebElement productQuantityEl = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//*[starts-with(@class, 'cart_quantity')]/span"));
        Double unitPrice = Double.parseDouble(productQuantityEl.getText());
        return unitPrice;
    }
}
