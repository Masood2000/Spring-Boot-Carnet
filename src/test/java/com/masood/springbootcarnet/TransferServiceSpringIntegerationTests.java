package com.masood.springbootcarnet;

import com.masood.springbootcarnet.modules.m_14.model.Account;
import com.masood.springbootcarnet.modules.m_14.repository.AccountRepository;
import com.masood.springbootcarnet.modules.m_14.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegerationTests {

    @MockitoBean
    AccountRepository accountRepository;

    @Autowired
    TransferService transferService;

    @Test
    public void transferServiceTransferAmountTest() {

        Account sender = new Account();
        sender.setAmount(new BigDecimal(1000));
        sender.setId(1L);

        Account reciever = new Account();
        reciever.setAmount(new BigDecimal(1000));
        reciever.setId(2L);

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(reciever));

        transferService.transferMoney(1,2,new BigDecimal(500));

        verify(accountRepository).changeAmount(1,new BigDecimal(500));
        verify(accountRepository).changeAmount(2,new BigDecimal(1500));


    }



}
