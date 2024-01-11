package com.vsushko.orderservice.network;

import com.vsushko.orderservice.domain.dto.Product;
import com.vsushko.orderservice.domain.port.ProductsRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class ProductsRemoteServiceApiClient implements ProductsRemoteService {

    private final RestClient restClient;

    @Override
    public Product getProduct(long productId) {
        return restClient.get()
                .uri("{productId}", productId)
                .retrieve()
                .body(Product.class);
    }
}
