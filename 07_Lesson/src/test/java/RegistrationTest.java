
import model.Account;
import model.AccountBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import static utils.TestHelper.randomInt;

public class RegistrationTest extends BaseTest{
    private MainPage mainPage;
    private Account account;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;
    private SearchPage dressesPage;
    private SizeOptions sizeOptions;
    private CartSummaryPage cartSummaryPage;
    private CartAddressPage cartAddressPage;
    private CartShippingPage cartShippingPage;
    private CartPaymentPage cartPaymentPage;

    @Before
    public void setupAccount() {
        account = new AccountBuilder()
                .withGender("Mr.")
                .withEmail("SomeEmail"+ randomInt() +"@gmail.com")
                .withPassword("Jack.Daniels")
                .withFirstCustomerName("Jack")
                .withSecondCustomerName("Daniels")
                .withDay("15")
                .withMonth("3")
                .withYear("1995")
                .withFirstName("Yakov")
                .withLastName("Fayn")
                .withCompany("IBM")
                .withAddress1("San Francisco 1")
                .withAddress2("Moscow 2")
                .withCity("London")
                .withState("Alabama")
                .withPostCode("02206")
                .withCountry("United States")
                .withAdditional("Some additional text")
                .withPhone("+30995652333")
                .withMobile("+30995652333")
                .withAlias("Alloha!")
                .build();
        mainPage = new MainPage(driver);
    }

    @Test()
    public void checkUserIsRegistered(){
        signInPage = mainPage.clickSignIn();
        registrationPage = signInPage.createNewAccountWithEmail(account.getEmail());
        myAccountPage = registrationPage.fillAndSubmitRegistrationForm(account);
        String actualResult = myAccountPage.getAccountName();
        String expectedResult = account.getFirstCustomerName() + " " + account.getLastCustomerName();

        Assert.assertTrue(String.format("If user name %s is not as expected = %s, then user is not registered",
                actualResult, expectedResult), actualResult.contains(expectedResult));
    }

    @Test()
    public void checkDressesTabIsOpened() {
        dressesPage = mainPage.dressesBtnClick();

        Assert.assertTrue(dressesPage.isDressesTabSelected());
    }

    @Test()
    public void checkListViewIsOn() {
        dressesPage = mainPage.dressesBtnClick();
        dressesPage.listModeOn();

        Assert.assertTrue(dressesPage.isListViewSelected());
    }

    @Test()
    public void checkFilteredBySize() {
        dressesPage = mainPage.dressesBtnClick();
        dressesPage.selectSize(sizeOptions.L);


        Assert.assertTrue(dressesPage.isSizeFilterSelected(sizeOptions.L));
    }

    @Test()
    public void checkProductsSorted() {
        String option = "Price: Lowest first";
        dressesPage = mainPage.dressesBtnClick();
        dressesPage.sortProducts(option);

        Assert.assertTrue(dressesPage.getSortOption().equals(option));
    }

    @Test
    public void checkProductsAreAddedToChart() {
        dressesPage = mainPage.dressesBtnClick().listModeOn();
        dressesPage.addFirstProductAction().continueShopping();
        dressesPage.addSecondProductAction().continueShopping();
        Assert.assertTrue("Number of added products is 0", dressesPage.checkCartIsNotEmpty());
    }

    @Test
    public void checkCartIsOpened() {
        cartSummaryPage = mainPage.dressesBtnClick()
                           .listModeOn()
                           .addFirstProductAction()
                           .proceedToCheckout();
        Assert.assertTrue("Cart page is not opened", cartSummaryPage.isCartPageOpened());
    }

    @Test
    public void checkAddedProductsPresentInChart() {
        dressesPage = mainPage.dressesBtnClick().listModeOn();
        String product1 = dressesPage.getFirstProductImage();
        String product2 = dressesPage.getSecondProductImage();
        dressesPage.addFirstProductAction().continueShopping();
        cartSummaryPage = dressesPage.addSecondProductAction().proceedToCheckout();

        Assert.assertTrue(String.format("Product %s is not added to the chart or chart is not opened",
                product1), cartSummaryPage.isProductInChart(product1));
        Assert.assertTrue(String.format("Product %s is not added to the chart or chart is not opened",
                product2), cartSummaryPage.isProductInChart(product2));
    }

    @Test
    public void checkTotalProductEqual() {
        dressesPage = mainPage.dressesBtnClick().listModeOn();
        dressesPage.addFirstProductAction().continueShopping();
        cartSummaryPage = dressesPage.addSecondProductAction().proceedToCheckout();

        double productsTotal = cartSummaryPage.getSumOfAllProductsTotal();
        double totalProducts = cartSummaryPage.getTotalProducts();

        Assert.assertEquals(String.format("Total product price: %f is not equal Total products price: %f ",
                productsTotal, totalProducts), productsTotal, totalProducts, 0.001d);
    }

    @Test
    public void checkDiscount() {
        String product = "Printed Chiffon Dress";
        cartSummaryPage = mainPage.dressesBtnClick()
                           .listModeOn()
                           .findProduct(product)
                           .addToChartAndGoToChart(product);
        double initialPrice = cartSummaryPage.getInitialPrice(product);
        double discount = cartSummaryPage.getPriceDiscount(product);
        double total = cartSummaryPage.getProductTotal(product);

        double discountedPrice = initialPrice - (initialPrice * discount / 100);

        Assert.assertEquals(String.format("Discounted product price: %f is not equal Total product price: %f ",
                discountedPrice, total), discountedPrice, total, 0.001d);
    }

