package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryDetails, Integer> {
}
