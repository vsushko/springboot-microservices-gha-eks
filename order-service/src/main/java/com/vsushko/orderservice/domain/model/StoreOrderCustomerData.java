package com.vsushko.orderservice.domain.model;

import com.vsushko.orderservice.domain.dto.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class StoreOrderCustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private Long customerId;

    @NotNull
    @Column
    private String firstName;

    @NotNull
    @Column
    private String lastName;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private String address;

    @NotNull
    @Column
    private String phoneNumber;

    @SuppressWarnings("unused")
    public StoreOrderCustomerData() {
    }

    public StoreOrderCustomerData(Customer customer) {
        customerId = customer.getId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        email = customer.getEmail();
        address = customer.getAddress();
        phoneNumber = customer.getPhoneNumber();
    }
}
