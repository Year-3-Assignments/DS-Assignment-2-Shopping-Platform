package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT c FROM Cart c WHERE c.user.id = ?1")
    List<Cart> getAllCartItems(Long userId);
}
