package pages;

import model.AccountBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestHelper;

public class RegistrationPage {
    private WebDriver driver;
    private MyAccountPage myAccountPage;
    private TestHelper helper;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        helper = new TestHelper(driver);

    }

    private void selectGender(String gender) {
        if (gender.equals("Mr.")) {
            helper.waitElementClickable(2,"//*[@id='id_gender1']").click();
        } else {
            helper.waitElementClickable(2,"//*[@id='id_gender2']").click();
        }
    }

    private void typeCustomerFirstName(String name) {
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
    }

    private void typeCustomerLastName(String name) {
        driver.findElement(By.id("customer_lastname")).sendKeys(name);
    }

    private void typeEmail(String email) {
        WebElement emailFiled = driver.findElement(By.id("email"));
        if (emailFiled.getText().equals("")) {
            emailFiled.clear();
            emailFiled.sendKeys(email);
        }
    }

    private void typePassword(String pass) {
        driver.findElement(By.id("passwd")).sendKeys(pass);
    }

    private void setBirthday(String day, String month, String year) {
        selectBirthDay(day);
        selectBirthMonth(month);
        selectBirthYear(year);

    }

    private void selectBirthDay(String day) {
        WebElement dayDropDown = driver.findElement(By.id("days"));
        helper.scrollToItem(dayDropDown);
        Select value = new Select(dayDropDown);
        value.selectByValue(day);
    }

    private void selectBirthMonth(String month) {
        WebElement monthDropDown = driver.findElement(By.id("months"));
        helper.scrollToItem(monthDropDown);
        Select value = new Select(monthDropDown);
        value.selectByValue(month);
    }

    private void selectBirthYear(String year) {
        WebElement yearDropDown = driver.findElement(By.id("years"));
        helper.scrollToItem(yearDropDown);
        Select value = new Select(yearDropDown);
        value.selectByValue(year);
    }

    private void typeFirstName(String firstName) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    private void typeLastName(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    private void typeCompany(String company) {
        driver.findElement(By.id("company")).sendKeys(company);
    }

    private void typeAddress1(String address1) {
        driver.findElement(By.id("address1")).sendKeys(address1);
    }

    private void typeAddress2(String address2) {
        driver.findElement(By.id("address2")).sendKeys(address2);
    }

    private void typeCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    private void selectState(String state) {
        WebElement stateDropDown = driver.findElement(By.id("id_state"));
        Select value = new Select(stateDropDown);
        value.selectByVisibleText(state);
    }

    private void typePostCode(String postcode) {
        driver.findElement(By.id("postcode")).sendKeys(postcode);
    }

    private void selectCountry(String country) {
        WebElement countryDropDown = driver.findElement(By.id("id_country"));
        Select value = new Select(countryDropDown);
        value.selectByVisibleText(country);
    }

    private void typeAdditional(String additional) {
        driver.findElement(By.cssSelector("#other")).sendKeys(additional);
    }

    private void typePhone(String phone) {
        driver.findElement(By.id("phone")).sendKeys(phone);
    }
    private void typeMobile(String mobile) {
        driver.findElement(By.id("phone_mobile")).sendKeys(mobile);
    }

    private void typeAlias(String alias) {
        WebElement aliasElem = driver.findElement(By.id("alias"));
        aliasElem.clear();
        aliasElem.sendKeys(alias);
    }

    public void clickRegisterBtn() {
        WebElement element = driver.findElement(By.id("submitAccount"));
        element.click();
    }

    public MyAccountPage clickRegister() {
        clickRegisterBtn();
        return new MyAccountPage(driver);
    }

    public void fillRegistrationForm(AccountBuilder.Account account) {
        selectGender(account.getGender());
        typeCustomerFirstName(account.getFirstCustomerName());
        typeCustomerLastName(account.getLastCustomerName());
        typeEmail(account.getEmail());
        typePassword(account.getPasswd());
        setBirthday(account.getDay(), account.getMonth(), account.getYear());
        typeFirstName(account.getFirstName());
        typeLastName(account.getLastName());
        typeCompany(account.getCompany());
        typeAddress1(account.getAddress1());
        typeAddress2(account.getAddress2());
        typeCity(account.getCity());
        selectState(account.getState());
        typePostCode(account.getPostCode());
        selectCountry(account.getCountry());
        typeAdditional(account.getAdditional());
        typePhone(account.getPhone());
        typeMobile(account.getMobile());
        typeAlias(account.getAlias());
    }

    public MyAccountPage fillAndSubmitRegistrationForm(AccountBuilder.Account account) {
        fillRegistrationForm(account);
        return clickRegister();
    }
}
