package org.ridam.spring_security.service;


import org.ridam.spring_security.dto.UserRegisterReqDto;
import org.ridam.spring_security.dto.UserRegisterResDto;
import org.ridam.spring_security.entity.Users;
import org.ridam.spring_security.repository.UserRepository;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    UserRepository userRepository;
    PasswordEncoder encoder=new BCryptPasswordEncoder();
    public AuthService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserRegisterResDto register(UserRegisterReqDto userRegisterReqDto) {
        Users user=new Users();
        user.setUsername("Rishabh");

        String encoded_pwd=encoder.encode(userRegisterReqDto.getPassword());
        user.setPassword(encoded_pwd);

        Users savedUser=userRepository.save(user);

        //output
        UserRegisterResDto userRegisterResDto=new UserRegisterResDto();
        userRegisterResDto.setMessage("user have been saved successfully");
        userRegisterResDto.setUsername(savedUser.getUsername());

        return userRegisterResDto;
    }
}
