package com.shopping.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String address_1;

    private String address_2;

    private String city;

    private String username;

    @JsonIgnore
    private String password;

    @Column(length = 2000)
    private String imageUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() { }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long userid, String address_1, String address_2, String city, String email){
        this.id = userid;
        this.email = email;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
    }
    public User(String firstName, String lastName, String phoneNumber, String username, String email,
                String address_1, String address_2, String city, String encode, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.username = username;
        this.password = encode;
        this.imageUrl = imageUrl;
    }
}
