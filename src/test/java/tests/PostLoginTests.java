package tests;

import dto.LoginDto;
import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;
import static methods.FirstTestRestAssured.postLogin;

import static steps.Steps.assertStatusCode;
import static steps.Steps.checkFieldValue;
import static util.LoginFactory.getLoginRequest;


@Epic("QA Learn")
@Feature("RestAssured")
@Story("Allure")
@Owner("Sergei Mukhortov")
@ExtendWith(AllureJunit5.class)
@DisplayName("Первый сьют")
public class PostLoginTests {
    LoginDto loginDtoSecond = getLoginRequest();

    @BeforeAll
    public static void preCondition(){
        System.out.println("ОБЩИЕ ПРЕДУСЛОВИЯ");
    }

    @BeforeEach
    public void preConditions(){
        postLogin(loginDtoSecond);
        System.out.println("ПРЕДУСЛОВИЯ ПЕРЕД КАЖДЫМ ТЕСТОМ");
    }

    @AfterEach
    public void postConditions(){
        postLogin(loginDtoSecond);
        System.out.println("ПОСТУСЛОВИЯ ПОСЛЕ КАЖДОГО ТЕСТА");
    }

    @AfterAll
    public static void postCondition(){
        System.out.println("ОБЩИЕ ПОСТУСЛОВИЯ");
    }


    @Test
//    @Disabled
    @DisplayName("Первый тест")
    @Issue("Деффект кривой жопы")
    @Tag("postLogin")
    @Link(type = "manual", value = "asfasf")
    @TmsLink("324523635475645tyr23532652436e")
    void postLoginMethodSourceTest(){
        System.out.println("первый тест");
        loginDtoSecond.setUserName(loginDtoSecond.getUserName());
        Response response = postLogin(loginDtoSecond);
        step("Проверяем ответ на запрос", () -> {
            assertStatusCode(response, 400);
            checkFieldValue(response, "error", "user not found");
        });
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
