package tests;
import org.junit.jupiter.api.Test;

import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;

import static com.codeborne.selenide.Selenide.*;


public class SeleniumTest {
    @Test
    void seleniumTest(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[placeholder='First Name']").setValue("Владислав");
        $("[placeholder='First Name']").shouldHave(value("Владислав"));
        $("#dateOfBirthInput").clear();
        $("#dateOfBirthInput").setValue("07 Dec 2022");
        $("[for='gender-radio-1']").click();
        $("#uploadPicture").uploadFile(new File(""));
    }
}
