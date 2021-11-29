package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class CartShippingPage extends CartSummaryPage {
    private TestHelper helper;

    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement chartIcon;

    @FindBy(xpath = "//div[@id='uniform-cgv']//input")
    private WebElement iAgreeCheckBox;

    @FindBy(xpath = "//button[@name='processCarrier']")
    private WebElement proceedToCheckoutBtn;

    public CartShippingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        helper = new TestHelper(driver);
    }

    public boolean isCartShippingTabOpened() {
        if (chartIcon.getText().equals("Shipping")) {
            return true;
        } else {
            return false;
        }
    }

    public CartShippingPage iAgreeClick() {
        helper.scrollToItem(iAgreeCheckBox);
        iAgreeCheckBox.click();
        return this;
    }

    public boolean isIAgreeChecked() {
        if (iAgreeCheckBox.isSelected())
        return true;
        else
        return false;
    }

    public CartPaymentPage proceedToCheckoutToPayment() {
        helper.waitElementDisplayed(5, proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
        return new CartPaymentPage(driver);
    }
}
