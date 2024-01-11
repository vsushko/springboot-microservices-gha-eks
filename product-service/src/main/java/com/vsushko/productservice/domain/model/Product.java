package com.vsushko.productservice.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String sku;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private BigDecimal price;

    @NotNull
    @Column
    private String currencyCode;

    @NotNull
    @Column
    private int stock;

    @SuppressWarnings("unused")
    public Product() {
    }
}
