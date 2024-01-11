package com.vsushko.orderservice.web;

import com.vsushko.orderservice.domain.dto.Order;
import com.vsushko.orderservice.domain.model.StoreOrder;
import com.vsushko.orderservice.domain.service.ProcessOrderUseCase;
import com.vsushko.orderservice.domain.service.StoreOrderService;
import com.vsushko.orderservice.domain.service.impl.StoreOrderServiceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order/api/v1/orders")
public class StoreOrdersController {
    private final StoreOrderServiceServiceImpl ordersUseCaseServiceImpl;

    private final StoreOrderService storeOrderService;

    private final ProcessOrderUseCase processOrderUseCase;

    @GetMapping("/{orderId}")
    public StoreOrder getOrder(@PathVariable("orderId") long orderId) {
        return storeOrderService.findById(orderId);
    }

    @GetMapping
    public Iterable<StoreOrder> getAllOrders() {
        return storeOrderService.findAll();
    }

    @PostMapping
    public StoreOrder processOrder(@RequestBody Order order) {
        return processOrderUseCase.execute(order);
    }
}
/*
curl -X POST -H "Content-Type: application/json" -d '{"customerId": 1, "orderLines": [{"productId": 1, "quantity": 10}, {"productId": 2, "quantity": 12}]}' http://localhost:8082/order/api/v1/orders
 */
