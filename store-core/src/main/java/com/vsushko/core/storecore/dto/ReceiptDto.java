package com.vsushko.core.storecore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * ReceiptDto.
 *
 * @author vsushko
 */
@Schema(description = "ReceiptDto Model Information")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDto {

    @Schema(description = "Receipt id")
    private Long id;

    @Builder.Default
    @Schema(description = "Purchase Items")
    private Set<PurchaseItemDto> purchaseItems = new HashSet<>();

    @Schema(description = "Receipt student id")
    @NotNull(message = "Receipt.studentId must be present")
    private Long studentId;

    @Schema(description = "Receipt transaction id")
    @NotNull(message = "Receipt.transactionId must be present")
    private Long transactionId;

    @Schema(description = "Receipt date")
    private LocalDateTime date;

    @Schema(description = "Receipt total paid")
    @NotNull(message = "Receipt.totalPaid must be present")
    private BigDecimal totalPaid;
}
