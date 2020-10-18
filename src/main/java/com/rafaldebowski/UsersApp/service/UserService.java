package com.rafaldebowski.UsersApp.service;

import com.rafaldebowski.UsersApp.controller.RestTemplateConfig;
import com.rafaldebowski.UsersApp.domain.User;
import com.rafaldebowski.UsersApp.dto.CreateUserDto;
import com.rafaldebowski.UsersApp.repository.UserRepository;
import com.rafaldebowski.UsersApp.view.CarView;
import com.rafaldebowski.UsersApp.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final RestTemplateConfig restTemplateConfig;
    private static String CARS_URL = "http://localhost:8080/cars/external";
    private UserRepository repository;

    @Autowired
    public UserService(RestTemplateConfig restTemplateConfig, UserRepository repository) {
        this.restTemplateConfig = restTemplateConfig;
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

    public List<UserView> getCarsByUserId(Long id) {
        return repository.findAllByUserId(id)
                .stream().map(c -> new UserView(c.getName(), c.getSurname(), c.getYearOfBirthday()))
                .collect(Collectors.toList());
    }


    private CarView getCarFromExternalService(Long userId) {
        return restTemplateConfig.restTemplate().getForObject(CARS_URL + userId, CarView.class);
    }


}
