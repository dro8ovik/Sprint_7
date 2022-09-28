import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CourierCreateTest extends CourierCreateLoginBaseTest {

    @Test
    public void createCourierSuccessMessage() {
        given()
                .body(courier)
                .when()
                .post("api/v1/courier")
                .then()
                .statusCode(201)
                .assertThat()
                .body("ok", equalTo(true));
    }

    @Test
    public void createCourierNotUniqueErrorMessage() {
        Utils.createCourier(courier);
        given()
                .body(courier)
                .when()
                .post("api/v1/courier")
                .then()
                .statusCode(409)
                .assertThat()
                .body("message", equalTo("Этот логин уже используется"));
    }

    @Test
    public void createCourierWithoutLoginErrorMessage() {
        courier.setLogin("");
        Utils.createCourier(courier);
        given()
                .body(courier)
                .when()
                .post("api/v1/courier")
                .then()
                .statusCode(400)
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    public void createCourierWithoutPassErrorMessage() {
        courier.setPassword("");
        given()
                .body(courier)
                .when()
                .post("api/v1/courier")
                .then()
                .statusCode(400)
                .assertThat()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
