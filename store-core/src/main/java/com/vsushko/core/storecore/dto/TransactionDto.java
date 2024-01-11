package com.vsushko.core.storecore.dto;

import com.vsushko.core.storecore.enums.CardType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * TransactionDto.
 *
 * @author vsushko
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    @Schema(description = "Transaction id")
    private Long id;

    @Schema(description = "Transaction date")
    private LocalDateTime date;

    @Schema(description = "Student id")
    @NotNull(message = "Transaction.studentId must be present")
    private Long studentId;

    @Schema(description = "Card number")
    @NotNull(message = "Transaction.cardNumber must be present")
    private String cardNumber;

    @Schema(description = "Card type")
    @NotNull(message = "Transaction.cardType must be present")
    private CardType cardType;

    @Schema(description = "Total Paid")
    @NotNull(message = "Transaction.totalPaid must be present")
    private BigDecimal totalPaid;
}
