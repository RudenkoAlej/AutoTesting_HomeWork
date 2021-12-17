package api;

import com.jayway.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import pages.MainPage;
import api.utils.Const;
import com.jayway.restassured.RestAssured;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.hamcrest.Matchers.*;

public class WeatherApiTest extends BaseTest{
    private MainPage mainPage;

    @Test
    public void canReceiveForecast() {
        mainPage = new MainPage(driver);

        int temperature = mainPage.selectCity("London").getTemperature();
        Double calculateKelvin = (temperature+459.67)*5/9;

/*       RestAssured.given()
                .param("q", "London,uk")
                .param("appid", "34929949ed5c04c864f24faa6a3c3bbf")
                .get(Const.BASE_URL_WEATHER).body().prettyPrint();
*/
        ValidatableResponse body = RestAssured.given()
                .param("q", "London,uk")
                .param("appid", "34929949ed5c04c864f24faa6a3c3bbf")
                .get(Const.BASE_URL_WEATHER)
                .then().assertThat()
//                .body("main.temp", closeTo(roundedFloat.floatValue(), 1));
                .body("main.temp", lessThanOrEqualTo(calculateKelvin.floatValue()));
        
    }
}
