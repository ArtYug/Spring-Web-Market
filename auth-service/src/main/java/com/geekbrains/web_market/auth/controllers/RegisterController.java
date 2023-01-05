package com.geekbrains.web_market.auth.controllers;

import com.geekbrains.web_market.api.auth.RegisterUserDto;
import com.geekbrains.web_market.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void registrateNewUser(@RequestBody RegisterUserDto registerUserDto) {
        // TODO полностью implement method
        //  below is just an example of password hashing
        String bcryptCachedPassword = passwordEncoder.encode(registerUserDto.getPassword());
    }
}
