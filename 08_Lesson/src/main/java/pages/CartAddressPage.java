package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class CartAddressPage extends CartSummaryPage {
    private TestHelper helper;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[starts-with(@class, 'address_address1')]")
    private WebElement billingAddress;

    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement proceedToCheckoutBtn;

    public CartAddressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        helper = new TestHelper(driver);
    }

    public String getBillingAddress(){
        return billingAddress.getText();
    }

    public CartShippingPage proceedToCheckoutToShipping() {
        helper.waitElementDisplayed(5, proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
        return new CartShippingPage(driver);
    }
}
