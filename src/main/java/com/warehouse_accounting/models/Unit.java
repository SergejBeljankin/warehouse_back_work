package com.warehouse_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Unit {
    private Long id;
    private String shortName;
    private String fullName;
    private String sortNumber;
}
