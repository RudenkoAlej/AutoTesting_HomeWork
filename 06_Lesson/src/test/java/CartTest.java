import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.SearchPage;
import pages.CartPage;

public class CartTest extends BaseTest{
    private MainPage mainPage;
    private SearchPage searchPage;
    private CartPage cartPage;


// ------------------ Complete scenario in one test-----------------
    @Test
    public void checkChart() {
        mainPage = new MainPage(driver);
        String product = "Blouse";
        searchPage = mainPage.findProduct(product);
        searchPage.listModeOn();
        cartPage = searchPage.addToChartAndCheckChart();
        cartPage.quantityIncreaseWithPlus(product);
        double unitPrice = cartPage.getUnitPrice(product);
        double quantity = cartPage.getProductQuantity(product);
        double productTotal = cartPage.getProductTotal(product);
        double totalProducts = cartPage.getTotalProducts();
        double totalShipping = cartPage.getTotalSipping();
        double generalTotal = cartPage.getGeneralTotal();
        double tax = cartPage.getTax();
        double total = cartPage.getTotal();

        Assert.assertEquals(String.format("Total product price: %f is not equal Unit price: %f * Quantity: %f ", productTotal, unitPrice, quantity),
                (unitPrice * quantity),productTotal,0.00d);

        Assert.assertEquals(String.format("Total product price: %f is not equal Total products price: %f ", productTotal, totalProducts, generalTotal),
                 productTotal, totalProducts, 0.00d);

        Assert.assertEquals(String.format("Total price: %f is not equal Total products price: %f + Total shipping price: %f ", generalTotal, totalProducts, totalShipping),
                generalTotal, totalProducts + totalShipping, 0.00d);

        Assert.assertEquals(String.format("Total: %f is not equal Total price: %f + Tax: %f ", total, generalTotal, tax),
                total, generalTotal + tax, 0.00d);

        cartPage.deleteProduct(product);

        Assert.assertEquals("Your shopping cart is empty.", cartPage.getShoppingChartEmptyMessage());
    }


    @Test
    public void checkChartChain() {
        String product = "Blouse";
        double unitPrice = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .quantityIncreaseWithPlus(product)
                .getUnitPrice(product);
        CartPage cartPage = new CartPage(driver);
        double quantity = cartPage.getProductQuantity(product);
        double productTotal = cartPage.getProductTotal(product);
        double totalProducts = cartPage.getTotalProducts();
        double totalShipping = cartPage.getTotalSipping();
        double generalTotal = cartPage.getGeneralTotal();
        double tax = cartPage.getTax();
        double total = cartPage.getTotal();

        Assert.assertEquals(String.format("Total product price: %f is not equal Unit price: %f * Quantity: %f ", productTotal, unitPrice, quantity),
                (unitPrice * quantity),productTotal,0.00d);

        Assert.assertEquals(String.format("Total product price: %f is not equal Total products price: %f ", productTotal, totalProducts, generalTotal),
                productTotal, totalProducts, 0.00d);

        Assert.assertEquals(String.format("Total price: %f is not equal Total products price: %f + Total shipping price: %f ", generalTotal, totalProducts, totalShipping),
                generalTotal, totalProducts + totalShipping, 0.00d);

        Assert.assertEquals(String.format("Total: %f is not equal Total price: %f + Tax: %f ", total, generalTotal, tax),
                total, generalTotal + tax, 0.00d);

        Assert.assertEquals("Your shopping cart is empty.", cartPage.deleteProduct(product)
                                                                             .getShoppingChartEmptyMessage());

    }

    // ------------------ Scenario steps into separate tests -----------------
    @Test
    public void checkOpenMainPage() {
        mainPage = new MainPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));
        Assert.assertTrue(mainPage.getAutomationLblText().contains("Automation Practice Website"));
    }

    @Test
    public void checkProductFound() {
        String product = "Blouse";
        searchPage = new MainPage(driver).findProduct(product);

        Assert.assertTrue(String.format("Product with name %s is not present on the screen", product),
                searchPage.getProductName().contains(product));
    }

    @Test
    public void checkListViewIsEnabled() {
        driver.get(config.getProperty("dressesUrl"));
        Assert.assertTrue(String.format("List view is not selected"),
                new SearchPage(driver).listModeOn()
                                      .isListViewSelected());
    }

    @Test
    public void checkAddingProductToChart() {
        String product = "Blouse";
        CartPage cartPage = new MainPage(driver).findProduct(product)
                                                  .listModeOn()
                                                  .addToChartAndCheckChart();

        Assert.assertTrue(String.format("Product %s is not added to the chart or chart is not opened", product),
                                    cartPage.productIsInChart(product));
    }

    @Test
    public void checkIncreaseQuantity() {
        String product = "Blouse";
        Double expected = 2d;
        CartPage cartPage = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .quantityIncreaseWithPlus(product);

        Assert.assertEquals("Product quantity is not increased",expected, cartPage.getProductQuantity(product), 0);
    }

    @Test
    public void checkCalculateTotalProduct() {
        String product = "Blouse";
        CartPage cartPage = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .quantityIncreaseWithPlus(product);
        double unitPrice = cartPage.getUnitPrice(product);
        double quantity = cartPage.getProductQuantity(product);
        double productTotal = cartPage.getProductTotal(product);


        Assert.assertEquals(String.format("Total product price: %f is not equal Unit price: %f * Quantity: %f ", productTotal, unitPrice, quantity),
                (unitPrice * quantity),productTotal,0.00d);
    }

    @Test
    public void checkTotalProductEqual() {
        String product = "Blouse";
        CartPage cartPage = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .quantityIncreaseWithPlus(product);
        double productTotal = cartPage.getProductTotal(product);
        double totalProducts = cartPage.getTotalProducts();


        Assert.assertEquals(String.format("Total product price: %f is not equal Total products price: %f ", productTotal, totalProducts),
                productTotal, totalProducts, 0.00d);
    }

    @Test
    public void checkTotalWithShipping() {
        String product = "Blouse";
        CartPage cartPage = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .quantityIncreaseWithPlus(product);
        double totalProducts = cartPage.getTotalProducts();
        double totalShipping = cartPage.getTotalSipping();
        double generalTotal = cartPage.getGeneralTotal();


        Assert.assertEquals(String.format("Total price: %f is not equal Total products price: %f + Total shipping price: %f ", generalTotal, totalProducts, totalShipping),
                generalTotal, totalProducts + totalShipping, 0.00d);
    }

    @Test
    public void checkTotalWithTaxes() {
        String product = "Blouse";
        CartPage cartPage = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .quantityIncreaseWithPlus(product);
        double generalTotal = cartPage.getGeneralTotal();
        double tax = cartPage.getTax();
        double total = cartPage.getTotal();


        Assert.assertEquals(String.format("Total: %f is not equal Total price: %f + Tax: %f ", total, generalTotal, tax),
                total, generalTotal + tax, 0.00d);
    }

    @Test
    public void deleteProductFromCart() {
        String product = "Blouse";
        CartPage cartPage = new MainPage(driver).findProduct(product)
                .listModeOn()
                .addToChartAndCheckChart()
                .deleteProduct(product);

        Assert.assertEquals("Your shopping cart is empty.", cartPage.getShoppingChartEmptyMessage());
    }

    @Test
    public void checkCartIsEmpty() {
        driver.get(config.getProperty("chartUrl"));

        Assert.assertEquals("Your shopping cart is empty.", new CartPage(driver).getShoppingChartEmptyMessage());
    }


}
