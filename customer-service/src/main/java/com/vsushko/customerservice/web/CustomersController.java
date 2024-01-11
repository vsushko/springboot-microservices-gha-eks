package com.vsushko.customerservice.web;

import com.vsushko.customerservice.domain.model.Customer;
import com.vsushko.customerservice.domain.usecases.GetAllCustomersUseCase;
import com.vsushko.customerservice.domain.usecases.GetCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api/v1/customers")
public class CustomersController {

    @Autowired
    private GetAllCustomersUseCase getAllCustomersUseCase;
    @Autowired
    private GetCustomerUseCase getCustomerUseCase;

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") long customerId) {
        return getCustomerUseCase.execute(customerId);
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers() {
        return getAllCustomersUseCase.execute();
    }
}
