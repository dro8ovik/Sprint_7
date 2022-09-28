import io.restassured.response.Response;
import requests.CourierCreateReq;
import requests.CourierLoginReq;

import static io.restassured.RestAssured.given;

public class Utils {

    private static int getCourierId(CourierLoginReq courier){
       return given()
                .body(courier)
                .when()
                .post("api/v1/courier/login")
                .then()
                .extract().jsonPath().get("id");
    }

    public static void deleteCourier(CourierLoginReq courier){
        int id = getCourierId(courier);
        given()
                .when()
                .delete("api/v1/courier/" + id);
    }

    public static void createCourier(CourierCreateReq courier){
        given()
                .body(courier)
                .when()
                .post( "api/v1/courier");
    }

    public static void deleteCourierIfExist(CourierLoginReq courier){
        Response response = given()
                .body(courier)
                .when()
                .post("api/v1/courier/login");
        if (response.statusCode() == 200){
            deleteCourier(courier);
        }
    }
}
