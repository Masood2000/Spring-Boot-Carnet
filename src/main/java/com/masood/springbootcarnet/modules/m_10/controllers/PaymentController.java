package com.masood.springbootcarnet.modules.m_10.controllers;


import com.masood.springbootcarnet.modules.m_10.exceptions.NotEnoughMoneyException;
import com.masood.springbootcarnet.modules.m_10.models.ErrorDetail;
import com.masood.springbootcarnet.modules.m_10.models.PaymentDetail;
import com.masood.springbootcarnet.modules.m_10.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PaymentController {


    private final PaymentService mPaymentService;

    @Autowired
    public PaymentController(PaymentService _paymentService) {
        this.mPaymentService = _paymentService;
    }


    @PostMapping(path="/payment")
    public ResponseEntity<PaymentDetail> makePayment(
            @RequestBody PaymentDetail paymentDetail
    ) {
        PaymentDetail nPaymentDetail = this.mPaymentService.processPayment(paymentDetail.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(nPaymentDetail);
    }

}
