package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


public class Steps {
    @Step("Проверяем что в поле \"{fieldPath}\" содержится значение \"{expectedValue}\"")
    public static void checkFieldValue(Response response, String fieldPath, Object expectedValue){
        response.then().extract().path(fieldPath).equals(expectedValue);
    }

    public static void checkFieldNotNull(Response response, String fieldPath){
        assertThat(response.then().extract().path(fieldPath).toString()).isNotNull();
        assertThat(response.then().extract().path(fieldPath).toString()).isNotEqualTo("");
    }

    public static void checkFiledIsNull(Response response, String fieldPath){
        assertNull(response.then().extract().path(fieldPath));
    }

    @Step("Проверка что статус код == {code}")
    public static void assertStatusCode(Response response, int code){
        response.then().assertThat()
                .statusCode(code);
    }
}
