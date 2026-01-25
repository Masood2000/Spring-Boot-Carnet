package com.masood.springbootcarnet.modules.m_10.controllers;


import com.masood.springbootcarnet.modules.m_10.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping(path = "/france")
    public Country france() {

        Country c = Country.of("france",6);
        return Country.of("france",6);


    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Country>> all() {

        Country france = Country.of("france",6);
        Country spain = Country.of("spain",7);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","europe")
                .header("capital","paris")
                .header("favourite food","cheese and wine")
                .body(List.of(france,spain));
    }

}

