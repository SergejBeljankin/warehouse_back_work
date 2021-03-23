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
import java.time.LocalDateTime;

/**
 * This class is model is on the "Мой Склад" in the tab "Производсство".
 * This model is responsible for the "Тех. операции"
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "technological_operation")
public class TechnologicalOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column
    private LocalDateTime date;

//    TODO: when the TechnologicalMap be create, it is necessary to implement the connection
//    this class in not create
//    @Column
//    private TechnologicalMap technologicalMap;

    @Column
    private BigDecimal volumeOfProduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column
    private Warehouse warehouseForMaterials;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column
    private Warehouse warehouseForProduct;
}
