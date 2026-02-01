package com.masood.springbootcarnet.modules.m_14.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Account {


    private Long id;
    private String name;
    private BigDecimal amount;

}

