package com.vsushko.orderservice.domain.service;

import com.vsushko.orderservice.domain.model.StoreOrder;

/**
 * @author vsushko
 */
public interface StoreOrderService {

    Iterable<StoreOrder> findAll();

    StoreOrder findById(long orderId);

    StoreOrder save(StoreOrder storeOrder);
}
