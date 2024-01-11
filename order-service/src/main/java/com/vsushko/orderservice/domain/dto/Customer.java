package com.vsushko.orderservice.domain.dto;

import lombok.Data;

@Data
public class Customer {
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phoneNumber;

    @SuppressWarnings("unused")
    public Customer() {
    }
}
