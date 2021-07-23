import org.junit.*;
import java.io.*;

public class BankAccountTest {
    private BankAccount account;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public BankAccountTest() {
    }

    @Before
    public void setUp() {
        this.account = new BankAccount();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void checkInintialBalance() {
        Assert.assertEquals(this.account.getBalance(), 0, 0);
    }

    @Test
    public void testAddMoney() {
        float digit = 20.50f;
        float expectedResult = 20.50f;
        account.credit(digit);
        double actualResult = account.getBalance();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testMinusMoneyHigherThenZero() {
        int digitAdd = 20;
        float digitMinus = 14.55f;
        float expectedResult = 5.45f;
        account.credit(digitAdd);
        account.debit(digitMinus);
        double actualResult = account.getBalance();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testMinusMoneyToZero() {
        float digitAdd = 14.55f;
        float digitMinus = 14.55f;
        int expectedResult = 0;
        account.credit(digitAdd);
        account.debit(digitMinus);
        double actualResult = account.getBalance();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testMinusMoneyLessThenZero() {
        float digitAdd = 14.55f;
        float digitMinus = 24.55f;
        float expectedResultValue = 14.55f;
        String expectedResultMessage = "Сумма снятия больше чем остаток на счету!";
        account.credit(digitAdd);
        account.debit(digitMinus);
        double actualResult = account.getBalance();
        Assert.assertEquals(expectedResultValue, actualResult, 0);
        Assert.assertFalse("Сообщение отсутствует", out.toString().isEmpty());
        Assert.assertEquals("Сообщение отличается от \"" + expectedResultMessage + "\"", expectedResultMessage+"\r\n", out.toString());
        // Another way to check message:
        //Assert.assertTrue("Сообщение отличается от \"" + expectedResultMessage + "\"", out.toString().indexOf(expectedResultMessage) != -1);

    }

    @Test
    public void checkInintialAccountNumber() {
        Assert.assertEquals("Fail is initial Account Number is 0", 0, this.account.getAccountNuber());
    }

    @Test
    public void checkAccountNumberIsSet() {
        long accountNumber = 1234567891011121l;
        account.setAccountNuber(accountNumber);
        Assert.assertFalse(account.getAccountNuber() == 0);
    }

    @Test
    public void checkAccountNumberValue() {
        long accountNumber = 1234567891011121l;
        account.setAccountNuber(accountNumber);
        Assert.assertEquals(accountNumber, account.getAccountNuber());
    }


}
