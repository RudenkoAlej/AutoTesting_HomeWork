package tests;

import model.Account;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;


public class ShopTest extends BaseTest{
    private MainPage mainPage;
    private SearchPage searchPage;
    private WomanPage womanPage;
    private CartSummaryPage cartSummaryPage;


    @BeforeMethod
    public void openInitialPage() {
        mainPage = new MainPage(driver);
    }

    @Test()
    public void checkWomanTabIsOpened() {
        womanPage = mainPage.womanBtnClick();

        Assert.assertTrue(womanPage.isWomanTabSelected());
    }

    @Test()
    public void checkWomanTabPriceFilter() {
        womanPage = mainPage.womanBtnClick();
        int maxFilter = 45;
        int minFilter = 25;

        womanPage.setMinPriceFilter(minFilter)
                 .setMaxPriceFilter(maxFilter);

        Assert.assertEquals(womanPage.getMaxInitRange(), maxFilter);
        Assert.assertEquals(womanPage.getMinInitRange()+1, minFilter);
    }

    @Test()
    public void checkProductsAdded() {

        womanPage = mainPage.womanBtnClick();

        List<WebElement> filteredByName = womanPage.allProductsWithName("Dress");
        List<WebElement> filteredByDiscount = womanPage.allProductsWithDiscount();
        List<WebElement> filteredByTwoParameters = womanPage.combineProductFilteredElements(filteredByName, filteredByDiscount);
        womanPage.addAllProducts(filteredByTwoParameters);

        Assert.assertTrue(womanPage.checkCartIsNotEmpty());
    }

    @Test()
    public void checkCartIsOpened() {
        searchPage = mainPage.findProduct("Dresses").listModeOn().addFirstProductAction();

        cartSummaryPage = searchPage.openCart();

        Assert.assertTrue(cartSummaryPage.isCartPageOpened());
    }

    @Test()
    public void checkProductDelete() {
        womanPage = mainPage.womanBtnClick();

        List<WebElement> filteredByName = womanPage.allProductsWithName("Dress");
        List<WebElement> filteredByDiscount = womanPage.allProductsWithDiscount();
        List<WebElement> filteredByTwoParameters = womanPage.combineProductFilteredElements(filteredByName, filteredByDiscount);
        womanPage.addAllProducts(filteredByTwoParameters);

        cartSummaryPage = womanPage.openCart();

        double highestPrice = cartSummaryPage.getHighestPrice();

        cartSummaryPage.deleteProductByPrice(highestPrice);
        Assert.assertFalse(cartSummaryPage.productIsInChart(highestPrice));
    }

}
