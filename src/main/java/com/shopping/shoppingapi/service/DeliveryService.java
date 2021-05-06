package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.DeliveryDetails;
import com.shopping.shoppingapi.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    /*private User user_id;
    private Order order_id
     private Order order_date;*/

    public DeliveryDetails addDeliveryDetails(DeliveryDetails details){
       /*User user = new User(user_id.getId());
       details.setUser_id(user_id.getId());
        details.setOrder_id(order_id.getOrder_id());
        details.setOrder_date(order_date.getOrder_date());*/
        return deliveryRepository.save(details);
    }

    public List<DeliveryDetails> getAllRecords(){
        return deliveryRepository.findAll();
    }

    public DeliveryDetails getDeliveryDetailById(int id){
        return deliveryRepository.findById(id).orElse(null);
    }

    public String deleteDeliveryDetails(int id){
        deliveryRepository.deleteById(id);
        return "Delivery details deleted successfully!";
    }

    public DeliveryDetails updateDeliveryById(DeliveryDetails deliveryDetails){
        DeliveryDetails existingDetails = deliveryRepository.findById(deliveryDetails.getId()).orElse(null);
        existingDetails.setZip_code(deliveryDetails.getZip_code());
        return deliveryRepository.save(existingDetails);
    }




}
