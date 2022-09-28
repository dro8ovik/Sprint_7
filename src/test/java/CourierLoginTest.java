import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CourierLoginTest extends CourierCreateLoginBaseTest {

    @Before
    public void regCourier(){
        Utils.createCourier(courier);
    }

    @Test
    public void loginCourierSuccessMessage(){
        given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id", notNullValue());
    }

    @Test
    public void loginCourierWrongLoginErrorMessage(){
        courier.setLogin("qwer");
        given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .statusCode(404)
                .assertThat()
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    public void loginCourierWrongPasswordErrorMessage(){
        courier.setPassword("qwer");
        given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .statusCode(404)
                .assertThat()
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    public void loginCourierWithoutLoginErrorMessage(){
        courier.setLogin("");
        given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .statusCode(400)
                .assertThat()
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    public void loginCourierWithoutPasswordErrorMessage(){
        courier.setPassword("");
        given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .statusCode(400)
                .assertThat()
                .body("message", equalTo("Недостаточно данных для входа"));
    }


    @Test
    public void loginCourierNotExistErrorMessage(){
        courier.setLogin("qwer");
        courier.setPassword("qwer");
        given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .statusCode(404)
                .assertThat()
                .body("message", equalTo("Учетная запись не найдена"));
    }
}
