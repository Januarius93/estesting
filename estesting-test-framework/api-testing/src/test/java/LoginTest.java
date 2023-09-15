import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.RequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class LoginTest {
    User user = new User("someusername", "somepassword");

    @Test
    public void validateIfUserWithUserNameAndPasswordCanLoginWithHTTP200() throws JSONException {
        given()
                .contentType(ContentType.JSON)
                .body(RequestBody.createLoginRequestBody(user))
                .baseUri("http://localhost")
                .port(8181)
                .when()
                .post("/login")
                .then()
                .statusCode(200);

    }
}
