package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Cart;
import com.shopping.shoppingapi.service.CartService;
import com.shopping.shoppingapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/cart")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<Cart> insertItemToCart(@RequestBody Cart cart) {
        return cartService.addProductToCart(cart);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('BUYER')")
    public List<Cart> getCartItems(@PathVariable Long userId) {
        return cartService.getAllCartItems(userId);
    }

    @PutMapping("/change/add/{cartId}")
    @PreAuthorize("hasRole('BUYER')")
    public Cart addProductToCart(@PathVariable Long cartId) {
        return cartService.incrementCartItem(cartId);
    }

    @PutMapping("/change/remove/{cartId}")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long cartId) {
        return cartService.decrementCartItem(cartId);
    }

    @DeleteMapping("/change/delete/{cartId}")
    @PreAuthorize("hasRole('BUYER')")
    public String deleteCartItem(@PathVariable Long cartId) {
        return cartService.deleteCartItem(cartId);
    }
}
