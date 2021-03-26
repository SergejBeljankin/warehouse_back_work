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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

/**
 * This class is model is on the "Мой Склад" in the tab "Производство"
 * A Technological map is a document describing the manufacturing process of a product,
 * including the necessary components, raw materials and materials.
 * Technological maps are usually developed for typical, repetitive production processes.
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 23.03.2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "technological_maps")
public class TechnologicalMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String comment;

    /**
     * Indicates whether the object is in the archive or not.
     * Items moved to the archive are not displayed in directories and reports.
     * The archive allows you to hide outdated items without deleting them.
     */
    @Column
    private boolean isArchived = false;

    /**
     * The amount of additional costs per production operation.
     */
    @Column
    private BigDecimal productionCost = BigDecimal.valueOf(0);;

    /**
     * @see TechnologicalMapGroup
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private TechnologicalMapGroup technologicalMapGroup;

    /**
     * Products that will be produced as a result of the operation.
     */
    @OneToMany(fetch = FetchType.LAZY)
    private List<TechnologicalMapProduct> finishedProducts;

    /**
     * Products that will be debited as a result of the operation.
     */
    @OneToMany(fetch = FetchType.LAZY)
    private List<TechnologicalMapMaterial> materials;
}

