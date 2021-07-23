import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class BankAccountTestDataProvider {
    private static BankAccount account = null;
    private double number1;
    private double result;

    public BankAccountTestDataProvider(double number1, double result) {
        this.number1 = number1;
        this.result = result;
    }

    @Before
    public void setUp() {
        account = new BankAccount(123123, 20.5f);
    }

    @Parameterized.Parameters(name = "{index}: canChangeBalance ({0} = {1}")
    public static Iterable<Object[]> dataProviderForIncreaseBalance() {
        return Arrays.asList(
                new Object[] [] {{20, 40.5}, {09.5, 30}}
        );
    }

    @Test
    public void checkIncreaseBalance() {
        account.credit(number1);
        Assert.assertEquals(result, account.getBalance(), 0);
    }

//    @Parameterized.Parameters(name = "{index}: canChangeBalance ({0} = {1}")
//    public static Iterable<Object[]> dataProviderForDecreaseBalance() {
//        return Arrays.asList(
//                new Object[] [] {{20.5, 0}, {10.5, 10}}
//        );
//    }
//
//    @Test
//    public void checkDecreaseBalance() {
//        account.debit(number1);
//        Assert.assertEquals(result, account.getBalance(), 0);
//    }
}
