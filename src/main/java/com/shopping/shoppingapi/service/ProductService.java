package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Product;
import com.shopping.shoppingapi.payload.response.ProductResponse;
import com.shopping.shoppingapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        Product newProduct = new Product(product.getProductName(), product.getUnitPrice(),
                product.getDescription(), product.getQuantity(), product.getImageUrl(), product.getShop());
        return productRepository.save(newProduct);
    }

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Object getProductToShowById(Integer productId) {
        return productRepository.getProductToShowBuId(productId);
    }

    public List<Product> getProducts() {
        List<Product> items= productRepository.getProducts();
        return items;
    }

    public Product updateProduct(Product product) {
        Product productInfo = productRepository.findById(product.getId()).orElse(null);

        productInfo.setProductName(product.getProductName());
        productInfo.setUnitPrice(product.getUnitPrice());
        productInfo.setDescription(product.getDescription());
        productInfo.setQuantity(product.getQuantity());
        return productRepository.save(productInfo);
    }

    public String deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        return "Remove product ID - " + productId;
    }
}
