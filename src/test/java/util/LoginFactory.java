package util;

import com.github.javafaker.Faker;
import dto.AddressElement;
import dto.LoginDto;


import java.util.List;
import java.util.Locale;

public class LoginFactory {
    private LoginFactory(){}

    public static LoginDto getLoginRequest(){
        Faker faker = new Faker(new Locale("ru"));
        LoginDto loginDto = new LoginDto();
        loginDto.setUserName(faker.name().username());
        loginDto.setPassword(faker.internet().password());
        loginDto.setEmail(faker.internet().emailAddress());
        AddressElement addressElement = new AddressElement();
        addressElement.setCity(faker.address().city());
        addressElement.setRegion(faker.address().state());
        loginDto.setAddress(List.of(addressElement));
        return loginDto;
    }
}
