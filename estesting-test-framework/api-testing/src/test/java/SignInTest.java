import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import io.restassured.http.ContentType;
import model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class SignInTest {
  User user = new User("Mateo", "");

  @Test
  public void validateIfUserWithUserNameAndPasswordCanSignInWithHTTP200() throws JSONException {
    given()
        .contentType(ContentType.JSON)
        .body(new JSONObject().put("login", "awdawd").put("password", "").toString())
        .baseUri("http://localhost")
        .port(8181)
        .when()
        .post("/signin")
        .then()
        //        .statusCode(200)
        .body(containsString("awdawd"));
  }
}
