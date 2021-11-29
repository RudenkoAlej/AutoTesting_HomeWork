package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPage extends MainPage{
    private TestHelper helper;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        helper = new TestHelper(driver);
    }

    @FindBy(css = "#list")
    protected WebElement listModeIcon;

    @FindBy(xpath = "//a[@title='Add to cart']/span")
    private WebElement addToChartBtn;

    @FindBy(xpath = "//*[@class='button-container']/a")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@class='button-container']/span")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//table[@id='cart_summary']//*[@class='product-name']")
    private WebElement productLbl;

    @FindBy(xpath = "//*[@class='ajax_cart_no_product']")
    private WebElement emptyChart;

    @FindBy(xpath = "//*[@title='View my shopping cart']")
    private WebElement cartIcon;

    private String sizeSelector =  "//a[text() = ";

    private String sizeCheckBoxSelector = "]//ancestor::li/div/span";

    protected String firstProductContainerSelector = "//li[contains(@class, 'first-in-line first-item-of-table')]";

    protected String secondProductContainerSelector = "//li[contains(@class, 'last-item-of-tablet-line col-xs-1')]";

    protected String productImageSelector = "//img";

    protected String productButtonSelector = "//a[@title='Add to cart']/span";

    public boolean isDressesTabSelected() {
        String dressesTabAttribute = dressesTab.getAttribute("class");
        if (dressesTabAttribute.equals("sfHoverForce")) {
            return true;
        }else  {
            return false;
        }
    }

    public boolean isWomanTabSelected() {
        String womanTabAttribute = womanTab.getAttribute("class");
        if (womanTabAttribute.equals("sfHoverForce")) {
            return true;
        }else  {
            return false;
        }
    }

    public SearchPage listModeOn() {
        helper.waitElementClickable(5, listModeIcon).click();
//        helper.waitForSeconds(5);
        return this;
    }

    public CartSummaryPage addToChartAndGoToChart() {
        helper.waitElementClickable(10, addToChartBtn);
        addToChartBtn.click();
        return proceedToCheckout();
    }

    public CartSummaryPage addToChartAndGoToChart(String productName) {

        WebElement productContainer = driver.findElement(By.xpath("//h5[@itemprop]/a[@title='" + productName + "']//ancestor::div[@class='row'][1]"));
        WebElement addToChartBtn = productContainer.findElement(By.xpath(productButtonSelector));
        addToChartBtn.click();
        return proceedToCheckout();
    }


    public SearchPage addToChartAndProceedPurchases() {
        addToChartBtn.click();
        return continueShopping();
    }

    public CartSummaryPage proceedToCheckout() {
        helper.waitElementDisplayed(10, proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
        return new CartSummaryPage(driver);
    }

    public void continueShoppingClick() {
        helper.waitElementDisplayed(10, continueShoppingBtn);
        continueShoppingBtn.click();
    }

    public SearchPage continueShopping() {
        continueShoppingClick();
        return new SearchPage(driver);
    }

    public CartSummaryPage openCart() {
        helper.waitElementDisplayed(5, cartIcon);
        cartIcon.click();
        return new CartSummaryPage(driver);
    }


    public String getProductName() {
        String productName = productLbl.getText();
        return productName;
    }

    public boolean isListViewSelected() {
        String listViewAttr = listModeIcon.getAttribute("class");
        if (listViewAttr.equals("selected")) {
            return true;
        }else  {
            return false;
        }
    }

    public SearchPage selectSize(SizeOptions size) {
        WebElement sizeCheckBoxEl = driver.findElement(By.xpath(sizeSelector + "'" + size + "'" + sizeCheckBoxSelector));
        sizeCheckBoxEl.click();
        return new SearchPage(driver);
    }

    public boolean isSizeFilterSelected(SizeOptions size) {
        WebElement sizeCheckBoxEl = driver.findElement(By.xpath(sizeSelector + "'" + size + "'" + sizeCheckBoxSelector));
        helper.scrollToItem(sizeCheckBoxEl);
        String listViewAttr = sizeCheckBoxEl.getAttribute("class");
        if (listViewAttr.equals("checked")) {
            return true;
        }else  {
            return false;
        }
    }

    public SearchPage sortProducts(String sortOption) {
        Select select = new Select(driver.findElement(By.xpath("//select[@id='selectProductSort']")));
        select.selectByVisibleText(sortOption);
        return new SearchPage(driver);
    }

    public String getSortOption() {
        Select select = new Select(driver.findElement(By.xpath("//select[@id='selectProductSort']")));
        WebElement selected = select.getFirstSelectedOption();
        return selected.getText();
    }

    public String getFirstProductImage() {
        String imageSelector = firstProductContainerSelector + productImageSelector;
        WebElement image = driver.findElement(By.xpath(imageSelector));
        helper.scrollToItem(image);
        String imageLinkString = image.getAttribute("src");
        String[] parts = imageLinkString.split("-");
        return parts[0];
    }

    public SearchPage addFirstProductAction() {
        String addButtonSelector = firstProductContainerSelector + productButtonSelector;
        driver.findElement(By.xpath(addButtonSelector)). click();
        return new SearchPage(driver);
    }

    public String getSecondProductImage() {
        String imageSelector = secondProductContainerSelector + productImageSelector;
        WebElement image = driver.findElement(By.xpath(imageSelector));
        helper.scrollToItem(image);
        String imageLinkString = image.getAttribute("src");
        String[] parts = imageLinkString.split("-");
        return parts[0];
    }

    public SearchPage addSecondProductAction() {
        String addButtonSelector = secondProductContainerSelector + productButtonSelector;
        driver.findElement(By.xpath(addButtonSelector)).click();
        return new SearchPage(driver);
    }

    public boolean checkCartIsNotEmpty() {
        if (!emptyChart.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }

    public List<WebElement> allProductsWithName(String productName) {
        List<WebElement> webElementList = new ArrayList<>();
        for (WebElement element: driver.findElements(By.xpath("//div[@class='right-block']//a[contains(text(), '"+ productName +"')]/../../..//img"))) {
            webElementList.add(element);
        }
            return webElementList;
    }

    public List<WebElement> allProductsWithDiscount() {
        List<WebElement> webElementList = new ArrayList<>();
        for (WebElement element: driver.findElements(By.xpath("//div[@class='right-block']//span[@class='price-percent-reduction']//ancestor-or-self::div[@class='product-container']//img"))) {
            webElementList.add(element);
        }
        return webElementList;
    }

    public List<WebElement> combineProductFilteredElements(List<WebElement> arrayName, List<WebElement> arrayDiscount) {
        List<WebElement> webElementList = new ArrayList<>();

        for (WebElement el: arrayName) {
            for (WebElement el2: arrayDiscount) {
                if (el.getAttribute("src").equals(el2.getAttribute("src"))) {
                    webElementList.add(el);
                }
            }
        }
        return webElementList;
    }

    public SearchPage addAllProducts(List<WebElement> elementsToAdd) {

        for (WebElement el: elementsToAdd) {
            WebElement productContainer = el.findElement(By.xpath("ancestor-or-self::div[@class='product-container']"));
            helper.waitElementDisplayed(5, productContainer);
            Actions move = new Actions(driver);
            move.moveToElement(productContainer).perform();
            WebElement addToCartBtn = productContainer.findElement(By.xpath("descendant::a[@title='Add to cart']"));
            addToCartBtn.click();
            continueShoppingClick();
        }
        return new SearchPage(driver);
    }

}
