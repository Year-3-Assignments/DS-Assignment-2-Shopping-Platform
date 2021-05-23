package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Product;
import com.shopping.shoppingapi.payload.response.ProductResponse;
import com.shopping.shoppingapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('SELLER')")
    public Product insertProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Get all products in the system
    @GetMapping("/")
    public List<Product> fetchAllProducts() {
        return productService.getProducts();
    }

    // Get product by id
    @GetMapping("/{id}")
    public Object fetchProductById(@PathVariable Integer id) {
        return productService.getProductToShowById(id);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('SELLER')")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public String deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}
