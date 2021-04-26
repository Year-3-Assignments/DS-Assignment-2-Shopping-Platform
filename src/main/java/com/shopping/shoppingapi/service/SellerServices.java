package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Seller;
import com.shopping.shoppingapi.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServices {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller addSellers(Seller seller){
        return sellerRepository.save(seller);
    }

    public List<Seller> getAllSellers(){
        return  sellerRepository.findAll();
    }
    public Seller getSellerById(int seller_id){
        return sellerRepository.findById(seller_id).orElse(null);
    }

    public String deleteSellerById(int seller_id){
        sellerRepository.deleteById(seller_id);
        return "Seller Deleted";
    }

    public Seller updateSellerById(Seller seller){
        Seller existingSeller = sellerRepository.findById(seller.getId()).orElse(null);
        existingSeller.setFirstName(seller.getFirstName());
        existingSeller.setLastName(seller.getLastName());
        existingSeller.setAddress_1(seller.getAddress_1());
        existingSeller.setAddress_2(seller.getAddress_2());
        existingSeller.setCity(seller.getCity());
        existingSeller.setCountry(seller.getCountry());
        existingSeller.setEmail(seller.getEmail());
        existingSeller.setPhoneNumber(seller.getPhoneNumber());
        return sellerRepository.save(existingSeller);
    }

}