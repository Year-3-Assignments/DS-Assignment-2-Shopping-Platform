package com.shopping.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private Double unitPrice;
    private String description;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @JsonBackReference
    public Shop getShop() {
        return shop;
    }
}
