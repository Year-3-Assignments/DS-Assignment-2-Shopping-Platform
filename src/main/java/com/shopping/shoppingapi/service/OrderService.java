package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.repository.OrderRepository;
import com.shopping.shoppingapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.shoppingapi.model.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);

        existingOrder.setStatus("DELIVERED");
        return orderRepository.save(existingOrder);
    }

    public String deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
        return "Remove order - " + orderId;
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.getOrderByUserId(userId);
    }
}
