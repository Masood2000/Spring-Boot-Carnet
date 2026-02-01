package com.masood.springbootcarnet.modules.m_13.controller;


import com.masood.springbootcarnet.modules.m_13.AccountMapper;
import com.masood.springbootcarnet.modules.m_13.dto.RequestTransfer;
import com.masood.springbootcarnet.modules.m_13.model.Account;
import com.masood.springbootcarnet.modules.m_13.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class AccountController {

    private final TransferService mTransferService;

    //@Autowired
    public AccountController(TransferService _transferService) {
        this.mTransferService = _transferService;
    }

    @GetMapping(path= "/accounts")
    public ResponseEntity<?> getAllAccounts() {

        List<Account> accountList = mTransferService.getAllAccounts();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountList);
    }

    @PostMapping(path = "/accounts")
    public ResponseEntity<?> transferMoney(
            @RequestBody RequestTransfer requestTransfer
    ) {

        this.mTransferService.transferMoney(
                requestTransfer.getSenderAccountId(),
                requestTransfer.getReceiverAccountId(),
                requestTransfer.getAmount()
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("ALL done");

    }

}
