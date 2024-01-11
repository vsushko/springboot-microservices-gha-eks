package com.vsushko.core.storecore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * PurchaseItemDto.
 *
 * @author vsushko
 */
@Schema(description = "PurchaseItemDto Model Information")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItemDto {

    @Schema(description = "Purchase Item name")
    @NotBlank(message = "PurchaseItem.name must be present")
    private String name;

    @Schema(description = "Purchase Item currency type")
    @NotNull(message = "PurchaseItem.currencyType must be present")
    private String currencyType;

    @Schema(description = "Purchase Item price")
    @NotNull(message = "PurchaseItem.price must be present")
    @Positive(message = "PurchaseItem.price must be a positive value")
    private BigDecimal price;

    @Schema(description = "Purchase quantity")
    @NotNull(message = "PurchaseItem.quantity must be present")
    @Positive(message = "PurchaseItem.quantity must be a positive value")
    private Integer quantity;

    @Schema(description = "Purchase Item amount")
    @NotNull(message = "PurchaseItem.amount must be present")
    @Positive(message = "PurchaseItem.amount must be a positive value")
    private BigDecimal amount;
}
