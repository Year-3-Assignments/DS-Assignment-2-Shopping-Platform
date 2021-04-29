package com.shopping.shoppingapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.shoppingapi.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
