import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import requests.CourierCreateReq;

public abstract class CourierCreateLoginBaseTest extends BaseTest{

    CourierCreateReq courier;
    @Before
    public void createCourier() {
        courier = new CourierCreateReq("Fedya", "1234", "saske");
        Utils.deleteCourierIfExist(courier);
    }

    @After
    public void deleteCourier() {
        Utils.deleteCourierIfExist(courier);
    }
}
