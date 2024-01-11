package com.vsushko.core.storecore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * PurchaseDto.
 *
 * @author vsushko
 */
@Schema(description = "PurchaseDto Model Information")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {

    @Schema(description = "Purchase id")
    private Long id;

    @Schema(description = "Purchase student id")
    @NotNull(message = "Purchase.studentId must be present")
    private Long studentId;

    @Schema(description = "Purchase transaction id")
    @NotNull(message = "Purchase.transactionId must be present")
    private Long transactionId;

    @Schema(description = "Purchase receipt id")
    @NotNull(message = "Purchase.receiptId must be present")
    private Long receiptId;
}
