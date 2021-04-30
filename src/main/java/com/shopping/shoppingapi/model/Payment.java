package com.shopping.shoppingapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentToken;

    private Date createdDate;

    private Double amount;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Payment() {}

    public Payment(String token, User user, Double amount) {
        this.paymentToken = token;
        this.createdDate = new Date();
        this.amount = amount;
        this.user = user;
    }
}
