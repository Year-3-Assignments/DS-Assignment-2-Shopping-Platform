package com.shopping.shoppingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.shoppingapi.model.Order;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer>{

    @Query("SELECT o FROM Order o WHERE o.user.id = ?1")
    List<Order> getOrderByUserId(Long userId);
}
