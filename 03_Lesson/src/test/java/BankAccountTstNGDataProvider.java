import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.Arrays;

@RunWith(DataProviderRunner.class)
public class BankAccountTstNGDataProvider {
    private static BankAccount account = null;
    private float number1;
    private float result;

    @Before
    public void setUp() {
        account = new BankAccount(123123, 20.5f);
    }

    @DataProvider
    public static Object[][] dataProviderIncreaseMoney() {
        return new Object[][] {
                {20f, 40.5f},
                {09.5f, 30f}};
    }

    @Test
    @UseDataProvider("dataProviderIncreaseMoney")
    public void checkIncreaseBalance(float number1, float result) {
        account.credit(number1);
        Assert.assertEquals(result, account.getBalance(), 0);
    }

    @DataProvider
    public static Object[][] dataProviderDecreaseMoney() {
        return new Object[][] {
                {10f, 10.5f},
                {15.5f, 5f}};
    }

    @Test
    @UseDataProvider("dataProviderDecreaseMoney")
    public void checkDecreaseBalance(float number1, float result) {
        account.debit(number1);
        Assert.assertEquals(result, account.getBalance(), 0);
    }
}
