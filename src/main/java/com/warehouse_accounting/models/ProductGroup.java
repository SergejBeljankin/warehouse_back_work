package com.warehouse_accounting.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String name;
    private String sortNumber;
    @ManyToOne
    private ProductGroup productGroup;

    public ProductGroup(String name, String sortNumber, ProductGroup productGroup) {
        this.name = name;
        this.sortNumber = sortNumber;
        this.productGroup = productGroup;
    }
}
