package com.vsushko.orderservice.network;

import com.vsushko.orderservice.domain.dto.Customer;
import com.vsushko.orderservice.domain.port.CustomersRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class CustomersRemoteServiceApiClient implements CustomersRemoteService {

    private final RestClient restClient;

    @Override
    public Customer getCustomer(long customerId) {
        return restClient.get()
                .uri("{customerId}", customerId)
                .retrieve()
                .body(Customer.class);
    }
}