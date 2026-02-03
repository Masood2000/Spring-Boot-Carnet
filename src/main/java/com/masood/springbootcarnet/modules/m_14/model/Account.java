package com.masood.springbootcarnet.modules.m_14.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;

@Getter
@Setter
public class Account {

    @Id
    private Long id;
    private String name;
    private BigDecimal amount;

}


