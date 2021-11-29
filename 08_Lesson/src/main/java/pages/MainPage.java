package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@href,'controller=my-account')]")
    private WebElement singIn;

    @FindBy(css = ".editorial_block h1")
    private WebElement automationLbl;

    @FindBy(xpath = "//input[@name='search_query']")
    private WebElement findField;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement findBtn;

    @FindBy(xpath = "//ul[starts-with(@class, 'sf-menu')]/li[2]")
    protected WebElement dressesTab;

    @FindBy(xpath = "//ul[starts-with(@class, 'sf-menu')]/li[1]")
    protected WebElement womanTab;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage clickSignIn(){
        singIn.click();
        return new SignInPage(driver);
    }

    public String getAutomationLblText(){
        return automationLbl.getText();
    }

    public SearchPage findProduct(String product){
        findField.sendKeys(product);
        findBtn.click();
        return new SearchPage(driver);
    }

    public DressesPage dressesBtnClick(){
        dressesTab.click();
        return new DressesPage(driver);
    }

    public WomanPage womanBtnClick(){
        womanTab.click();
        return new WomanPage(driver);
    }
}
