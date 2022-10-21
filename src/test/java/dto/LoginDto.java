package dto;

/*
{
                "username":"String",
                "password":"String",
                "email":"String",
                "address": [ {
                        "region":"String",
                        "city":"String"
                    }
                ]
            }
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class LoginDto {
    String userName;
    String password;
    String email;
    List<AddressElement> address = new ArrayList<>();
}
