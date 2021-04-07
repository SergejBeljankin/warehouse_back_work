package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
import java.time.LocalDateTime;

/**
 * This class is model is on the "Мой Склад" in the tab "Производсство".
 * This model is responsible for the "Тех. операции"
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "technological_operations")
public class TechnologicalOperation extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column
    private boolean isArchive;

    @Column
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private TechnologicalMap technologicalMapObj;

    @Column
    private BigDecimal volumeOfProduction;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouseForMaterials;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse warehouseForProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @Column
    private String comments;
}
