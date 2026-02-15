package com.masood.springbootcarnet.modules.m_8.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(

            @RequestParam(required = false) String color,
            @RequestParam(required = false) String nationality,
            Model page) {

        page.addAttribute("name","masood");
        page.addAttribute("nationality",nationality);
        page.addAttribute("color",color);

        return "home.html";

    }

    @RequestMapping("/home2/{color}")
    public String home2(
            @PathVariable String color,
            Model page
    ) {


        page.addAttribute("name","masood");
        page.addAttribute("nationality","pakistani");

        page.addAttribute("color",color);



        return "home.html";
    }






}



