package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.Product;
import com.shopping.shoppingapi.model.Shop;
import com.shopping.shoppingapi.payload.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    Product getProductById(Integer productId);

    @Query("SELECT p, s FROM Product p, Shop s WHERE p.shop.id=s.id AND p.id = ?1")
    Object getProductToShowBuId(Integer productId);

    @Query(value = "SELECT p FROM Product p")
    List<Product> getProducts();
}
