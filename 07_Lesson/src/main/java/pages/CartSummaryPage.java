package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestHelper;

import java.util.List;

public class CartSummaryPage extends SearchPage {
    private TestHelper helper;

    public CartSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        helper = new TestHelper(driver);
    }

    @FindBy(id = "total_product")
    private WebElement totalProductsEl;

    @FindBy(id = "total_shipping")
    private WebElement totalShippingEl;

    @FindBy(id = "total_price_without_tax")
    private WebElement generalTotalEl;

    @FindBy(id = "total_tax")
    private WebElement taxEl;

    @FindBy(id = "total_price")
    private WebElement totalEl;

    @FindBy(css = "#center_column > p")
    private WebElement shoppingChartEmptyMessageEl;

    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement chartIcon;

    @FindBy(xpath = "//a[starts-with(@class, 'button btn')]")
    private WebElement proceedToCheckoutBtn;

    protected String PROD_NAME_BY_TEXT = "//p[@class='product-name']/a[text()='";

    public CartSummaryPage quantityIncreaseWithPlus(String productName) {
        WebElement quantityPlus = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName + "']/../../..//a[@title='Add']"));
        helper.waitElementClickable(2, quantityPlus);
        quantityPlus.click();
        helper.waitForSeconds(2);
        return this;
    }

    public double getUnitPrice(String productName) {
        WebElement unitPriceEl = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//td[@data-title='Unit price']/span"));
        Double unitPrice = Double.parseDouble(unitPriceEl.getText().substring(1));
        return unitPrice;
    }

//    Use for product with discount
    public double getInitialPrice(String productName) {
        WebElement unitPriceEl = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//span[@class='old-price']"));
        Double initialUnitPrice = Double.parseDouble(unitPriceEl.getText().substring(1));
        return initialUnitPrice;
    }

    public double getPriceDiscount(String productName) {
        WebElement unitDiscount = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//span[starts-with(@class, 'price-percent-reduction')]"));
        String[] parts1 = unitDiscount.getText().split("-");
        String[] parts2 = parts1[1].split("%");
        Double discount = Double.parseDouble(parts2[0]);
        return discount;
    }

    public double getProductQuantity(String productName) {
        WebElement productQuantityEl = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//*[starts-with(@class, 'cart_quantity_input')]"));
        Double unitPrice = Double.parseDouble(productQuantityEl.getAttribute("value"));
        return unitPrice;
    }

    public double getProductTotal(String productName) {
        WebElement productPriceEl = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//td[@data-title='Total']/span"));
        Double unitPrice = Double.parseDouble(productPriceEl.getText().substring(1));
        return unitPrice;
    }

    public double getSumOfAllProductsTotal() {
        List<WebElement> allTotals = driver.findElements(By.xpath("//td[@data-title='Total']/span"));
        Double totalSum = 0.00d;
        for (WebElement total: allTotals) {
            Double sum = Double.parseDouble(total.getText().substring(1));
            totalSum += sum;
        }
        return totalSum;
    }

    public double getTotalProducts() {
        Double totalProducts = Double.parseDouble(totalProductsEl.getText().substring(1));
        return totalProducts;
    }

    public double getTotalSipping() {
        Double totalShipping = Double.parseDouble(totalShippingEl.getText().substring(1));
        return totalShipping;
    }

    public double getGeneralTotal() {
        Double generalTotal = Double.parseDouble(generalTotalEl.getText().substring(1));
        return generalTotal;
    }

    public double getTax() {
        Double tax = Double.parseDouble(taxEl.getText().substring(1));
        return tax;
    }

    public double getTotal() {
        Double total = Double.parseDouble(totalEl.getText().substring(1));
        return total;
    }

    public CartSummaryPage deleteProduct(String productName) {
        WebElement productDeleteEl = driver.findElement(By.xpath(PROD_NAME_BY_TEXT + productName +
                "']/../../..//a[@title='Delete']"));
        productDeleteEl.click();
        return this;

    }

    public String getShoppingChartEmptyMessage() {
        helper.waitElementClickable(2, shoppingChartEmptyMessageEl);
        String value = shoppingChartEmptyMessageEl.getText();
          return value;
    }

    public boolean productIsInChart(String productName) {
        try {
            (new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(PROD_NAME_BY_TEXT + productName +"']")));
            return true;
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean isProductInChart(String str) {
            List<WebElement> images = driver.findElements(By.xpath(productImageSelector));
            for (WebElement image : images) {
                String attr = image.getAttribute("src");
                if (attr != null && attr.contains(str)) {
                    return true;
                }
            }
        return false;
    }

    public boolean isCartPageOpened() {
        if (chartIcon.getText().equals("Your shopping cart")) {
        return true;
        } else {
            return false;
        }
    }

    public CartAddressPage proceedToCheckoutToAddress() {
        helper.waitElementDisplayed(5, proceedToCheckoutBtn);
        proceedToCheckoutBtn.click();
        return new CartAddressPage(driver);
    }
}
