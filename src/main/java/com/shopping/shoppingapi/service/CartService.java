package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Cart;
import com.shopping.shoppingapi.model.Product;
import com.shopping.shoppingapi.payload.response.ResponseCart;
import com.shopping.shoppingapi.repository.CartRepository;
import com.shopping.shoppingapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<Cart> addProductToCart(Cart cart) {
        Integer quantity;
        Double price;
        Integer productId = null;

        for (Product item : cart.getProducts()) {
            productId = item.getId();
        }

        Product product = productRepository.getProductById(productId);
        quantity = product.getQuantity();
        price = product.getUnitPrice();

        if (quantity > 0 && cart.getQuantity() <= quantity) {
            quantity -= cart.getQuantity();
            product.setQuantity(quantity);
            productRepository.save(product);

            cart.setTotalPrice(price * cart.getQuantity());
            cart.setStatus("PENDING");
            cartRepository.save(cart);
        } else {
            return new ResponseEntity("Quantity too large", HttpStatus.PAYLOAD_TOO_LARGE);
        }

        return new ResponseEntity(cart, HttpStatus.OK);
    }

    public List<Cart> getAllCartItems(Long userId) {
        return cartRepository.getAllCartItems(userId);
    }

    public ResponseEntity<ResponseCart> fetchCartItems(Long userId) {
        List<Cart> carts = cartRepository.getAllCartItems(userId);
        List<ResponseCart> cartList = new ArrayList<>();

        for (Cart item: carts) {
            Product[] products = new Product[item.getProducts().size()];
            item.getProducts().toArray(products);

            ResponseCart responseCart = new ResponseCart(item.getId(), item.getQuantity(), item.getTotalPrice(), item.getStatus(), products[0]);
            cartList.add(responseCart);
        }

        return new ResponseEntity(cartList, HttpStatus.OK);
    }

    public Cart incrementCartItem(Long cartId) {
        Cart cartItem = cartRepository.findById(cartId).orElse(null);
        Integer quantity = cartItem.getQuantity();
        Double productPrice = null;
        Double totalPrice = null;
        Integer productId = null;

        for (Product item : cartItem.getProducts()) {
            productId = item.getId();
            productPrice = item.getUnitPrice();
        }

        quantity += 1;
        totalPrice = quantity * productPrice;

        // reduce product quantity by 1
        Product product = productRepository.getProductById(productId);
        product.setQuantity(product.getQuantity() - 1);
        productRepository.save(product);

        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(totalPrice);
        return cartRepository.save(cartItem);
    }

    public ResponseEntity<Cart> decrementCartItem(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Integer quantity = cart.getQuantity();
        Double productPrice = null;
        Double totalPrice = null;
        Integer productId = null;

        for (Product item : cart.getProducts()) {
            productId = item.getId();
            productPrice = item.getUnitPrice();
        }

        if (quantity > 0) {
            quantity -= 1;
            totalPrice = quantity * productPrice;

            // increment product quantity by 1
            Product product = productRepository.getProductById(productId);
            product.setQuantity(product.getQuantity() + 1);
            productRepository.save(product);

            cart.setQuantity(quantity);
            cart.setTotalPrice(totalPrice);
            cartRepository.save(cart);
            return new ResponseEntity(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error with the quantity", HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteCartItem(Long cartId) {
        Integer productId = null;
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Integer quantity = cart.getQuantity();

        for (Product item : cart.getProducts()) {
            productId = item.getId();
        }

        Product product = productRepository.getProductById(productId);
        product.setQuantity(product.getQuantity() + quantity);

        productRepository.save(product);
        cartRepository.deleteById(cartId);
        return "Cart Item deleted";
    }

    public String deleteCartByUserId(Long userId) {
        cartRepository.deleteAllByUserId(userId);
        return "Purchase cart items remove";
    }
}
