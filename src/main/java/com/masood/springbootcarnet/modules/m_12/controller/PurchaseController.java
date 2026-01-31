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
import java.util.List;

//@RestController
public class PurchaseController {

    private final PurchaseRepository mPurchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.mPurchaseRepository = purchaseRepository;
    }

    @GetMapping(path="/purchase")
    public ResponseEntity<?> getPurchase() {

        long startTime,endTime;

        startTime = System.currentTimeMillis();
        List<Purchase> purchasesList = this.mPurchaseRepository.getAllPurchases();
        endTime = System.currentTimeMillis();

        return  ResponseEntity
                .status(HttpStatus.OK)
                .header("Time Taken", String.valueOf(endTime-startTime))
                .body(purchasesList);

    }

    @PostMapping(path = "/purchase")
    public void insertPurchase(
            @RequestBody Purchase purchase
    ) {

        this.mPurchaseRepository.insertPurchase(purchase);
    }
}
