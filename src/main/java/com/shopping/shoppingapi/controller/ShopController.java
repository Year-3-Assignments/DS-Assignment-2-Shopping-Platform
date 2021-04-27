package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Shop;
import com.shopping.shoppingapi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/shop")
@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('SELLER')")
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.insertShop(shop);
    }

    // Get all shops related to specific seller
    @GetMapping("/seller/{seller_id}")
    @PreAuthorize("hasRole('SELLER')")
    public List<Shop> fetchSellerShops(@PathVariable Long seller_id) {
        return shopService.getSellerShops(seller_id);
    }

    // Get specific shop by shop id
    @GetMapping("/{shop_id}")
    public Shop fetchShopById(@PathVariable Long shop_id) {
        return shopService.getShopById(shop_id);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('SELLER')")
    public Shop updateShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop);
    }

    @DeleteMapping("/remove/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public String removeShop(@PathVariable Long id) {
        return shopService.deleteShop(id);
    }
}
