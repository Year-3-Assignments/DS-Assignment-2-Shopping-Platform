package com.shopping.shoppingapi.payload.response;

import com.shopping.shoppingapi.model.Product;
import com.shopping.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

public class ProductResponse {
    private Integer id;
    private String itemCode;
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private String description;
    private Date createdAt;
    private String imageUrl;
    private Integer shopId;
    private String shopName;
    private String phoneNumber;
    private String sellerFirstName;
    private String sellerLastName;
    private String email;
    private String address_1;
    private String address_2;
    private String city;
    private String sellerImageUrl;

    public ProductResponse() {};

    public void setProducts(List<Product> products, List<Shop> shops) {
        for (Product product: products) {
            this.id = product.getId();
            this.itemCode = product.getItemCode();
            this.productName = product.getProductName();
            this.unitPrice = product.getUnitPrice();
            this.quantity = product.getQuantity();
            this.description = product.getDescription();
            this.createdAt = product.getCreatedAt();
            this.imageUrl = product.getImageUrl();
        }
    }

    public ProductResponse(Integer id, String itemCode, String productName,
                           Double unitPrice, Integer quantity, String description,
                           Date createdAt, String imageUrl, Integer shopId,
                           String shopName, String phoneNumber, String sellerFirstName,
                           String sellerLastName, String email, String address_1,
                           String address_2, String city, String sellerImageUrl) {
        this.id = id;
        this.itemCode = itemCode;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.description = description;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.shopId = shopId;
        this.shopName = shopName;
        this.phoneNumber = phoneNumber;
        this.sellerFirstName = sellerFirstName;
        this.sellerLastName = sellerLastName;
        this.email = email;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.sellerImageUrl = sellerImageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSellerImageUrl() {
        return sellerImageUrl;
    }

    public void setSellerImageUrl(String sellerImageUrl) {
        this.sellerImageUrl = sellerImageUrl;
    }
}
