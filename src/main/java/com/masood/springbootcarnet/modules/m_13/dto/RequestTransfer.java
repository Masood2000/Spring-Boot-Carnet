package com.masood.springbootcarnet.modules.m_13.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RequestTransfer {

    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;

}
