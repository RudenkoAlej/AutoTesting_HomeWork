import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage {

    private static final String REGISTRATION_PAGE_URL ="http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private WebDriver driver;

//  ----------------------  XPath locators-----------------------------
    private By contactX = By.xpath("//*[@class='shop-phone']/strong");
    private By contactUsBtnX = By.xpath("//a[@title='Contact Us']");
    private By signInBtnX = By.xpath("//a[@class='login']");
    private By searchFieldX = By.xpath("//input[@name='search_query']");
    private By searchBtnX = By.xpath("//button[@name='submit_search']");
    private By chartDropDnX = By.xpath("//a[starts-with(@title, 'View')]");
    private static String WOMAN_MENU = "//a[@title='Women']";
    private By womanMenuX = By.xpath(WOMAN_MENU);
    private By womanTShortsMenuX = By.xpath(WOMAN_MENU+"/../descendant::a[@title='T-shirts']");
    private By womanBlousesMenuX = By.xpath(WOMAN_MENU+"/../descendant::a[@title='Blouses']");
    private By womanDressesCasualMenuX = By.xpath(WOMAN_MENU+"/../descendant::a[@title='Casual Dresses']");
    private By womanDressesEveningMenuX = By.xpath(WOMAN_MENU+"/../descendant::a[@title='Evening Dresses']");
    private By womanDressesSummerMenuX = By.xpath(WOMAN_MENU+"/../descendant::a[@title='Summer Dresses']");
    private static String DRESSES_MENU = "//ul[starts-with(@class, 'sf-menu')]/li[2]";
    private By dressesMenuX = By.xpath(DRESSES_MENU);
    private By dressesCasualMenuX = By.xpath(DRESSES_MENU+"/descendant::a[starts-with(@title, 'Casual')]");
    private By dressesEveningMenuX = By.xpath(DRESSES_MENU+"/descendant::a[starts-with(@title, 'Evening')]");
    private By dressesSummerMenuX = By.xpath(DRESSES_MENU+"/descendant::a[starts-with(@title, 'Summer')]");
    private By tShirtsMenuX = By.xpath("//ul[starts-with(@class, 'sf-menu')]/li[3]");
    private By homeBtnX = By.xpath("//a[@class='home']");
    private By authenticationBtnX = By.xpath("//*[@class='navigation_page']");
    private By authenticationHeaderX = By.xpath("//*[@class='page-heading']");
    private static String CREATE_ACCOUNT = "//*[@id='create-account_form']";
    private By createAccountHeaderX = By.xpath(CREATE_ACCOUNT+"/h3");
    private By createAccountTextX = By.xpath(CREATE_ACCOUNT+"/descendant::p");
    private By emailAddressLblCreateX = By.xpath(CREATE_ACCOUNT+"/descendant::label[@for='email_create']");
    private By emailAddressTxtBoxCreateX = By.xpath(CREATE_ACCOUNT+"/descendant::*[@name='email_create']");
    private By createAccountBtnCreateX = By.xpath(CREATE_ACCOUNT+"/descendant::button[@name='SubmitCreate']");
    private static String ALREADY_REGISTERED = "//*[@id='login_form']";
    private By alreadyRegisteredHeaderX = By.xpath(ALREADY_REGISTERED+"/h3");
    private By emailAddressLblAlreadyX = By.xpath(ALREADY_REGISTERED+"/descendant::label[@for='email']");
    private By emailAddressTxtBoxAlreadyX = By.xpath(ALREADY_REGISTERED+"/descendant::*[@name='email']");
    private By passwordLblAlreadyX = By.xpath(ALREADY_REGISTERED+"/descendant::label[@for='passwd']");
    private By passwordTxtBoxAlreadyX = By.xpath(ALREADY_REGISTERED+"/descendant::*[@name='passwd']");
    private By forgotYourPassAlreadyX = By.xpath(ALREADY_REGISTERED+"/descendant::a[starts-with(@title, 'Recover')]");
    private By signInBtnAlreadyX = By.xpath(ALREADY_REGISTERED+"/descendant::*[@class='submit']");


//  ----------------------  CSS locators-------------------------------
    private By contactCss = By.cssSelector(".shop-phone strong");
    private By contactUsBtnCss = By.cssSelector("[title='Contact Us']");
    private By signInBtnCss = By.cssSelector("[title^='Log in']");
    private By searchFieldCss = By.cssSelector("[name='search_query']");
    private By searchBtnCss = By.cssSelector("[name='submit_search']");
    private By chartDropDnCss = By.cssSelector("[title^='View']");
    private static String WOMAN_MENU_CSS = "[class^='sf-menu'] > li:nth-child(1)";
    private By womanMenuCss = By.cssSelector(WOMAN_MENU_CSS);
    private By womanTShortsMenuCss = By.cssSelector(WOMAN_MENU_CSS+" a[title='T-shirts']");
    private By womanBlousesMenuCss = By.cssSelector(WOMAN_MENU_CSS+" a[title='Blouses']");
    private By womanDressesCasualMenuCss = By.cssSelector(WOMAN_MENU_CSS+" a[title='Casual Dresses']");
    private By womanDressesEveningMenuCss = By.cssSelector(WOMAN_MENU_CSS+" a[title='Evening Dresses']");
    private By womanDressesSummerMenuCss = By.cssSelector(WOMAN_MENU_CSS+" a[title='Summer Dresses']");
    private static String DRESSES_MENU_CSS = "[class^='sf-menu'] > li:nth-child(2)";
    private By dressesMenuCss = By.cssSelector(DRESSES_MENU_CSS);
    private By dressesCasualMenuCss = By.cssSelector(DRESSES_MENU_CSS+" a[title^='Casual']");
    private By dressesEveningMenuCss = By.cssSelector(DRESSES_MENU_CSS+" a[title^='Evening']");
    private By dressesSummerMenuCss = By.cssSelector(DRESSES_MENU_CSS+" a[title^='Summer']");
    private By tShirtsMenuCss = By.cssSelector("[class^='sf-menu'] > li:nth-child(3)");
    private By homeBtnCss = By.cssSelector(".icon-home");
    private By authenticationBtnCss = By.cssSelector(".navigation_page");
    private By authenticationHeaderCss = By.cssSelector(".page-heading");
    private static String CREATE_ACCOUNT_CSS = "#create-account_form";
    private By createAccountHeaderCss = By.cssSelector(CREATE_ACCOUNT_CSS+" h3");
    private By createAccountTextCss = By.cssSelector(CREATE_ACCOUNT_CSS+" p");
    private By emailAddressLblCreateCss = By.cssSelector(CREATE_ACCOUNT_CSS+" label");
    private By emailAddressTxtBoxCreateCss = By.cssSelector(CREATE_ACCOUNT_CSS+" [id='email_create']");
    private By createAccountBtnCreateCss = By.cssSelector(CREATE_ACCOUNT_CSS+" [id='SubmitCreate']");
    private static String ALREADY_REGISTERED_CSS = "#login_form";
    private By alreadyRegisteredHeaderCss = By.cssSelector(ALREADY_REGISTERED_CSS+" h3");
    private By emailAddressLblAlreadyCss = By.cssSelector(ALREADY_REGISTERED_CSS+" [for='email']");
    private By emailAddressTxtBoxAlreadyCss = By.cssSelector(ALREADY_REGISTERED_CSS+" [id='email']");
    private By passwordLblAlreadyCss = By.cssSelector(ALREADY_REGISTERED_CSS+" [for='passwd']");
    private By passwordTxtBoxAlreadyCss = By.cssSelector(ALREADY_REGISTERED_CSS+" [id='passwd']");
    private By forgotYourPassAlreadyCss = By.cssSelector(ALREADY_REGISTERED_CSS + " [title^='Recover']");
    private By signInBtnAlreadyCss = By.cssSelector(ALREADY_REGISTERED_CSS+" [class='submit']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage openRegistrationPage(){
        this.driver.navigate().to(REGISTRATION_PAGE_URL);
        return this;
    }

    public boolean isContactVisible(){
        return this.driver.findElement(contactX).isDisplayed();
    }
    public boolean isContactVisibleCss(){
        return this.driver.findElement(contactCss).isDisplayed();
    }
    public boolean isContactUsBtnVisible(){
        return this.driver.findElement(contactUsBtnX).isDisplayed();
    }
    public boolean isContactUsBtnVisibleCss(){
        return this.driver.findElement(contactUsBtnCss).isDisplayed();
    }
    public boolean isSingInBtnVisible(){
        return this.driver.findElement(signInBtnX).isDisplayed();
    }
    public boolean isSingInBtnVisibleCss(){
        return this.driver.findElement(signInBtnCss).isDisplayed();
    }
    public boolean isSearchFieldVisible(){
        return this.driver.findElement(searchFieldX).isDisplayed();
    }
    public boolean isSearchFieldVisibleCss(){
        return this.driver.findElement(searchFieldCss).isDisplayed();
    }
    public boolean isSearchBtnVisible(){
        return this.driver.findElement(searchBtnX).isDisplayed();
    }
    public boolean isSearchBtnVisibleCss(){
        return this.driver.findElement(searchBtnCss).isDisplayed();
    }
    public boolean isChartDropDnVisible(){
        return this.driver.findElement(chartDropDnX).isDisplayed();
    }
    public boolean isChartDropDnVisibleCss(){
        return this.driver.findElement(chartDropDnCss).isDisplayed();
    }
    public boolean isWomanMenuVisible(){
        return this.driver.findElement(womanMenuX).isDisplayed();
    }
    public boolean isWomanMenuVisibleCss(){
        return this.driver.findElement(womanMenuCss).isDisplayed();
    }
    public boolean isWomanTShortsMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuX);
        action.moveToElement(we).build().perform();
        return driver.findElement(womanTShortsMenuX).isDisplayed();
    }
    public boolean isWomanTShortsMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuCss);
        action.moveToElement(we).build().perform();
        return driver.findElement(womanTShortsMenuCss).isDisplayed();
    }
    public boolean isWomanBlousesMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanBlousesMenuX).isDisplayed();
    }
    public boolean isWomanBlousesMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanBlousesMenuCss).isDisplayed();
    }
    public boolean isWomanDressesCasualMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanDressesCasualMenuX).isDisplayed();
    }
    public boolean isWomanDressesCasualMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanDressesCasualMenuCss).isDisplayed();
    }
    public boolean isWomanDressesEveningMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanDressesEveningMenuX).isDisplayed();
    }
    public boolean isWomanDressesEveningMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanDressesEveningMenuCss).isDisplayed();
    }
    public boolean isWomanDressesSummerMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanDressesSummerMenuX).isDisplayed();
    }
    public boolean isWomanDressesSummerMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(womanMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(womanDressesSummerMenuCss).isDisplayed();
    }

    public boolean isDressesMenuVisible(){
        return this.driver.findElement(dressesMenuX).isDisplayed();
    }
    public boolean isDressesMenuVisibleCss(){
        return this.driver.findElement(dressesMenuCss).isDisplayed();
    }
    public boolean isDressesCasualMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(dressesMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(dressesCasualMenuX).isDisplayed();
    }
    public boolean isDressesCasualMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(dressesMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(dressesCasualMenuCss).isDisplayed();
    }
    public boolean isDressesEveningMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(dressesMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(dressesEveningMenuX).isDisplayed();
    }
    public boolean isDressesEveningMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(dressesMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(dressesEveningMenuCss).isDisplayed();
    }
    public boolean isDressesSummerMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(dressesMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(dressesSummerMenuX).isDisplayed();
    }
    public boolean isDressesSummerMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(dressesMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(dressesSummerMenuCss).isDisplayed();
    }
    public boolean isTShortsMenuVisible(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(tShirtsMenuX);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(tShirtsMenuX).isDisplayed();
    }
    public boolean isTShortsMenuVisibleCss(){
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(tShirtsMenuCss);
        action.moveToElement(we).build().perform();
        return this.driver.findElement(tShirtsMenuCss).isDisplayed();
    }
    public boolean isHomeBtnVisible(){
        return this.driver.findElement(homeBtnX).isDisplayed();
    }
    public boolean isHomeBtnVisibleCss(){
        return this.driver.findElement(homeBtnCss).isDisplayed();
    }
    public boolean isAuthenticationBtnVisible(){
        return this.driver.findElement(authenticationBtnX).isDisplayed();
    }
    public boolean isAuthenticationBtnVisibleCss(){
        return this.driver.findElement(authenticationBtnCss).isDisplayed();
    }
    public boolean isAuthenticationHeaderVisible(){
        return this.driver.findElement(authenticationHeaderX).isDisplayed();
    }
    public boolean isAuthenticationHeaderVisibleCss(){
        return this.driver.findElement(authenticationHeaderCss).isDisplayed();
    }
    public boolean isCreateAccountHeaderVisible(){
        return this.driver.findElement(createAccountHeaderX).isDisplayed();
    }
    public boolean isCreateAccountHeaderVisibleCss(){
        return this.driver.findElement(createAccountHeaderCss).isDisplayed();
    }
    public boolean isCreateAccountTextVisible(){
        return this.driver.findElement(createAccountTextX).isDisplayed();
    }
    public boolean isCreateAccountTextVisibleCss(){
        return this.driver.findElement(createAccountTextCss).isDisplayed();
    }
    public boolean isEmailAddressLblCreateVisible(){
        return this.driver.findElement(emailAddressLblCreateX).isDisplayed();
    }
    public boolean isEmailAddressLblCreateVisibleCss(){
        return this.driver.findElement(emailAddressLblCreateCss).isDisplayed();
    }
    public boolean isEmailAddressTxtBoxCreateVisible(){
        return this.driver.findElement(emailAddressTxtBoxCreateX).isDisplayed();
    }
    public boolean isEmailAddressTxtBoxCreateVisibleCss(){
        return this.driver.findElement(emailAddressTxtBoxCreateCss).isDisplayed();
    }
    public boolean isCreateAccountBtnCreateVisible(){
        return this.driver.findElement(createAccountBtnCreateX).isDisplayed();
    }
    public boolean isCreateAccountBtnCreateVisibleCss(){
        return this.driver.findElement(createAccountBtnCreateCss).isDisplayed();
    }
    public boolean isAlreadyRegisteredHeaderVisible(){
        return this.driver.findElement(alreadyRegisteredHeaderX).isDisplayed();
    }
    public boolean isAlreadyRegisteredHeaderVisibleCss(){
        return this.driver.findElement(alreadyRegisteredHeaderCss).isDisplayed();
    }
    public boolean isEmailAddressLblAlreadyVisible(){
        return this.driver.findElement(emailAddressLblAlreadyX).isDisplayed();
    }
    public boolean isEmailAddressLblAlreadyVisibleCss(){
        return this.driver.findElement(emailAddressLblAlreadyCss).isDisplayed();
    }
    public boolean isEmailAddressTxtBoxAlreadyVisible(){
        return this.driver.findElement(emailAddressTxtBoxAlreadyX).isDisplayed();
    }
    public boolean isEmailAddressTxtBoxAlreadyVisibleCss(){
        return this.driver.findElement(emailAddressTxtBoxAlreadyCss).isDisplayed();
    }
    public boolean isPasswordLblAlreadyVisible(){
        return this.driver.findElement(passwordLblAlreadyX).isDisplayed();
    }
    public boolean isPasswordLblAlreadyVisibleCss(){
        return this.driver.findElement(passwordLblAlreadyCss).isDisplayed();
    }
    public boolean isPasswordTxtBoxAlreadyVisible(){
        return this.driver.findElement(passwordTxtBoxAlreadyX).isDisplayed();
    }
    public boolean isPasswordTxtBoxAlreadyVisibleCss(){
        return this.driver.findElement(passwordTxtBoxAlreadyCss).isDisplayed();
    }
    public boolean isForgotYourPassAlreadyVisible(){
        return this.driver.findElement(forgotYourPassAlreadyX).isDisplayed();
    }
    public boolean isForgotYourPassAlreadyVisibleCss(){
        return this.driver.findElement(forgotYourPassAlreadyCss).isDisplayed();
    }
    public boolean isSignInBtnAlreadyVisible(){
        return this.driver.findElement(signInBtnAlreadyX).isDisplayed();
    }
    public boolean isSignInBtnAlreadyVisibleCss(){
        return this.driver.findElement(signInBtnAlreadyCss).isDisplayed();
    }




}
