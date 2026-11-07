package org.ridam.spring_security.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterReqDto {
    private String username;
    private String password;
}
