import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER"));

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void checkElementsVisible() {
        registrationPage.openRegistrationPage();
        Assert.assertTrue(registrationPage.isContactVisible());
        Assert.assertTrue(registrationPage.isContactUsBtnVisible());
        Assert.assertTrue(registrationPage.isSingInBtnVisible());
        Assert.assertTrue(registrationPage.isSearchFieldVisible());
        Assert.assertTrue(registrationPage.isSearchBtnVisible());
        Assert.assertTrue(registrationPage.isChartDropDnVisible());
        Assert.assertTrue(registrationPage.isWomanMenuVisible());
        Assert.assertTrue(registrationPage.isWomanTShortsMenuVisible());
        Assert.assertTrue(registrationPage.isWomanBlousesMenuVisible());
        Assert.assertTrue(registrationPage.isWomanDressesCasualMenuVisible());
        Assert.assertTrue(registrationPage.isWomanDressesEveningMenuVisible());
        Assert.assertTrue(registrationPage.isWomanDressesSummerMenuVisible());
        Assert.assertTrue(registrationPage.isDressesMenuVisible());
        Assert.assertTrue(registrationPage.isDressesCasualMenuVisible());
        Assert.assertTrue(registrationPage.isDressesEveningMenuVisible());
        Assert.assertTrue(registrationPage.isDressesSummerMenuVisible());
        Assert.assertTrue(registrationPage.isTShortsMenuVisible());
        Assert.assertTrue(registrationPage.isHomeBtnVisible());
        Assert.assertTrue(registrationPage.isAuthenticationBtnVisible());
        Assert.assertTrue(registrationPage.isAuthenticationHeaderVisible());
        Assert.assertTrue(registrationPage.isCreateAccountHeaderVisible());
        Assert.assertTrue(registrationPage.isCreateAccountTextVisible());
        Assert.assertTrue(registrationPage.isEmailAddressLblCreateVisible());
        Assert.assertTrue(registrationPage.isEmailAddressTxtBoxCreateVisible());
        Assert.assertTrue(registrationPage.isCreateAccountBtnCreateVisible());
        Assert.assertTrue(registrationPage.isAlreadyRegisteredHeaderVisible());
        Assert.assertTrue(registrationPage.isEmailAddressLblAlreadyVisible());
        Assert.assertTrue(registrationPage.isEmailAddressTxtBoxAlreadyVisible());
        Assert.assertTrue(registrationPage.isPasswordLblAlreadyVisible());
        Assert.assertTrue(registrationPage.isPasswordTxtBoxAlreadyVisible());
        Assert.assertTrue(registrationPage.isForgotYourPassAlreadyVisible());
        Assert.assertTrue(registrationPage.isSignInBtnAlreadyVisible());
    }

    @Test
    public void checkElementsVisibleCss() {
        registrationPage.openRegistrationPage();
        Assert.assertTrue(registrationPage.isContactVisibleCss());
        Assert.assertTrue(registrationPage.isContactUsBtnVisibleCss());
        Assert.assertTrue(registrationPage.isSingInBtnVisibleCss());
        Assert.assertTrue(registrationPage.isSearchFieldVisibleCss());
        Assert.assertTrue(registrationPage.isSearchBtnVisibleCss());
        Assert.assertTrue(registrationPage.isChartDropDnVisibleCss());
        Assert.assertTrue(registrationPage.isWomanMenuVisibleCss());
        Assert.assertTrue(registrationPage.isWomanTShortsMenuVisibleCss());
        Assert.assertTrue(registrationPage.isWomanBlousesMenuVisibleCss());
        Assert.assertTrue(registrationPage.isWomanDressesCasualMenuVisibleCss());
        Assert.assertTrue(registrationPage.isWomanDressesEveningMenuVisibleCss());
        Assert.assertTrue(registrationPage.isWomanDressesSummerMenuVisibleCss());
        Assert.assertTrue(registrationPage.isDressesMenuVisibleCss());
        Assert.assertTrue(registrationPage.isDressesCasualMenuVisibleCss());
        Assert.assertTrue(registrationPage.isDressesEveningMenuVisibleCss());
        Assert.assertTrue(registrationPage.isDressesSummerMenuVisibleCss());
        Assert.assertTrue(registrationPage.isTShortsMenuVisibleCss());
        Assert.assertTrue(registrationPage.isHomeBtnVisibleCss());
        Assert.assertTrue(registrationPage.isAuthenticationBtnVisibleCss());
        Assert.assertTrue(registrationPage.isAuthenticationHeaderVisibleCss());
        Assert.assertTrue(registrationPage.isCreateAccountHeaderVisibleCss());
        Assert.assertTrue(registrationPage.isCreateAccountTextVisibleCss());
        Assert.assertTrue(registrationPage.isEmailAddressLblCreateVisibleCss());
        Assert.assertTrue(registrationPage.isEmailAddressTxtBoxCreateVisibleCss());
        Assert.assertTrue(registrationPage.isCreateAccountBtnCreateVisibleCss());
        Assert.assertTrue(registrationPage.isAlreadyRegisteredHeaderVisibleCss());
        Assert.assertTrue(registrationPage.isEmailAddressLblAlreadyVisibleCss());
        Assert.assertTrue(registrationPage.isEmailAddressTxtBoxAlreadyVisibleCss());
        Assert.assertTrue(registrationPage.isPasswordLblAlreadyVisibleCss());
        Assert.assertTrue(registrationPage.isPasswordTxtBoxAlreadyVisibleCss());
        Assert.assertTrue(registrationPage.isForgotYourPassAlreadyVisibleCss());
        Assert.assertTrue(registrationPage.isSignInBtnAlreadyVisibleCss());
    }

    @After
    public void cleanup(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
