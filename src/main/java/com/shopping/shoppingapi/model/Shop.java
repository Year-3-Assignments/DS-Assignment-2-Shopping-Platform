package com.shopping.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "seller_id")
    private User user;
    @OneToMany(mappedBy = "shop")
    @JsonManagedReference
    private List<Product> products;


    @JsonBackReference
    public User getSeller() {
        return user;
    }
}
