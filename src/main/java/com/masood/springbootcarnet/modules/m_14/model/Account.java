package com.masood.springbootcarnet.modules.m_14.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Account {

    @Id
    private Long id;
    private String name;
    private BigDecimal amount;

}
