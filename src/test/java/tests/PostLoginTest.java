package tests;

import dto.LoginDto;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static methods.FirstTestRestAssured.postLogin;
import static steps.Steps.checkFieldNotNull;
import static steps.Steps.checkFieldValue;
import static util.LoginFactory.getLoginRequest;
@DisplayName("Второй сьют")
@Epic("QA Learn")
@Feature("RestAssured")
@Story("Allures")
public class PostLoginTest {
    static LoginDto loginDto = getLoginRequest();

    @ParameterizedTest(name = "Проверка логина с именем \"{0}\", и паролем \"{1}\"")
    @ValueSource(strings = {"Sergei", "Vlad"})
    void postValueSourceTest(String name){
        loginDto.setUserName(name);
        Response postResponse = postLogin(loginDto);
        checkFieldValue(postResponse, "userName", loginDto.getUserName());
    }


    @ParameterizedTest(name = "Проверка логина с именем \"{0}\", и паролем \"{1}\"")
    @CsvSource(value = {"Sergei | parol", "Vlad | parol2"}, delimiter = '|')
    void postCsvSourceTest(String name, String password){
        loginDto.setUserName(name);
        loginDto.setPassword(password);
        Response postResponse = postLogin(loginDto);
        checkFieldValue(postResponse, "userName", loginDto.getUserName());
    }

    @ParameterizedTest(name = "Проверка логина с именем \"{0}\"")
    @EnumSource(RequestParams.class)
    void postEnumTest(RequestParams requestParams){
        loginDto.setUserName(String.valueOf(requestParams));
        Response postResponse = postLogin(loginDto);
        checkFieldValue(postResponse, "userName", loginDto.getUserName());
    }


    public static Stream<Arguments> requestsObjects(){
        return Stream.of(
                Arguments.of(loginDto, loginDto.getUserName())
        );
    }

    @ParameterizedTest(name = "Проверка логина с именем {1}")
    @MethodSource("requestsObjects")
    void postLoginMethodSourceTest(LoginDto loginDto, String username){
        loginDto.setUserName(username);
        postLogin(loginDto);
    }

}
