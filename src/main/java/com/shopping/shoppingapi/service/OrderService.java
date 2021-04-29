package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.repository.OrderRepository;
import com.shopping.shoppingapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.shoppingapi.model.Order;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
    }
}
