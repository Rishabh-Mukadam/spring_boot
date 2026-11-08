package org.ridam.spring_security.service;

import org.ridam.spring_security.entity.CustomUserDetails;
import org.ridam.spring_security.entity.Users;
import org.ridam.spring_security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.DelegatingFilterProxy;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user= userRepository.findByUsername(username).orElseThrow(
                ()->new UsernameNotFoundException("User not register")
        );
        CustomUserDetails customUserDetails=new CustomUserDetails(user);

        return customUserDetails;
    }
}
