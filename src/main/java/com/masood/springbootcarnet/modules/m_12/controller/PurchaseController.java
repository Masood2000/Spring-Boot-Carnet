package com.masood.springbootcarnet.modules.m_12.controller;

import com.masood.springbootcarnet.modules.m_12.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    private final PurchaseRepository mPurchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.mPurchaseRepository = purchaseRepository;
    }

    @GetMapping(path="/purchase")
    public void getPurchase() {

    }

    @PostMapping(path = "/purchase")
    public void insertPurchase() {

    }

}
