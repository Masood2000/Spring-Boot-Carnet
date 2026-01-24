package com.masood.springbootcarnet.modules.m_10.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @GetMapping(path = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

}
