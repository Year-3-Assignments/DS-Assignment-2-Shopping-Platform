package com.shopping.shoppingapi.service;

import com.shopping.shoppingapi.model.User;
import com.shopping.shoppingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }
}
