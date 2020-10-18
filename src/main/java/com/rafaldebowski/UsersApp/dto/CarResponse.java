package com.rafaldebowski.UsersApp.dto;

import com.rafaldebowski.UsersApp.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class CarResponse {

    private List<User> users;
}
