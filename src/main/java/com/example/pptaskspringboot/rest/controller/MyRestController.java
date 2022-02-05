package com.example.pptaskspringboot.rest.controller;

import com.example.pptaskspringboot.rest.exception_handling.NoSuchUserException;
import com.example.pptaskspringboot.rest.model.User;
import com.example.pptaskspringboot.rest.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RestController
@RequestMapping("/admin")
public class MyRestController {
    private final AppService appService;

    @Autowired
    public MyRestController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(appService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> showUser(@PathVariable Long id) {
        return new ResponseEntity<>(appService.show(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        appService.add(user);
        return user;
    }

    @PutMapping(value = "/users")
    public User updateUser(@RequestBody User user) {
        System.out.println("User :"+user);
        appService.update(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = appService.show(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with id = " + id + " in database");
        }
        appService.delete(id);
        return "User with id = " + id + " was delete";
    }
}
