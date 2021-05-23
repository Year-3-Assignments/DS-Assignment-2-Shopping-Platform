package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.*;
import com.shopping.shoppingapi.repository.PaymentRepository;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    private Payment addPaymentDetails(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Charge makePayment(String token, Double amount, String userId, PaymentClient paymentClient) throws Exception {
        // Charge the give amount from the credit card using token that given from the Stripe
        Charge charge = paymentClient.chargeCreditCart(token, amount);

       if (charge.getStatus().equals("succeeded")) {
           // Get user details
           User user = userService.getUserById(Long.parseLong(userId));

           // Create payment object to store the payment details
           Payment payment = new Payment(token, user, amount);
           paymentService.addPaymentDetails(payment);

           // Change cart details
           cartService.makeCartItemsPurchased(Long.parseLong(userId), user);
       }

        return charge;
    }
}
