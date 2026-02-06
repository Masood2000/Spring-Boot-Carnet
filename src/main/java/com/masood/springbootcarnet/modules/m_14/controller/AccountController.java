package com.masood.springbootcarnet.modules.m_14.controller;

import com.masood.springbootcarnet.modules.m_14.dto.TransferRequest;
import com.masood.springbootcarnet.modules.m_14.model.Account;
import com.masood.springbootcarnet.modules.m_14.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService mTransferService;

    @Autowired
    public AccountController(TransferService _transferService) {
        this.mTransferService = _transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) {
        mTransferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts( @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return mTransferService.getAllAccounts();
        } else {
            return mTransferService.findAccountsByName(name);
        }
    }


}
