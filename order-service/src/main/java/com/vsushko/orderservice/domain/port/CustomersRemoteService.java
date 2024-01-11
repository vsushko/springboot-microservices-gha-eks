package com.vsushko.orderservice.domain.port;

import com.vsushko.orderservice.domain.dto.Customer;

public interface CustomersRemoteService {
    Customer getCustomer(long customerId);
}
