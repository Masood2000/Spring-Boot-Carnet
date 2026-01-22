package com.masood.springbootcarnet.modules.m_9.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Service
public class LoginCountService {

    private int loginCount = 0;

    public void setLoginCount(int loginCount) {
        this.loginCount = loginCount;
    }

    public int getLoginCount() {
        return loginCount;
    }


}
