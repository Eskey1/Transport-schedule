package com.example.Transport.schedule.controller;


import com.example.Transport.schedule.Exceptions.UserAlreadyExistException;
import com.example.Transport.schedule.models.UserData;
import com.example.Transport.schedule.repository.UserRepository;
import com.example.Transport.schedule.service.UserDetailsServiceImpl;
import com.example.Transport.schedule.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//    @PostMapping("/registration")
//    public ApplicationUser registerUser(@RequestBody ApplicationUser user) {
//        return userDetailsService.registerUser(user);
//    }
    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/registration")
    public String register(final Model model){
        model.addAttribute("userData", new UserData());
        return "/registration";
    }

    @PostMapping("/registration")
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "/registration";
        }
        try {
            userRegistrationService.register(userData);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "/registration";
        }
        return "redirect:/Main";
    }
}
