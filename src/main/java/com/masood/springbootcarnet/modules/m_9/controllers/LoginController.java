package com.masood.springbootcarnet.modules.m_9.controllers;

import com.masood.springbootcarnet.modules.m_9.utils.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class LoginController {

    private final LoginProcessor mLoginProcessor;

    //@Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.mLoginProcessor = loginProcessor;
    }

    @GetMapping(path = "/")
    public String loginGet() {

        System.out.println(mLoginProcessor);
        System.out.println(mLoginProcessor.mLoggedUserManagementService);

        return "login.html";
    }


    @PostMapping(path = "/")
    public String loginPost( @RequestParam String username, @RequestParam String password, Model page) {

        System.out.println(mLoginProcessor);
        System.out.println(mLoginProcessor.mLoggedUserManagementService);

        boolean loggedIn = false;

        System.out.println(username + password);
        mLoginProcessor.setPassword(password);
        mLoginProcessor.setUsername(username);
        loggedIn = mLoginProcessor.login();

        if (loggedIn) {
            return "redirect:/main";
        }
        else {
            page.addAttribute("message", "Login failed!");
        }
        return "login.html";

    }



}
