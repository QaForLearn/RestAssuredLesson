package tests;

import dto.LoginDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static methods.FirstTestRestAssured.postLogin;
import static steps.Steps.checkFieldNotNull;
import static util.LoginFactory.getLoginRequest;

public class PostLoginTest {
    LoginDto loginDto = getLoginRequest();

    @Test
    void postLoginTest(){
       Response postResponse = postLogin(loginDto);
       checkFieldNotNull(postResponse, "token");
    }
}
