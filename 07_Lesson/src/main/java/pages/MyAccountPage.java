package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public WebDriver driver;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a")
    private WebElement accountBtn;

    @FindBy(css = ".alert-danger > p")
    private WebElement errorMessage;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAccountName(){
        return accountBtn.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
