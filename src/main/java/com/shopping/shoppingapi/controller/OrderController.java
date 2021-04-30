package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Order;
import com.shopping.shoppingapi.payload.response.OrderResponse;
import com.shopping.shoppingapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<OrderResponse> getOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }

    @PutMapping("/update/{order_id}")
    @PreAuthorize("hasRole('SELLER')")
    public Order updateOrder(@PathVariable Integer order_id) {
        return orderService.updateOrder(order_id);
    }

    @DeleteMapping("/delete/{order_id}")
    @PreAuthorize("hasRole('BUYER')")
    public String removeOrder(@PathVariable Integer order_id) {
        return orderService.deleteOrder(order_id);
    }
}
