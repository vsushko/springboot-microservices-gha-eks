package com.vsushko.orderservice.domain.service.impl;

import com.vsushko.orderservice.domain.exception.OrderNotFoundException;
import com.vsushko.orderservice.domain.model.StoreOrder;
import com.vsushko.orderservice.domain.repository.StoreOrderRepository;
import com.vsushko.orderservice.domain.service.StoreOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreOrderServiceServiceImpl implements StoreOrderService {

    private final StoreOrderRepository storeOrderRepository;

    @Override
    public Iterable<StoreOrder> findAll() {
        return storeOrderRepository.findAll();
    }

    @Override
    public StoreOrder findById(long orderId) {
        return storeOrderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public StoreOrder save(StoreOrder storeOrder) {
        return storeOrderRepository.save(storeOrder);
    }
}
