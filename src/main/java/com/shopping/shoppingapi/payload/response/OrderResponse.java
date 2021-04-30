package com.shopping.shoppingapi.payload.response;

import java.util.List;

public class OrderResponse {
    private List<ResponseOrder> order;
    private List<ResponseCart> cart;

    public OrderResponse() {}

    public OrderResponse(List<ResponseOrder> order, List<ResponseCart> items) {
        this.order = order;
        this.cart = items;
    }

    public List<ResponseOrder> getOrder() {
        return order;
    }

    public void setOrder(List<ResponseOrder> order) {
        this.order = order;
    }

    public List<ResponseCart> getCart() {
        return cart;
    }

    public void setCart(List<ResponseCart> cart) {
        this.cart = cart;
    }
}