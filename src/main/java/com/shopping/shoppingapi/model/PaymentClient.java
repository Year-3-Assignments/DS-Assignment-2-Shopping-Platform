package com.shopping.shoppingapi.model;

import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.stripe.Stripe;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentClient {

    @Autowired
    PaymentClient() {
        Stripe.apiKey = "STRIPE SECRET KEY";
    }

    public Charge chargeCreditCart(String token, Double amount) throws Exception {
        Map<String, Object> paymentParameters = new HashMap<String, Object>();
        paymentParameters.put("amount", (int)(amount * 100));
        paymentParameters.put("currency", "LKR");
        paymentParameters.put("source", token);
        Charge charge = Charge.create(paymentParameters);
        return  charge;
    }
}
