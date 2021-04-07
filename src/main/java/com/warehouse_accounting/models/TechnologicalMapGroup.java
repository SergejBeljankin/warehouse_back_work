package com.warehouse_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This model implements groups for the model {@link TechnologicalMap}
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
@Table(name = "technological_map_groups")
public class TechnologicalMapGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.DETACH})
    private TechnologicalMapGroup parentTechnologicalMapGroup;

    /**
     * Indicates whether the object is in the archive or not.
     * Items moved to the archive are not displayed in directories and reports.
     * The archive allows you to hide outdated items without deleting them.
     */
    @Column
    private boolean isArchived = false;

}

