package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Shop;
import com.shopping.shoppingapi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/shop")
@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @PostMapping("/add")
    public Shop addShop(@RequestBody Shop shop) {
        return shopService.insertShop(shop);
    }

    @GetMapping("/")
    public List<Shop> fetchAllShop() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop fetchShopById(@PathVariable Integer id) {
        return shopService.getShopById(id);
    }

    @PutMapping("/update")
    public Shop updateShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop);
    }

    @DeleteMapping("/{id}")
    public String removeShop(@PathVariable Integer id) {
        return shopService.deleteShop(id);
    }
}
