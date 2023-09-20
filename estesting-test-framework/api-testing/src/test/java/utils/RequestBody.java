package utils;

import io.restassured.RestAssured;
import lombok.SneakyThrows;
import model.Credentials;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class RequestBody {

    @SneakyThrows
    public static String createSignInRequestBody(Credentials credentials) {
        return new JSONObject()
                .put("username", credentials.getUsername())
                .put("password", credentials.getPassword()).toString();

    }
}
