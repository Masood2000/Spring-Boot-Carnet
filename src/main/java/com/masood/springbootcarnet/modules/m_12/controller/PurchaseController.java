package com.masood.springbootcarnet.modules.m_12.controller;

import com.masood.springbootcarnet.modules.m_12.model.Purchase;
import com.masood.springbootcarnet.modules.m_12.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    private final PurchaseRepository mPurchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.mPurchaseRepository = purchaseRepository;
    }

    @GetMapping(path="/purchase")
    public ResponseEntity<?> getPurchase() {

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(this.mPurchaseRepository.getAllPurchases());


    }

    @PostMapping(path = "/purchase")
    public void insertPurchase(
            @RequestBody Purchase purchase
    ) {

        this.mPurchaseRepository.insertPurchase(purchase);

    }

}
