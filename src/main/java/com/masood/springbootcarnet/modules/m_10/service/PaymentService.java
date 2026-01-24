package com.masood.springbootcarnet.modules.m_10.service;


import com.masood.springbootcarnet.modules.m_10.exceptions.NotEnoughMoneyException;
import com.masood.springbootcarnet.modules.m_10.models.PaymentDetail;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public PaymentDetail processPayment(double amount) throws NotEnoughMoneyException {

        PaymentDetail pd = new PaymentDetail();

        if(pd.getAmount() - amount > 0 ) {
            pd.setAmount(pd.getAmount() - amount);
            return pd;
        }
        else {
            NotEnoughMoneyException notEnoughMoneyException = new NotEnoughMoneyException();
            notEnoughMoneyException.message = "Appended + "+notEnoughMoneyException.message;
            throw notEnoughMoneyException;
        }

    }


}

