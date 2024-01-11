package com.vsushko.core.storecore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PurchaseItemList.
 *
 * @author vsushko
 */
@Schema(description = "PurchaseItemList Model Information")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseItemList {

    @Schema(description = "List of PurchaseItemDto Model Information")
    private List<PurchaseItemDto> items;
}
