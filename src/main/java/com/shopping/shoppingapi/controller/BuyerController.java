package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.Buyer;
import com.shopping.shoppingapi.service.BuyerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/buyer")
@RestController
public class BuyerController {
    @Autowired
    private BuyerServices buyerServices;

    @PostMapping
    public Buyer insertBuyer(@RequestBody Buyer buyer){
        return buyerServices.addBuyers(buyer);
    }

    @GetMapping
    public List<Buyer> getAllBuyers(){
        return buyerServices.getAllBuyers();
    }

    @GetMapping("{id}")
    public Buyer getBuyerById(@PathVariable int id){
        return buyerServices.getBuyerById(id);
    }

    @DeleteMapping("{id}")
    public String deleteBuyerById(@PathVariable int id){
        return buyerServices.deleteBuyerById(id);
    }

    @PutMapping
    public Buyer updateBuyer(@RequestBody Buyer buyer){
        return buyerServices.updateBuyerById(buyer);
    }
}
