package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select * from cart c, cart_products cp, product p where c.id=cp.cart_id and cp.products_id=p.id and c.user_id=?1", nativeQuery = true)
    List<Cart> getAllCartItems(Long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from cart c where c.user_id=?1", nativeQuery = true)
    void deleteAllByUserId(Long userId);
}
