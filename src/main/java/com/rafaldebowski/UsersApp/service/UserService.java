package com.rafaldebowski.UsersApp.service;

import com.rafaldebowski.UsersApp.domain.User;
import com.rafaldebowski.UsersApp.dto.CreateUserDto;
import com.rafaldebowski.UsersApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(CreateUserDto dto) {

        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .yearOfBirthday(dto.getYearOfBirthday())
                .build();
        return repository.save(user);

    }

    public List<User> getAllUsers() {
        List<User> allUsers = repository.findAll();
        return allUsers;
    }

    public Optional<User> getUserById(Long id) {
        Optional<User> userById = repository.findById(id);
        return userById;
    }
}
