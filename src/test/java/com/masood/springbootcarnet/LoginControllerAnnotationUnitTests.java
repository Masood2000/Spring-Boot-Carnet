package com.masood.springbootcarnet;


import com.masood.springbootcarnet.modules.m_9.controllers.LoginController;
import com.masood.springbootcarnet.modules.m_9.utils.LoginProcessor;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginControllerAnnotationUnitTests {

    @Mock
    Model page;
    @Mock
    LoginProcessor loginProcessor;

    @InjectMocks
    LoginController loginController;



    @Test
    public void loginPostLoginPassTest() {

        String username = "masood";
        String password = "me";

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);


        given(loginProcessor.login()).willReturn(true);

        String result = loginController.loginPost(username,password,page);

        assertEquals(result,"login.html");

        verify(page).addAttribute("message","You are now logged in.");


    }


    @Test
    public void loginPostLoginFailTest() {

        String username = "masood";
        String password = "me";

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);


        given(loginProcessor.login()).willReturn(false);

        String result = loginController.loginPost(username,password,page);

        assertEquals(result,"login.html");

        verify(page).addAttribute("message","Login failed!");


    }


}
