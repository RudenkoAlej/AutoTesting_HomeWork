package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import pages.attributes.AlreadyRegistered;

import static utils.TestHelper.randomInt;

public class AlreadyRegisteredTest extends BaseTest{
    private MainPage mainPage;
    private SignInPage signInPage;


    @BeforeMethod
    public void openInitialPage() {
        mainPage = new MainPage(driver);
    }

    @DataProvider
    public static Object[][] dataProviderIncorrectCredentials() {
        return new Object[][]{
                {"SomeEmail" + randomInt() + "@gmail.com", "Crun" + randomInt()},
                {"MyFavMail@li.com", "Pass0rd"},
                {"MyFavMail@li.com", ""},
                {"", "Pass0rd"},
                {"", ""}};
    }

    @Test(dataProvider = "dataProviderIncorrectCredentials")
    public void checkAlreadyRegisteredWithIncorrectValues(String email, String password) {
        signInPage = mainPage.clickSignIn()
                    .setAlreadyRegisteredCredentials(email, password);
        String actualResult = signInPage.getErrorMessage();
        String expectedResult = "error";

        Assert.assertTrue(actualResult.contains(expectedResult), "If error is absent then test is failed");
    }

}
