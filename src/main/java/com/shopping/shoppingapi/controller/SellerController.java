package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Seller;
import com.shopping.shoppingapi.service.SellerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @CrossOrigin("*")
    @RequestMapping(value = "/api/seller")
    @RestController
    public class SellerController {
        @Autowired
        private SellerServices sellerServices;

        @PostMapping
        public Seller insertBuyer(@RequestBody Seller buyer) {
            return sellerServices.addSellers(buyer);
        }

        @GetMapping
        public List<Seller> getAllBuyers() {
            return sellerServices.getAllSellers();
        }

        @GetMapping("{id}")
        public Seller getBuyerById(@PathVariable int id) {
            return sellerServices.getSellerById(id);
        }

        @DeleteMapping("{id}")
        public String deleteBuyerById(@PathVariable int id) {
            return sellerServices.deleteSellerById(id);
        }

        @PutMapping
        public Seller updateBuyer(@RequestBody Seller seller) {
            return sellerServices.updateSellerById(seller);
        }

    }

