package autoAPI;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class edgeScenario {

    @Test
    public void getMaxListUsers() {
        RestAssured.baseURI = "https://reqres.in/";
        int getListUsers = 12;

        given().when()
                .get("/api/users/"+getListUsers)
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getMinListUsers() {
        RestAssured.baseURI = "https://reqres.in/";
        int getListUsers = 1;

        given().log().all()
                .when().get("/api/users/"+getListUsers)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
