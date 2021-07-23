//import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

//@RunWith(DataProviderRunner.class)
public class BankAccountTstNGDataProvider {
    private static BankAccount account = null;
    private double number1;
    private double result;

    @BeforeClass
    public void setUp() {
        account = new BankAccount(123123, 20.5f);
    }

//    @DataProvider
    public static Object[][] dataProviderIncreaseMoney() {
        return new Object[][] {
                {20, 40.5},
                {09.5, 30}};
    }

    @Test
//    @UseDataProvider("dataProviderIncreaseMoney")
    public void checkIncreaseBalance() {
        account.credit(number1);
        Assert.assertEquals(result, account.getBalance(), 0);
    }
}
