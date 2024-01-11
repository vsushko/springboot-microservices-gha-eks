package com.vsushko.core.storecore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * BaseResponse.
 *
 * @author vsushko
 */
@Schema(description = "BaseResponse Model with response message")
@Data
@SuperBuilder
@AllArgsConstructor
public class BaseResponse {

    private String message;
}