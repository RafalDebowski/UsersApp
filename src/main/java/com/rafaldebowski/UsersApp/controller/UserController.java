package com.rafaldebowski.UsersApp.controller;

import com.rafaldebowski.UsersApp.domain.User;
import com.rafaldebowski.UsersApp.dto.CreateUserDto;
import com.rafaldebowski.UsersApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<User> CreateUser(@RequestBody @Valid CreateUserDto dto){
        User user = service.createUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = service.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> userById = service.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
}
