package com.shopping.shoppingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

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

    public Order() {}

    public Order(User user) {
        this.user = user;
        this.orderCode = generateOrderCode();
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
