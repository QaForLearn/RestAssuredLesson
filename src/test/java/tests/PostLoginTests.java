package tests;

import dto.LoginDto;
import org.junit.jupiter.api.*;

import static methods.FirstTestRestAssured.postLogin;
import static util.LoginFactory.getLoginRequest;

public class PostLoginTests {
    LoginDto loginDtoSecond = getLoginRequest();

    @BeforeAll
    public static void preCondition(){
        System.out.println("ОБЩИЕ ПРЕДУСЛОВИЯ");
    }

    @BeforeEach
    public void preConditions(){
        System.out.println("ПРЕДУСЛОВИЯ ПЕРЕД КАЖДЫМ ТЕСТОМ");
    }

    @AfterEach
    public void postConditions(){
        System.out.println("ПОСТУСЛОВИЯ ПОСЛЕ КАЖДОГО ТЕСТА");
    }

    @AfterAll
    public static void postCondition(){
        System.out.println("ОБЩИЕ ПОСТУСЛОВИЯ");
    }


    @Test
    @Disabled
    @DisplayName("Первый тест")
    void postLoginMethodSourceTest(){
        System.out.println("первый тест");
        loginDtoSecond.setUserName(loginDtoSecond.getUserName());
        postLogin(loginDtoSecond);
    }


    @Order(2)
    @RepeatedTest(1)
    @DisplayName("Второй тест")
    void postLoginMethodSourceThirdTest(){
        System.out.println("второй тест");
        loginDtoSecond.setUserName(loginDtoSecond.getUserName());
        postLogin(loginDtoSecond);
    }
}
