package com.example.castirondev.user;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserRepository repository;

    private final UserModelAssembler assembler;

    public UserController(UserRepository repository, UserModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // Get All Users
    @GetMapping("/users")
    CollectionModel<EntityModel<User>> all() {

        List<EntityModel<User>> users = repository
                .findAll()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @GetMapping("/user/{id}")
    EntityModel<User> getUser(@PathVariable Long id) {
        String error = "error idiot";
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException(error));

        return assembler.toModel(user);
    }

    @PostMapping("/user")
    ResponseEntity<?> newUser(@RequestBody User newUser) {
        EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    @PutMapping("/user/{id}")
    ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {

        User updatedUser = repository.findById(id)
                .map(u -> {
                    u.setUsername(u.getUsername());
                    u.setPassword(u.getPassword());
                    u.setActive(u.getActive());

                    return repository.save(u);
                }).orElseGet(() -> {
                    user.setId(id);
                    return repository.save(user);
                });

        EntityModel<User> entityModel = assembler.toModel(updatedUser);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

}
