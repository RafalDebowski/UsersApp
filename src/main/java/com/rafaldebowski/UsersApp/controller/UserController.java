package com.rafaldebowski.UsersApp.controller;

import com.rafaldebowski.UsersApp.domain.User;
import com.rafaldebowski.UsersApp.dto.CreateUserDto;
import com.rafaldebowski.UsersApp.service.UserService;
import com.rafaldebowski.UsersApp.view.CarView;
import com.rafaldebowski.UsersApp.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final RestTemplate restTemplate;

    private UserService service;

    @Autowired
    public UserController(RestTemplate restTemplate, UserService service) {
        this.restTemplate = restTemplate;
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDto dto) {
        User user = service.createUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = service.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/external/{userId}")
    public List<UserView> getCars(@PathVariable Long userId) {
        return service.getCarsByUserId(userId);

    }


}
