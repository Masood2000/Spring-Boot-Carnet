package com.masood.springbootcarnet.modules.m_9.utils;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();
        if ("masood".equals(username) && "meerab".equals(password)) {
            return true;
        } else {
            return false;
        }

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
