package org.ridam.spring_security.controller;

import org.ridam.spring_security.dto.UserRegisterReqDto;
import org.ridam.spring_security.dto.UserRegisterResDto;
import org.ridam.spring_security.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/api")
public class UserController {

    AuthService authService;
    public UserController(AuthService authService){
        this.authService=authService;
    }


    @PostMapping("/register")
    public UserRegisterResDto registerUser(@RequestBody  UserRegisterReqDto userRegisterReqDto){
        System.out.println(userRegisterReqDto.getPassword());
        System.out.println(userRegisterReqDto.getUsername());
      return authService.register(userRegisterReqDto);
    }

    @GetMapping("/getCSRF")
    public CsrfToken get_csrf(CsrfToken csrfToken){
        return csrfToken;
    }
}
