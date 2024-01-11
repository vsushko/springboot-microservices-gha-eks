package com.vsushko.orderservice.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private long customerId;

    private List<OrderLine> orderLines;

    public Order() {
    }
}