    @Test
    public void checkAddress() {
        myAccountPage = mainPage.clickSignIn()
                .createNewAccountWithEmail(account.getEmail())
                .fillAndSubmitRegistrationForm(account);

        cartSummaryPage = mainPage.dressesBtnClick()
                .listModeOn()
                .addFirstProductAction()
                .proceedToCheckout();

        cartAddressPage = cartSummaryPage.proceedToCheckoutToAddress();

        String invoiceAddress = cartAddressPage.getBillingAddress();
        String expectedAddress = account.getAddress1();

        Assert.assertTrue(String.format("Billing address %s is not as expected = %s", invoiceAddress, expectedAddress),
                invoiceAddress.contains(expectedAddress));
    }

    @Test
    public void checkShippingTabOpened() {
        myAccountPage = mainPage.clickSignIn()
                .createNewAccountWithEmail(account.getEmail())
                .fillAndSubmitRegistrationForm(account);

        cartSummaryPage = mainPage.dressesBtnClick()
                .listModeOn()
                .addFirstProductAction()
                .proceedToCheckout();

        cartAddressPage = cartSummaryPage.proceedToCheckoutToAddress();

        cartShippingPage = cartAddressPage.proceedToCheckoutToShipping();

        Assert.assertTrue("Shipping tab is not opened", cartShippingPage.isCartShippingTabOpened());
    }


    @Test
    public void checkIAgreeOption() {
        myAccountPage = mainPage.clickSignIn()
                .createNewAccountWithEmail(account.getEmail())
                .fillAndSubmitRegistrationForm(account);

        cartSummaryPage = mainPage.dressesBtnClick()
                .listModeOn()
                .addFirstProductAction()
                .proceedToCheckout();

        cartAddressPage = cartSummaryPage.proceedToCheckoutToAddress();

        cartShippingPage = cartAddressPage.proceedToCheckoutToShipping().iAgreeClick();

        Assert.assertTrue("I agree check box is not checked", cartShippingPage.isIAgreeChecked());
    }

    @Test
    public void checkPaymentTabOpened() {
        myAccountPage = mainPage.clickSignIn()
                .createNewAccountWithEmail(account.getEmail())
                .fillAndSubmitRegistrationForm(account);

        cartSummaryPage = mainPage.dressesBtnClick()
                .listModeOn()
                .addFirstProductAction()
                .proceedToCheckout();

        cartPaymentPage = cartSummaryPage.proceedToCheckoutToAddress()
                .proceedToCheckoutToShipping()
                .iAgreeClick()
                .proceedToCheckoutToPayment();

        Assert.assertTrue("Payment tab is not opened", cartPaymentPage.isCartPaymentTabOpened());
    }

    @Test
    public void checkProductInPaymentTab() {
        myAccountPage = mainPage.clickSignIn()
                .createNewAccountWithEmail(account.getEmail())
                .fillAndSubmitRegistrationForm(account);

        cartSummaryPage = mainPage.dressesBtnClick()
                .listModeOn()
                .addFirstProductAction()
                .proceedToCheckout();

        String summaryProductName = cartSummaryPage.getProductName();
        Double summaryQuantity = cartSummaryPage.getProductQuantity(summaryProductName);
        Double summaryProductTotal = cartSummaryPage.getProductTotal(summaryProductName);
        Double summaryTotalProducts = cartSummaryPage.getTotalProducts();
        Double summaryTotalShipping = cartSummaryPage.getTotalSipping();
        Double summaryTotal = cartSummaryPage.getTotal();


        cartPaymentPage = cartSummaryPage.proceedToCheckoutToAddress()
                .proceedToCheckoutToShipping()
                .iAgreeClick()
                .proceedToCheckoutToPayment();

        String paymentProductName = cartPaymentPage.getProductName();
        Double paymentQuantity = cartPaymentPage.getProductQuantity(paymentProductName);
        Double paymentProductTotal = cartPaymentPage.getProductTotal(paymentProductName);
        Double paymentTotalProducts = cartPaymentPage.getTotalProducts();
        Double paymentTotalShipping = cartPaymentPage.getTotalSipping();
        Double paymentTotal = cartPaymentPage.getTotal();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(summaryProductName.equals(paymentProductName),
                String.format("Product name %s is not equal to %s", summaryProductName, paymentProductName));
        softAssert.assertTrue(summaryQuantity.equals(paymentQuantity),
                String.format("Quantity %f is not equal to %f", summaryQuantity, paymentQuantity));
        softAssert.assertTrue(summaryProductTotal.equals(paymentProductTotal),
                String.format("Product total %f is not equal to %f", summaryProductTotal, paymentProductTotal));
        softAssert.assertTrue(summaryTotalProducts.equals(paymentTotalProducts),
                String.format("Total products %f is not equal to %f", summaryTotalProducts, paymentTotalProducts));
        softAssert.assertTrue(summaryTotalShipping.equals(paymentTotalShipping),
                String.format("Total shipping %f is not equal to %f", summaryTotalShipping, paymentTotalShipping));
        softAssert.assertTrue(paymentTotal.equals(paymentTotal),
                String.format("Total %f is not equal to %f", summaryTotal, paymentTotal));
        softAssert.assertAll();
    }


}
