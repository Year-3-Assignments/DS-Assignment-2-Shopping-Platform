package com.shopping.shoppingapi.payload.response;

import com.shopping.shoppingapi.model.Product;

public class ResponseCart {
    private Long cartId;
    private Integer quantity;
    private Double totalPrice;
    private String status;
    private Product product;

    public ResponseCart() {}

    public ResponseCart(Long cartId, Integer quantity, Double totalPrice, String status, Product product) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
