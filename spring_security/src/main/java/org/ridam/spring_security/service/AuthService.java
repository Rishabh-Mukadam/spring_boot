package org.ridam.spring_security.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.ridam.spring_security.dto.UserRegisterReqDto;
import org.ridam.spring_security.dto.UserRegisterResDto;
import org.ridam.spring_security.entity.Roles;
import org.ridam.spring_security.entity.Users;
import org.ridam.spring_security.repository.RoleRepository;
import org.ridam.spring_security.repository.UserRepository;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder encoder=new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }
    public UserRegisterResDto register(UserRegisterReqDto userRegisterReqDto) {
        Users user=new Users();
        user.setUsername("Rishabh");

        Roles role=roleRepository.findByRollName("admin").get();
        String encoded_pwd=encoder.encode(userRegisterReqDto.getPassword());
        user.setPassword(encoded_pwd);
        user.setEnabled(true);
        user.getRoles().add(role);

        Users savedUser=userRepository.save(user);

        //output
        UserRegisterResDto userRegisterResDto=new UserRegisterResDto();
        userRegisterResDto.setMessage("user have been saved successfully");
        userRegisterResDto.setUsername(savedUser.getUsername());

        return userRegisterResDto;
    }

    public boolean login(Users user) {
        Optional<Users> found_user=userRepository.findByUsername(user.getUsername());
        return encoder.matches(user.getPassword(),found_user.get().getPassword());
    }
}
