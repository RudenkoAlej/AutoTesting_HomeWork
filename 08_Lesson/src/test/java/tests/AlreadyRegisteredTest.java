package tests;

import model.Account;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class NewTest extends BaseTest{
    private MainPage mainPage;
    private Account account;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;
    private DressesPage dressesPage;
    private WomanPage womanPage;
    private SizeOptions sizeOptions;
    private CartSummaryPage cartSummaryPage;
    private CartAddressPage cartAddressPage;
    private CartShippingPage cartShippingPage;
    private CartPaymentPage cartPaymentPage;

    @BeforeMethod
    public void openInitialPage() {
        mainPage = new MainPage(driver);
    }

    @Test()
    public void checkDressesTabIsOpened() {
        womanPage = mainPage.womanBtnClick();

        Assert.assertTrue(womanPage.isWomanTabSelected());
    }

    @Test()
    public void checkFilterPrices() {

        womanPage = mainPage.womanBtnClick();

        int minFilterPriceValue = 25;
        int maxFilterPriceValue = 45;

        womanPage.setMinPriceFilter(minFilterPriceValue);
        womanPage.setMaxPriceFilter(maxFilterPriceValue);

        List<WebElement> filteredByName = womanPage.allProductsWithName("Dress");
        List<WebElement> filteredByDiscount = womanPage.allProductsWithDiscount();
        List<WebElement> filteredByTwoParameters = womanPage.combineProductFilteredElements(filteredByName, filteredByDiscount);
        womanPage.addAllProducts(filteredByTwoParameters);

        cartSummaryPage = womanPage.openCart();

        double highestPrice = cartSummaryPage.getHighestPrice();
        cartSummaryPage.deleteProductByPrice(highestPrice);

    }

}
