package org.ridam.filters.controller;

import org.apache.catalina.User;
import org.ridam.filters.dto.UserDto;
import org.ridam.filters.repository.UserRepository;
import org.ridam.filters.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home")
public class UserController {

    private final UserService service;
    public UserController(UserService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PostMapping("/addUser")
    public UserDto createUser(@RequestBody UserDto user){
        return service.saveUser(user);
    }
}
