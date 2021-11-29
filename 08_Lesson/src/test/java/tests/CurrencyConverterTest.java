package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignInPage;
import pages.converter.ConvertorPage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static utils.TestHelper.randomInt;

public class CurrencyConverterTest extends BaseConvertorTest{
    private ConvertorPage convertorPage;


    @BeforeMethod
    public void openInitialPage() {
        convertorPage = new ConvertorPage(driver);
    }

    @DataProvider
    public static Object[][] dataProviderDigits() {
        return new Object[][]{
                {"10.2"},
                {"7"},
                {"0"},
                {"-233.758"}
        };
    }

    @Test(dataProvider = "dataProviderDigits")
    public void checkConvertToUAH(String  valueToInput) {
        convertorPage.inputSum(valueToInput);
        Double rateUAH = convertorPage.getRateUAH();
        Double resultUAH = convertorPage.getResultUAH();

        Double expectedResult = BigDecimal.valueOf(Double.parseDouble(valueToInput) * rateUAH)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        Assert.assertTrue(resultUAH.equals(expectedResult),
                    String.format("Expected result: %f is not equal Result UAH: %f field", expectedResult, resultUAH));
    }


    @Test(dataProvider = "dataProviderDigits")
    public void checkConvertToEUR(String  valueToInput) {
        convertorPage.inputSum(valueToInput);
        Double rateEUR = convertorPage.getRateEUR();
        Double rateUAH = convertorPage.getRateUAH();
        Double resultEUR = convertorPage.getResultEUR();

        Double expectedResult = BigDecimal.valueOf((Double.parseDouble(valueToInput) * rateUAH)/rateEUR)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

        Assert.assertTrue(resultEUR.equals(expectedResult),
                String.format("Expected result: %f is not equal Result UAH: %f field", expectedResult, resultEUR));
    }

    @Test(dataProvider = "dataProviderDigits")
    public void checkConvertToRUB(String  valueToInput) {
        convertorPage.inputSum(valueToInput);
        Double rateRUB = convertorPage.getRateRUB();
        Double rateUAH = convertorPage.getRateUAH();
        Double resultRUB = convertorPage.getResultRUB();

        Double expectedResult = BigDecimal.valueOf((Double.parseDouble(valueToInput) * rateUAH)/rateRUB)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        Assert.assertTrue(resultRUB.equals(expectedResult),
                String.format("Expected result: %f is not equal Result UAH: %f field", expectedResult, resultRUB));
    }

    @Test(dataProvider = "dataProviderDigits")
    public void checkConvertToPLN(String  valueToInput) {
        convertorPage.inputSum(valueToInput);
        Double ratePLN = convertorPage.getRatePLN();
        Double rateUAH = convertorPage.getRateUAH();
        Double resultPLN = convertorPage.getResultPLN();

        Double expectedResult = BigDecimal.valueOf((Double.parseDouble(valueToInput) * rateUAH)/ratePLN)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        Assert.assertTrue(resultPLN.equals(expectedResult),
                String.format("Expected result: %f is not equal Result UAH: %f field", expectedResult, resultPLN));
    }

}
