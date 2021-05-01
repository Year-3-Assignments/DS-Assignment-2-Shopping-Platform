package com.shopping.shoppingapi;

import com.shopping.shoppingapi.service.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ShoppingApiApplication {

    @Autowired
    private EmailServices emailServices;
    public static void main(String[] args) {
        SpringApplication.run(ShoppingApiApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail(){
        emailServices.sendSimpleMessage("nimal33@gmail.com","","Confirmation of Appointment");
    }
}

@RestController
class StartPageController {

    @GetMapping("/")
    public String root() {
        return "<h4>WELCOME TO SHOPPING API BY 2021S1_REG_WE_14</h4>";
    }
}
