package com.vsushko.orderservice.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private long id;

    private String sku;

    private String name;

    private BigDecimal price;

    private String currencyCode;

    private int stock;

    @SuppressWarnings("unused")
    public Product() {
    }
}
