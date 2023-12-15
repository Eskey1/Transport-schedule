
package com.example.Transport.schedule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MyController {


    @GetMapping("/Main")
    public String index() {

        return "Main";
    }


    @GetMapping("/")
    public  String index1(){
        return "redirect:/Main";
    }

}