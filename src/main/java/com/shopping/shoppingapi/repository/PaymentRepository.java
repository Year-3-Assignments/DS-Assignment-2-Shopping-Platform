package com.shopping.shoppingapi.repository;

import com.shopping.shoppingapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
