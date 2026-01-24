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

@Controller
public class PaymentController {


    private final PaymentService mPaymentService;

    @Autowired
    public PaymentController(PaymentService _paymentService) {
        this.mPaymentService = _paymentService;
    }


    @PostMapping(path="/payment")
    public ResponseEntity<?> makePayment() {

        try{
            PaymentDetail paymentDetail = this.mPaymentService.processPayment();
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetail);

        } catch (NotEnoughMoneyException neme){

            System.out.println(neme.getMessage());
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setMessage("Insufficient Balance");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetail);
        }
    }

}
