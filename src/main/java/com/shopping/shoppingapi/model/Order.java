package com.shopping.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderCode;

    private Date createdDate;

    private String status;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToMany
    private Set<Product> products;

    public Order() {}

    public Order(User user, Set<Product> products) {
        this.user = user;
        this.orderCode = generateOrderCode();
        this.createdDate = new Date();
        this.status = "PENDING";
        this.products = products;
    }

    public String generateOrderCode() {
        char[] _base62chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        StringBuilder itemCode = new StringBuilder(15);

        for (int i = 0; i < 15; i++) {
            itemCode.append(_base62chars[random.nextInt(36)]);
        }
        return itemCode.toString();
    }
}
