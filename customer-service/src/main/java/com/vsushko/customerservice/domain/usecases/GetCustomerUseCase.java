package com.vsushko.customerservice.domain.usecases;

import com.vsushko.customerservice.domain.dao.CustomersRepository;
import com.vsushko.customerservice.domain.exception.CustomerNotFoundException;
import com.vsushko.customerservice.domain.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetCustomerUseCase {

    @Autowired
    private CustomersRepository customersRepository;

    public Customer execute(long customerId) {
        return customersRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
}
