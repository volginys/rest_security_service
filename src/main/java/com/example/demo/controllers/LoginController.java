package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping()
    public String getLogin(){
        return "redirect:/login";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
}
