package com.warehouse_accounting.models.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PositionDto {
    Long id;
    String name;
    String sortNumber;
}