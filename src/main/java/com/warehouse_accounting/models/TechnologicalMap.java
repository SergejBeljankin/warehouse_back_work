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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

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
    @Column(name = "technological_map_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "technological_map_name")
    private String name;

    @Column(name = "technological_map_comment")
    private String comment;

    /**
     * The amount of additional costs per production operation.
     */
    @Column(name = "technological_map_production_cost")
    private BigDecimal productionCost;

    /**
     * @see TechnologicalMapGroup
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technological_map_group",
            referencedColumnName = "technological_map_group_id")
    private TechnologicalMapGroup technologicalMapGroup;

    /**
     * Products that will be produced as a result of the operation.
     *
     * @see Product
     */
    @Column(name = "technological_map_finished_products")
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Product> finishedProducts;

    /**
     * Products that will be debited as a result of the operation.
     *
     * @see Product
     */
    @Column(name = "technological_map_materials")
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Product> materials;
}

