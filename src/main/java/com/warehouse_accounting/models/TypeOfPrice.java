package com.warehouse_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TypeOfPrice {
    private Long id;
    private String name;
    private String sortNumber;
}
