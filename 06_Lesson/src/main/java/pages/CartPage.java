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

public class CartPage {
    private WebDriver driver;
    private TestHelper helper;

    public CartPage(WebDriver driver) {
        this.driver = driver;
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

    private String PROD_NAME_BY_TEXT = "//p[@class='product-name']/a[text()='";

    public CartPage quantityIncreaseWithPlus(String productName) {
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

    public CartPage deleteProduct(String productName) {
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
}
