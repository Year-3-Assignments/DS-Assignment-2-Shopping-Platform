package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Shop;
import com.shopping.shoppingapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public Shop insertShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public Shop getShopById(Long shopId) {
        return shopRepository.findById(shopId).orElse(null);
    }

    public List<Shop> getSellerShops(Long sellerId) {
        return shopRepository.getAllSellerShops(sellerId);
    }

    public Shop updateShop(Shop shop) {
        Shop shopInfo = shopRepository.findById(shop.getId()).orElse(null);
        shopInfo.setShopName(shop.getShopName());
        shopInfo.setPhoneNumber(shop.getPhoneNumber());
        shopInfo.setUser(shop.getSeller());
        return shopRepository.save(shopInfo);
    }

    public String deleteShop(Long shopId) {
        shopRepository.deleteById(shopId);
        return "Deleted shop ID -" + shopId;
    }
}
