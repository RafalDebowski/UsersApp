package com.rafaldebowski.UsersApp.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateUserDto {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String yearOfBirthday;
}
