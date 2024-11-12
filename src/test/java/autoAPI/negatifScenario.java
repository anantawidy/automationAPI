package autoAPI;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class negatifScenario {

    @Test
    public void wrongURLDeleteUsers(){
        RestAssured.baseURI = "https://reqres.in";

            given().log().all()
                    .when().delete("api/")
                    .then()
                    .log().all()
                    .assertThat().statusCode(404);
    }

}

