package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.*;
import com.shopping.shoppingapi.repository.CartRepository;
import com.shopping.shoppingapi.service.CartService;
import com.shopping.shoppingapi.service.OrderService;
import com.shopping.shoppingapi.service.PaymentService;
import com.shopping.shoppingapi.service.UserService;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RequestMapping(value = "/api/payment")
@RestController
public class PaymentController {
    private PaymentClient paymentClient;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @PostMapping("/create")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        String userId = request.getHeader("id");

        // Get user details by id which sent from the request header
        User user = userService.getUserById(Long.parseLong(userId));

        // Charge the give amount from the credit card using token that given from the Stripe
        Charge charge = this.paymentClient.chargeCreditCart(token, amount);

        // Create payment object to store the payment details
        Payment payment = new Payment(token, user, amount);
        paymentService.addPaymentDetails(payment);

        // Update cart details
        List<Cart> cartItems = cartService.getAllCartItems(Long.parseLong(userId));
        Set<Product> cartProducts = new HashSet<>();

        for (Cart item: cartItems) {
            for (Product product: item.getProducts()) {
                if (item.getStatus().equals("PENDING")) {
                    cartProducts.add(product);
                }
            }
            // Mark cart items to purchased
            item.setStatus("PURCHASED");
            cartRepository.save(item);
        }

        // Create order
        Order order = new Order(user, cartProducts);
        orderService.addOrder(order);

        // Add delivery

        return charge;
    }
}
