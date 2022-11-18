package methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.core.IsEqual.equalTo;
import static util.LoginFactory.getLoginRequest;

public class FirstTestRestAssured {
        void getTest(){
            RestAssured.baseURI = "https://reqres.in/api/users";
            given()
                    .log()
                    .all()
                    .when()
                    .get()
                    .then()
                    .log()
                    .all()
                    .statusCode(SC_OK)
                    .body("sdfs", equalTo(12));
        }

     /*
            {
                "username":"String",
                "password":"String",
                "email":"String",
                "address": [ {
                        "region":"",
                        "city":""
                    }
                ]
            }
      */



        @Step("Отправка запроса и получение ответа")
        public static Response postLogin(Object body){
            RestAssured.baseURI = "https://reqres.in/api";
            ObjectMapper objectMapper = new ObjectMapper();
            return given()
                    .filter(new AllureRestAssured())
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .body(objectMapper.valueToTree(body))
                    .post("/login")
                    .then()
                    .log()
                    .all()
                    .extract()
                    .response();
        }
    }