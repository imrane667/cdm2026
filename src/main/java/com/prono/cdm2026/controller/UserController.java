package com.prono.cdm2026.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prono.cdm2026.service.UserService;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String user(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    
}
