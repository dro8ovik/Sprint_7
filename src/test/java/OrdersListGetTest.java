import org.junit.Assert;
import org.junit.Test;
import org.scalatest.Assertions;
import responses.OrderResp;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class OrdersListGetTest extends BaseTest {
    @Test
    public void getOrdersListSuccess() {
        List<OrderResp> orders = given()
                .when()
                .get("api/v1/orders")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList("orders", OrderResp.class);
        orders.forEach(x-> Assert.assertNotNull(x.getId()));
        orders.forEach(x-> Assert.assertNotNull(x.getFirstName()));
        orders.forEach(x-> Assert.assertNotNull(x.getLastName()));
        orders.forEach(x-> Assert.assertNotNull(x.getPhone()));
    }
}
