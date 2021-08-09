
import model.AccountBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pages.MainPage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import pages.SignInPage;

import static utils.TestHelper.randomInt;

public class RegistrationTest extends BaseTest{
    private MainPage mainPage;
    private AccountBuilder.Account account;
    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;

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

    @Test
    public void checkErrorMessageOnRegistration(){
        signInPage = mainPage.clickSignIn();
        registrationPage = signInPage.createNewAccountWithEmail(account.getEmail());
        myAccountPage = registrationPage.fillAndSubmitRegistrationForm(account);
        String actualResult = myAccountPage.getAccountName();
        String expectedResult = account.getFirstCustomerName();

        Assert.assertTrue("If error is absent then test is failed",
                actualResult.contains(expectedResult));

    }

    @Test()
    public void checkErrorMessageOnRegistrationChain(){
        String expectedResult = account.getFirstCustomerName();;

        Assert.assertTrue(
                mainPage.clickSignIn()
                        .createNewAccountWithEmail(account.getEmail())
                        .fillAndSubmitRegistrationForm(account)
                        .getAccountName()
                        .contains(expectedResult)
                );
    }
}
