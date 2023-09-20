import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Credentials;
import model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.RequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static utils.RequestBody.createLoginRequestBody;

public class LoginTest {
    User user = new User("Mateo", "");

    @Test
    public void validateIfUserWithUserNameAndPasswordCanLoginWithHTTP200() throws JSONException {
    given()
        .contentType(ContentType.JSON)
        .body(new JSONObject().put("login","awdawd").put("password", "").toString())
        .baseUri("http://localhost")
        .port(8181)
        .when()
        .post("/login")
        .then()
//        .statusCode(200)
        .body(
            containsString("awdawd"));
    }
}
