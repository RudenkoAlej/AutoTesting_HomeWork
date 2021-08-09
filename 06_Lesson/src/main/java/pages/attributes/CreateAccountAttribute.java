package pages.attributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;
import utils.TestHelper;

public class CreateAccountAttribute {
    private WebDriver driver;
    private TestHelper helper;



    private WebElement emailField;
    private WebElement createAccountBtn;

    public CreateAccountAttribute(WebDriver driver) {
        this.driver = driver;
        helper = new TestHelper(driver);
    }

    public CreateAccountAttribute typeEmail(String email){
        emailField = helper.waitOnElement(30, "//*[@id='email_create']");
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public RegistrationPage clickCreateAnAccount(){
        createAccountBtn = helper.waitOnElement(30, "//*[@id='SubmitCreate']");
        createAccountBtn.click();
        return new RegistrationPage(driver);
    }




}
