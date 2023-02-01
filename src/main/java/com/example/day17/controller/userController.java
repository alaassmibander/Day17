package com.example.day17.controller;

import com.example.day17.Moudle.User;
import com.example.day17.service.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api/v1/user")
@RestController

public class userController {
    private final ServiceUser serviceUser;

    @GetMapping("/get")
    List<User> getUsers() {
        return serviceUser.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity postNewUser(@RequestBody User c) {
        User newUser = serviceUser.addNewUser(c);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Optional<User>> putUser(@PathVariable Integer id, @RequestBody User c) {
        Optional<User> result = serviceUser.updateUser(id, c);
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Optional<String>> deleteUserById(@PathVariable Integer id) {
        if (serviceUser.removeUser(id)) {
            return new ResponseEntity<>(Optional.of("Deleted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(Optional.of("Not Found"), HttpStatus.NOT_FOUND);
    }

}
