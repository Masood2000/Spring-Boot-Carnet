package com.masood.springbootcarnet.modules.m_11.controllers;


import com.masood.springbootcarnet.modules.m_11.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping(path = "/payment")
    public ResponseEntity<Payment> makePayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {

        logger.info("Received request with ID " + requestId + " ;Payment Amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);

    }

}
