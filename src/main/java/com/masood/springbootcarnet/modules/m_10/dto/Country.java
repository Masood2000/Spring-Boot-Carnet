package com.masood.springbootcarnet.modules.m_10.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private String name;
    private int population;


    public static Country of(String _name, int _population) {

        Country c = new Country();
        c.name  = _name;
        c.population = _population;
        return c;

    }

}
