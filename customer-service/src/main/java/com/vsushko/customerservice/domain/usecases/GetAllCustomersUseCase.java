package com.vsushko.customerservice.domain.usecases;

import com.vsushko.customerservice.domain.dao.CustomersRepository;
import com.vsushko.customerservice.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllCustomersUseCase {

    @Autowired
    private CustomersRepository customersRepository;

    public Iterable<Customer> execute() {
        return customersRepository.findAll();
    }
}
