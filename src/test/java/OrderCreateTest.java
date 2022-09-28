import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import requests.OrderCreateReq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@RunWith(Parameterized.class)
public class OrderCreateTest extends BaseTest {

    private final OrderCreateReq order;
    private final List<String> colors;



    public OrderCreateTest(List<String> colors) {
        this.order = new OrderCreateReq("Inna",
                "Dubovik",
                "Podkovyrova 14, 1",
                5,
                "+7 800 355 35 35",
                5,
                "2022-11-06",
                "Yep");
        this.colors = colors;
    }


    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new ArrayList<>(List.of("BLACK"))},
                {new ArrayList<>(List.of("GRAY"))},
                {new ArrayList<>(Arrays.asList("GRAY", "BLACK"))},
                {new ArrayList<>()}
        };
    }


    @Test
    public void createOrderParamColorsSuccessMessage() {
        order.setColor(colors);
        given()
                .body(order)
                .when()
                .post("api/v1/orders")
                .then()
                .statusCode(201)
                .assertThat()
                .body("track", notNullValue());
    }
}
