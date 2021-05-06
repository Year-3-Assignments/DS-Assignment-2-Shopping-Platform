package com.shopping.shoppingapi.model;

import javax.validation.constraints.NotNull;

public class Email {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String message;

    public Email(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }
}
