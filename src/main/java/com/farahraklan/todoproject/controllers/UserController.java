package com.farahraklan.todoproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @GetMapping()
    public String home() {
        return "WELCOME TO TODO PROJECT HOMEPAGE";
    }

    @GetMapping("/signin")
    public String signin() {
        return "YOU ARE ABLE TO VIEW TODO TASKS";
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "YOU HAVE LOGOUT";
    }

}
