package com.example.castirondev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserRepository repository;


    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Get Users
    @GetMapping("/user")
    List<User> all() {
        System.out.println("HELLO THERE");
        return repository.findAll();
    }
}
