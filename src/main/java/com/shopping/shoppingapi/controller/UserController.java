package com.shopping.shoppingapi.controller;


import com.shopping.shoppingapi.model.User;
import com.shopping.shoppingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "/api/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('BUYER') or hasRole('SELLER')")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
