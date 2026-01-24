package com.masood.springbootcarnet.modules.m_10.service;


import com.masood.springbootcarnet.modules.m_10.exceptions.NotEnoughMoneyException;
import com.masood.springbootcarnet.modules.m_10.models.PaymentDetail;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public PaymentDetail processPayment() throws NotEnoughMoneyException {

        Random rd = new Random();

        int n = rd.nextInt();

        if(n%2 == 0 ) {
            PaymentDetail pd = new PaymentDetail();
            pd.setAmount(500.55);
            return pd;
        }
        else {
            NotEnoughMoneyException notEnoughMoneyException = new NotEnoughMoneyException();
            notEnoughMoneyException.message = "Appended + "+notEnoughMoneyException.message;
            throw notEnoughMoneyException;
        }

    }


}

