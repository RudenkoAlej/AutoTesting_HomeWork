package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.attributes.AlreadyRegistered;
import pages.attributes.CreateAccountAttribute;
import utils.TestHelper;

public class SignInPage {
    private WebDriver driver;
    private AlreadyRegistered alreadyRegistered;
    private CreateAccountAttribute createAccount;

    @FindBy(css = ".alert-danger > p")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        createAccount = new CreateAccountAttribute(driver);
        alreadyRegistered = new AlreadyRegistered(driver);
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage createNewAccountWithEmail(String email) {
        return createAccount.typeEmail(email).clickCreateAnAccount();
    }


    public SignInPage setAlreadyRegisteredCredentials(String email, String password) {
        alreadyRegistered.typeEmail(email)
                .typePassword(password)
                .signInClick();
        return new SignInPage(driver);
    }
//
//    public AlreadyRegistered setAbsentAlreadyRegisteredCredentials(String email, String password) {
//        alreadyRegistered.typeEmail(email)
//                .typePassword(password)
//                .signInClick();
//        return new AlreadyRegistered(driver);
//    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
