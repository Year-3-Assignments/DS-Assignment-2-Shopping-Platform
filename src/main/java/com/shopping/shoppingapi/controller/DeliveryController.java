package com.shopping.shoppingapi.controller;

import com.shopping.shoppingapi.model.DeliveryDetails;
import com.shopping.shoppingapi.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value="/api/delivery")
@RestController
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/delivery")
    public DeliveryDetails addDeliveryInfo(@RequestBody DeliveryDetails delivery){
        return deliveryService.addDeliveryDetails(delivery);
    }
    @GetMapping("/delivery/id")
    public List<DeliveryDetails> getDeliveryDetails(int id) {
        return deliveryService.getAllRecords();
    }
    @GetMapping("/{id}")
    public DeliveryDetails getDeliveryDetailsById(@PathVariable int id){
        return deliveryService.getDeliveryDetailById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteDeliveryDetailById(@PathVariable int id){
        return deliveryService.deleteDeliveryDetails(id);
    }

    @PutMapping("/updatedelivery")
    public DeliveryDetails updateDeliveryInfo(@RequestBody DeliveryDetails deliveryDetails){
        return deliveryService.updateDeliveryById(deliveryDetails);
    }

}
