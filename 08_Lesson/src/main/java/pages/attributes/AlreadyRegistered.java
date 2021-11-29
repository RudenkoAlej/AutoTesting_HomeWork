package pages.attributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestHelper;

public class AlreadyRegistered {
    private WebDriver driver;
    private TestHelper helper;


    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    public AlreadyRegistered(WebDriver driver) {
        this.driver = driver;
        helper = new TestHelper(driver);
        PageFactory.initElements(driver, this);
    }


    public AlreadyRegistered typeEmail(String email){
        emailField = helper.waitElementClickable(2, emailField);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public AlreadyRegistered typePassword(String password){
        emailField = helper.waitElementClickable(2, passwordField);
        emailField.clear();
        emailField.sendKeys(password);
        return this;
    }

    public AlreadyRegistered signInClick(){
        signInBtn.click();
        return this;
    }
}
