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
import javax.persistence.JoinColumns;
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
    @Column(name = "technological_map_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "technological_map_group_name")
    private String name;

    @Column(name = "technological_map_group_code")
    private String code;

    @Column(name = "technological_map_group_comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technological_map_parent_group_id",
            referencedColumnName = "technological_map_group_id")
    private TechnologicalMapGroup parentTechnologicalMapGroup;

}

