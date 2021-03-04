package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(scale = 3)
    private BigDecimal weight;

    @Column(scale = 6)
    private BigDecimal volume;

    @Column(scale = 2)
    private BigDecimal purchasePrice;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Unit unit;

    @Column
    private Boolean archive = false;

    @ManyToOne(fetch = FetchType.LAZY)
    private Contractor contractor;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductPrice> productPrices;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaxSystem taxSystem;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductGroup productGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    private AttributeOfCalculationObject attributeOfCalculationObject;
}
