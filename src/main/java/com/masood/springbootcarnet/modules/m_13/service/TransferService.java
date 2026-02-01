package com.masood.springbootcarnet.modules.m_13.service;

import com.masood.springbootcarnet.modules.m_13.model.Account;
import com.masood.springbootcarnet.modules.m_13.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

//@Service
public class TransferService {


    private final AccountRepository  mAccountRepository;

    //@Autowired
    public TransferService(AccountRepository _accountRepository) {

        this.mAccountRepository = _accountRepository;

    }

    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount) {

        Account sender = mAccountRepository.findAccountById(senderId);
        Account receiver = mAccountRepository.findAccountById(receiverId);

        if(sender != null && receiver != null) {

            if(sender.getAmount().compareTo(amount) >= 0) {

                BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
                BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

                mAccountRepository.changeAmount(senderId, senderNewAmount);
                //var k = 10/0; for testing purposes
                mAccountRepository.changeAmount(receiverId,receiverNewAmount);
            }

        }


    }


    public List<Account> getAllAccounts() {
        return this.mAccountRepository.getAllAccounts();
    }

}
