package com.shopping.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Random;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_code", unique = true)
    private String itemCode;

    @NonNull
    private String productName;

    @NotNull
    private Double unitPrice;

    @Column(length = 1500)
    private String description;

    @NonNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "image_url")
    private String imageUrl;

    @JsonBackReference
    public Shop getShop() {
        return shop;
    }

    public Product() {}

    public Product(@NonNull Integer quantity) {
        this.quantity = quantity;
    }

    public Product(String productName, Double unitPrice, String description, Integer quantity, Shop shop) {
        this.productName = productName;
        this.itemCode = generateItemCode();
        this.unitPrice = unitPrice;
        this.description = description;
        this.quantity = quantity;
        this.shop = shop;
        this.createdAt = new Date();
    }

    public Product(String itemCode, @NonNull String productName, Double unitPrice, Date createdAt, String imageUrl) {
        this.itemCode = itemCode;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
    }

    public String generateItemCode() {
        char[] _base62chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        Random random = new Random();
        StringBuilder itemCode = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            itemCode.append(_base62chars[random.nextInt(36)]);
        }
        return  itemCode.toString();
    }
}
