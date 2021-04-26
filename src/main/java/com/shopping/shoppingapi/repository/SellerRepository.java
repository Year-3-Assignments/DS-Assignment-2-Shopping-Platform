package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
