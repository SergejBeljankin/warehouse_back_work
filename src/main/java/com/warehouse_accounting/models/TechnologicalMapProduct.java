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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Products that will be produced as a result of the operation.
 * @see TechnologicalMap
 * @see Product
 * @author pavelsmirnov
 * @version 0.1
 * Created 24.03.2021
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "technological_maps_products")
public class TechnologicalMapProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product products;

    @Column(scale = 2)
    private BigDecimal count= BigDecimal.valueOf(1);

    @ManyToOne(fetch = FetchType.LAZY)
    private TechnologicalMap technologicalMap;
}
