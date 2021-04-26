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
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shopName;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "sellerid")
    private Seller seller;

    @JsonBackReference
    public Seller getSeller() {
        return seller;
    }
}
