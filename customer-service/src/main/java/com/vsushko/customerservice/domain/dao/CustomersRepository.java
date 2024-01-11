package com.vsushko.customerservice.domain.dao;

import com.vsushko.customerservice.domain.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
}
