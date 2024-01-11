package com.vsushko.orderservice.domain.model;

import com.vsushko.orderservice.domain.dto.OrderLine;
import com.vsushko.orderservice.domain.dto.Product;
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
public class StoreOrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private long productId;

    @NotNull
    @Column
    private String sku;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String currencyCode;

    @NotNull
    @Column
    private BigDecimal unitPrice;

    @NotNull
    @Column
    private int orderedQuantity;

    @NotNull
    @Column
    private BigDecimal totalValue;

    @SuppressWarnings("unused")
    public StoreOrderLine() {
    }

    public StoreOrderLine(OrderLine orderLine, Product product) {
        productId = product.getId();
        sku = product.getSku();
        name = product.getName();
        currencyCode = product.getCurrencyCode();
        unitPrice = product.getPrice();
        orderedQuantity = orderLine.getQuantity();
        totalValue = product.getPrice().multiply(BigDecimal.valueOf(orderLine.getQuantity()));
    }
}
