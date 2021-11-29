package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.attributes.AlreadyRegistered;
import pages.attributes.CreateAccountAttribute;

public class SignInPage {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private AlreadyRegistered alreadyRegistered;
    private CreateAccountAttribute createAccount;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage createNewAccountWithEmail(String email) {
        createAccount = new CreateAccountAttribute(driver);
        return createAccount.typeEmail(email).clickCreateAnAccount();
    }

}
