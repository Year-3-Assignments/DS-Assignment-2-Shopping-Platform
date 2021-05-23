package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Order;
import com.shopping.shoppingapi.model.User;
import org.springframework.stereotype.Service;
import com.vonage.client.VonageClient;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

import java.util.Date;

@Service
public class SMSService {
    public void sendSMS(User user, Order order) {
        String phoneNumber = user.getPhoneNumber();

        if(phoneNumber != null){
            Integer orderId = order.getId();
            Date createdDate = order.getCreatedDate();
            VonageClient client = VonageClient.builder().apiKey("6a33ffb2").apiSecret("w4JV0ZpXPsn4wOPn").build();

            TextMessage message = new TextMessage("Your order has been created", phoneNumber,
                    "Order Id:" + orderId + "\nCreated On:" + createdDate + "\nThank You."
            );

            SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
            System.out.println(response.getMessages());
        }
    }
}
