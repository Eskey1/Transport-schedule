package com.example.Transport.schedule.controller;

//import com.example.Transport.schedule.domain.Role;
//import com.example.Transport.schedule.domain.User;
import com.example.Transport.schedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
}
