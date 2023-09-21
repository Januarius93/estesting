package utils;

import lombok.SneakyThrows;
import model.Credentials;
import org.json.JSONObject;

public class RequestBody {

    @SneakyThrows
    public static String createSignInRequestBody(Credentials credentials) {
        return new JSONObject()
                .put("username", credentials.getUsername())
                .put("password", credentials.getPassword()).toString();

    }
}
