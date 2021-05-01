package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Cart;
import com.shopping.shoppingapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;


public class EmailServices {
    @Autowired
    private JavaMailSender javaMailSender;
    private User user;
    private Cart cart;

    @GetMapping(value = "/sendEmail")
    //send a simple email
   public String sendSimpleMessage(String toEmail, String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setText(cart.getStatus());
        message.setSubject("Confirmation of Appointment");
        javaMailSender.send(message);
        return "Successfully sent";
    }

}
