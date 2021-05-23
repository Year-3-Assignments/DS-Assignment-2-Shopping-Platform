package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.*;
import com.shopping.shoppingapi.service.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RequestMapping(value = "/api/payment")
@RestController
public class PaymentController {
    private PaymentClient paymentClient;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @PostMapping("/create")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        // Assign header values
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        String userId = request.getHeader("id");
        return paymentService.makePayment(token, amount, userId, paymentClient);
    }
}
