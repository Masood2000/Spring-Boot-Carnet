package com.masood.springbootcarnet.modules.m_14.service;

import com.masood.springbootcarnet.modules.m_14.exception.AccountNotFoundException;
import com.masood.springbootcarnet.modules.m_14.model.Account;
import com.masood.springbootcarnet.modules.m_14.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

//@Service
public class TransferService {

    private final AccountRepository mAccountRepository;

    //@Autowired
    public TransferService(AccountRepository _accountRepository) {
        this.mAccountRepository = _accountRepository;
    }

    //@Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount
    ) {
       Account sender = this.mAccountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
        System.out.println(sender.getId());
        Account receiver = this.mAccountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        this.mAccountRepository.changeAmount(idSender, senderNewAmount);
        this.mAccountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return this.mAccountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return this.mAccountRepository.findAccountsByName(name);
    }


}
