package com.vsushko.orderservice.domain.dto;

import lombok.Data;

@Data
public class OrderLine {
    private long productId;

    private int quantity;

    public OrderLine() {
    }
}