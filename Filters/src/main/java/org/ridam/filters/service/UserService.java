package org.ridam.filters.service;


import org.ridam.filters.dto.UserDto;
import org.ridam.filters.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepo;
    public UserService(UserRepository userRepo){
        this.userRepo=userRepo;
    }

    public UserDto saveUser(UserDto user){
        UserDto savedUser= userRepo.saveUser(user);
        return  savedUser;
    }

    public List<UserDto> getAllUsers() {
        return userRepo.getAll();
    }
}
