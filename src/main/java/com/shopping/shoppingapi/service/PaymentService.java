package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Payment;
import com.shopping.shoppingapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPaymentDetails(Payment payment) {
        return paymentRepository.save(payment);
    }
}
