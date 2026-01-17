package com.masood.springbootcarnet.modules.m_9.controllers;


import com.masood.springbootcarnet.modules.m_9.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    private final LoggedUserManagementService mLoggedUserManagementService;

    public MainController( LoggedUserManagementService loggedUserManagementService) {
        this.mLoggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model page
    ) {

        if (logout != null) {
            mLoggedUserManagementService.setUsername(null);
        }

        String username = mLoggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        }

        page.addAttribute("username" , username);

        return "main.html";
    }





}
