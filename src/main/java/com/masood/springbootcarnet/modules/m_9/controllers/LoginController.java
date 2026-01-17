package com.masood.springbootcarnet.modules.m_9.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {



    @GetMapping(path = "/login")
    public String login() {
        return "login.html";
    }

    @GetMapping(path = "/")
    public String home() {
        return "hello";
    }


}
