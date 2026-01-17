package com.masood.springbootcarnet.modules.m_9.utils;


import com.masood.springbootcarnet.modules.m_9.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {


    public final LoggedUserManagementService mLoggedUserManagementService;


    @Autowired
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.mLoggedUserManagementService = loggedUserManagementService;
    }


    private String username;
    private String password;

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;

        if ("masood".equals(username) && "meerab".equals(password)) {
            loginResult = true;
            mLoggedUserManagementService.setUsername(username);
        }

        return  loginResult;

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
