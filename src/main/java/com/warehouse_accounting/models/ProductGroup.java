package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGroup {
    private Long id;

    private String name;

    private String sortNumber;

    private ProductGroup productGroup;
}