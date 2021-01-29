package com.warehouse_accounting.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Warehouse {
    private Long id;
    private String name;
    private String sortNumber;
    private String address;
    private String commentToAddress;
    private String comment;
}
