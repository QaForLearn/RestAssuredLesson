package steps;

import io.restassured.response.Response;

public class Steps {
    public static void checkFieldValue(Response response, String fieldPath, Object expectedValue){
        response.then().extract().path(fieldPath).equals(expectedValue);

    }
}
