package com.masood.springbootcarnet.modules.m_10.service;


import com.masood.springbootcarnet.modules.m_10.exceptions.NotEnoughMoneyException;
import com.masood.springbootcarnet.modules.m_10.models.PaymentDetail;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetail processPayment() throws NotEnoughMoneyException {
        //throw new NotEnoughMoneyException();

        PaymentDetail pd = new PaymentDetail();
        pd.setAmount(500.55);
        return pd;
    }


}

