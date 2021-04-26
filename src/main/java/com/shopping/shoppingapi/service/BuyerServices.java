package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Buyer;
import com.shopping.shoppingapi.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServices {
    @Autowired
    private BuyerRepository buyerRepository;

    public Buyer addBuyers(Buyer buyer){
        return buyerRepository.save(buyer);
    }

    public List<Buyer> getAllBuyers(){
        return  buyerRepository.findAll();
    }
    public Buyer getBuyerById(int buyer_id){
        return buyerRepository.findById(buyer_id).orElse(null);
    }

    public String deleteBuyerById(int buyer_id){
        buyerRepository.deleteById(buyer_id);
        return "Buyer Deleted";
    }

    public Buyer updateBuyerById(Buyer buyer){
        Buyer existingBuyer = buyerRepository.findById(buyer.getId()).orElse(null);
        existingBuyer.setFirst_name(buyer.getFirst_name());
        existingBuyer.setLast_name(buyer.getLast_name());
        existingBuyer.setEmail(buyer.getEmail());
        existingBuyer.setAddress1(buyer.getAddress1());
        existingBuyer.setAddress2(buyer.getAddress2());
        existingBuyer.setCity(buyer.getCity());
        existingBuyer.setCountry(buyer.getCountry());
        return buyerRepository.save(existingBuyer);
    }

}
