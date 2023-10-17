package com.example.Transport.schedule.controller;


import com.example.Transport.schedule.models.ApplicationUser;
import com.example.Transport.schedule.repository.UserRepository;
import com.example.Transport.schedule.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody ApplicationUser user) {
        return userDetailsService.registerUser(user);
    }
}
