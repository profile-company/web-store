package com.example.webstore.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordSecurity {

    public String passwordEncoder(String password) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);

        return encodePassword;
    }

    public boolean isPasswordMath(String password, String encodePassword) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, encodePassword);
    }
}
