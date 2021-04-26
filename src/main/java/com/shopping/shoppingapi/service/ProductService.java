package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Product;
import com.shopping.shoppingapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
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
