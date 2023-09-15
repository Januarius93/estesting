import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Credentials;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.RequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static utils.RequestBody.createLoginRequestBody;

public class LoginTest {
    Credentials credentials = Credentials.builder().username("someusername").password("somepassword").build();
    Credentials credentialsWithoutUsername = Credentials.builder().password("somepwd").build();

    @Test
    public void validateIfUserWithUserNameAndPasswordCanLoginWithHTTP200() throws JSONException {
        given()
                .contentType(ContentType.JSON)
                .body(createLoginRequestBody(credentials))
                .baseUri("http://localhost")
                .port(8181)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body(containsString(String.format("message\":\"login success with credentials: %s %s", credentials.getUsername(), credentials.getPassword())));
    }
}
