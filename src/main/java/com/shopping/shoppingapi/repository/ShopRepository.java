package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT shop FROM Shop shop WHERE shop.user.id = ?1")
    List<Shop> getAllSellerShops(Long sellerId);
}
