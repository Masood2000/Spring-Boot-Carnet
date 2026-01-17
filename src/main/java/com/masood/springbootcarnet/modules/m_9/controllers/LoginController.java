package com.masood.springbootcarnet.modules.m_9.controllers;


import com.masood.springbootcarnet.modules.m_9.utils.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {



    private final LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping(path = "/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping(path = "/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model page) {


        System.out.println(loginProcessor);

        boolean loggedIn = false;

        System.out.println(username + password);
        loginProcessor.setPassword(password);
        loginProcessor.setUsername(username);
        loggedIn = loginProcessor.login();

        if (loggedIn) {
            page.addAttribute("message", "You are now logged in.");
        } else {
            page.addAttribute("message", "Login failed!");
        }
        return "login.html";

    }



}
