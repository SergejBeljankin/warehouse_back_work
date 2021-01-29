package com.warehouse_accounting.models;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaxSystem {
    private Long id;
    private String name;
    private String sortNumber;
}