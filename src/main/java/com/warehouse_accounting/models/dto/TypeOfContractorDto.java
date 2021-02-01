package com.warehouse_accounting.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeOfContractorDto {

    private Long id;
    private String name;
    private String sortNumber;

}
