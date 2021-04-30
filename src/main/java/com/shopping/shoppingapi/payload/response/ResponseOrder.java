package com.shopping.shoppingapi.payload.response;

import com.shopping.shoppingapi.model.Product;

import java.util.Date;
import java.util.Set;

public class ResponseOrder {
    private Integer id;
    private String orderCode;
    private String status;
    private Date createdDate;
    private Set<Product> products;

    public ResponseOrder() {};

    public ResponseOrder(Integer id, String orderCode, String status, Date createdDate, Set<Product> products) {
        this.id = id;
        this.orderCode = orderCode;
        this.status = status;
        this.createdDate = createdDate;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
