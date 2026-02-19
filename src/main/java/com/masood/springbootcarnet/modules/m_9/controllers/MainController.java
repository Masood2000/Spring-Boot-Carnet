package com.masood.springbootcarnet.modules.m_9.controllers;

import com.masood.springbootcarnet.modules.m_9.service.LoggedUserManagementService;
import com.masood.springbootcarnet.modules.m_9.service.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@Controller
public class MainController {

    private final LoggedUserManagementService mLoggedUserManagementService;

    private final LoginCountService mLoginCountService;

    public MainController( LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.mLoggedUserManagementService = loggedUserManagementService;
        this.mLoginCountService = loginCountService;
    }


    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model page
    ) {

        int count = mLoginCountService.getLoginCount();

        if (logout != null) {
            mLoggedUserManagementService.setUsername(null);
        }

        String username = mLoggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        }

        page.addAttribute("username" , username);
        page.addAttribute("count" , count);

        return "main.html";
    }




}
