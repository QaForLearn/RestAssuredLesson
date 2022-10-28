package steps;

import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Steps {
    public static void checkFieldValue(Response response, String fieldPath, Object expectedValue){
        response.then().extract().path(fieldPath).equals(expectedValue);
    }

    public static void checkFieldNotNull(Response response, String fieldPath){
        assertThat(response.then().extract().path(fieldPath).toString()).isNotNull();
        assertThat(response.then().extract().path(fieldPath).toString()).isNotEqualTo("").contains("");
    }
}
