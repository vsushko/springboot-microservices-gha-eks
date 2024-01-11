package com.vsushko.orderservice.domain.port;

import com.vsushko.orderservice.domain.dto.Product;

public interface ProductsRemoteService {
    Product getProduct(long productId);
}
