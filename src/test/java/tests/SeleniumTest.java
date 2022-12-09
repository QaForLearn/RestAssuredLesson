package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;

import java.io.File;


import static com.codeborne.selenide.Condition.text;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SeleniumTest {


    String firstName = "Vladislav";
    String lastName = "Ivanov";
    String userEmail = "vladislav@ivanov.net";
    String userNumber = "9999999999";
    String subject = "Physics";
    String currentAddress = "Pacific Ocean";

    @Test
    void seleniumTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName); // вводим имя
        $("#lastName").setValue(lastName); // вводим фамилию
        $("#userEmail").setValue(userEmail); // вводим почту
        $("#userNumber").setValue(userNumber); // вводим номер телефона
        $("[id=subjectsInput]").setValue(subject).pressEnter(); // выбираем из списка
        $("[id=currentAddress]").setValue(currentAddress).pressEnter(); // вводим адрес
        $("[for=gender-radio-3]").click(); // идентифицируем себя как вертолет апач
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click(); // выбираем радиобаттоны
        $x("//input[@id=\"dateOfBirthInput\"]").click();
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--001").click(); // выбираем год, месяц, день в календаре
        $(byText("Select State")).click();
        $(byText("Uttar Pradesh")).click();
        $(byText("Select City")).click();
        $(byText("Agra")).click(); // выбираем штат и город из выпадающих списков
        $("#uploadPicture").uploadFile(new File("src/test/resources/harold.jpg")); // загружаем файл
        $("[id=submit]").click(); // кликаем на кнопку
        $(".table-responsive").shouldHave(
                text("Student name"), text(firstName + ' ' + lastName),
                text("Student Email"), text(userEmail),
                text("Gender"), text("Other"),
                text("Mobile"), text(userNumber),
                text("Date Of Birth"), text("01 January,1900"),
                text("Subject"), text(subject),
                text("Address"), text(currentAddress),
                text("Hobbies"), text("Sports, Reading, Music"),
                text("Picture"), text("harold.jpg"),
                text("State and City"), text("Uttar Pradesh Agra")
        ); // проверяем форму
    }
}
