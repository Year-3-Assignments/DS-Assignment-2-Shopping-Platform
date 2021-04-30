package com.shopping.shoppingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ShoppingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApiApplication.class, args);
    }

}

@RestController
class StartPageController {

    @GetMapping("/")
    public String root() {
        return "<h4>WELCOME TO SHOPPING API BY 2021S1_REG_WE_14</h4>";
    }
}
