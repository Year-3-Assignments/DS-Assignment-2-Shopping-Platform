package com.shopping.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer quantity;

    private Double totalPrice;

    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private Set<Product> products;

    public Cart() {}

    public Cart(Integer quantity, Double totalPrice, String status, Set<Product> products) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.products = products;
    }
}
