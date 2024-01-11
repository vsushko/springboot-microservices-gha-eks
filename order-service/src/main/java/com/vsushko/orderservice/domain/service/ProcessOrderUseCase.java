package com.vsushko.orderservice.domain.service;

import com.vsushko.orderservice.domain.dto.Order;
import com.vsushko.orderservice.domain.dto.OrderLine;
import com.vsushko.orderservice.domain.model.StoreOrder;
import com.vsushko.orderservice.domain.model.StoreOrderCustomerData;
import com.vsushko.orderservice.domain.model.StoreOrderLine;
import com.vsushko.orderservice.domain.port.CustomersRemoteService;
import com.vsushko.orderservice.domain.port.ProductsRemoteService;
import com.vsushko.orderservice.domain.repository.StoreOrderCustomerDataDataRepository;
import com.vsushko.orderservice.domain.repository.StoreOrderLineRepository;
import com.vsushko.orderservice.domain.repository.StoreOrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.IterableUtils.toList;

@Slf4j
@RequiredArgsConstructor
@Component
public class ProcessOrderUseCase {

    private final CustomersRemoteService customersRemoteService;

    private final ProductsRemoteService productsRemoteService;

    private final StoreOrderService storeOrderService;

    private final StoreOrderCustomerDataDataRepository storeOrderCustomerDataDataRepository;

    private final StoreOrderLineRepository storeOrderLineRepository;

    private final ExecutorService executorService;

    @Transactional
    public StoreOrder execute(Order order) {
        StoreOrderCustomerData orderCustomerData = getStoreOrderCustomerData(order);
        List<StoreOrderLine> orderLines = getOrderLines(order);

        orderCustomerData = storeOrderCustomerDataDataRepository.save(orderCustomerData);
        orderLines = toList(storeOrderLineRepository.saveAll(orderLines));

        StoreOrder storeOrder = new StoreOrder(orderCustomerData, orderLines);

        return storeOrderService.save(storeOrder);
    }

    private StoreOrderCustomerData getStoreOrderCustomerData(Order order) {
        var customer = executorService.submit(() -> customersRemoteService.getCustomer(order.getCustomerId()));

        return new StoreOrderCustomerData(getOrElse(customer, null));
    }

    private List<StoreOrderLine> getOrderLines(Order order) {
        return order.getOrderLines().stream()
                .map(this::getOrderLine)
                .collect(Collectors.toList());
    }

    private StoreOrderLine getOrderLine(OrderLine orderLine) {
        var product = executorService.submit(() -> productsRemoteService.getProduct(orderLine.getProductId()));

        return new StoreOrderLine(orderLine, getOrElse(product, null));
    }

    private <T> T getOrElse(Future<T> future, T defaultValue) {
        try {
            return future.get();
        } catch (Exception e) {
            log.error("Error", e);
        }
        return defaultValue;
    }
}
