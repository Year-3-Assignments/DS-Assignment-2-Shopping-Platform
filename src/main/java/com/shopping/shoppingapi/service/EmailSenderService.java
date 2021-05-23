package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.Order;
import com.shopping.shoppingapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    private void sendConfirmMail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("shopafy@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        System.out.println("sending email");
    }

    public void setUpSendEmail(User user, Order order) {
        String to = user.getEmail();
        String subject = "New ShopaFy order | " + order.getOrderCode();
        String body = "Dear " + user.getFirstName() + ", \n\nYour order has been created.\nOrder ID - " + order.getOrderCode() +
                "\nCreated Date - " + order.getCreatedDate() + "\n\nThank you for use ShopaFy \uD83D\uDE00";
        sendConfirmMail(to, subject, body);
    }
}
