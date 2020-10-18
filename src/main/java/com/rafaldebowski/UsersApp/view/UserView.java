package com.rafaldebowski.UsersApp.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserView {

    private String name;

    private String surname;

    private String yearOfBirthday;

}
