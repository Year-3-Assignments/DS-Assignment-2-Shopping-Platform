package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.payload.response.OrderResponse;
import com.shopping.shoppingapi.payload.response.ResponseOrder;
import com.shopping.shoppingapi.repository.CartRepository;
import com.shopping.shoppingapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.shopping.shoppingapi.model.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer orderId) {
        Order existingOrder = orderRepository.findById(orderId).orElse(null);

        existingOrder.setStatus("DELIVERED");
        return orderRepository.save(existingOrder);
    }

    public String deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
        return "Remove order - " + orderId;
    }

    public ResponseEntity<OrderResponse> getUserOrders(Long userId) {
        List<Order> orders = orderRepository.getOrderByUserId(userId);
        List<ResponseOrder> orderList = new ArrayList<>();

        for (Order item: orders) {
            ResponseOrder responseOrder = new ResponseOrder(item.getId(), item.getOrderCode(), item.getStatus(), item.getCreatedDate(), item.getProducts());
            orderList.add(responseOrder);
        }

        ResponseEntity responseEntity = new ResponseEntity(orderList, HttpStatus.OK);

        return responseEntity;
    }
}
