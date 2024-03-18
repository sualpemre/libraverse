package com.libraverse.accountservice.models.account;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {

    @NotEmpty(message = "UserName should not be empty")
    private String userName;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Surname should not be empty")
    private String surname;

    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Şifre en az bir büyük harf, bir küçük harf, bir rakam ve bir özel karakter içermelidir.")
    private String password;

    @NotEmpty(message = "Password should not be empty")
    private String re_password;
}
