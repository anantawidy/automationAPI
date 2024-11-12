package autoAPI;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class positifScenario {

    @Test
    public void getListUsers() {
        RestAssured
                .given().when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("per_page", Matchers.equalTo(6))
                .assertThat().body("page", Matchers.equalTo(2));
    }

    @Test
    public void postListUsers(){
        String name = "Ananta";
        String job = "Student QA";

        JSONObject bodyObject = new JSONObject();

        bodyObject.put("name", name);
        bodyObject.put("job", job);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(bodyObject.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job));
    }
}
