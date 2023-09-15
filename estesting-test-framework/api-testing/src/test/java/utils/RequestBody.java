package utils;

import io.restassured.RestAssured;
import model.User;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class RequestBody {

    public static String createLoginRequestBody(User user) throws JSONException {
        return new JSONObject()
                .put("username", user.getUsername())
                        .put("password", user.getPassword()).toString();

    }
}
