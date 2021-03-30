package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This DTO class for {@link com.warehouse_accounting.models.TechnologicalMap}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 24.03.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnologicalMapDto {

    private Long id;
    private String name;
    private String comment;
    private boolean isArchived = false;
    private BigDecimal productionCost = BigDecimal.valueOf(0);

    private Long technologicalMapGroupId;
    private String technologicalMapGroupName;

    private List<TechnologicalMapProductDto> finishedProducts = new ArrayList<>();

    private List<TechnologicalMapMaterialDto> materials = new ArrayList<>();

    public TechnologicalMapDto(Long id,
                               String name,
                               String comment,
                               boolean isArchived,
                               BigDecimal productionCost,
                               Long technologicalMapGroupId,
                               String technologicalMapGroupName) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.isArchived = isArchived;
        this.productionCost = productionCost;
        this.technologicalMapGroupId = technologicalMapGroupId;
        this.technologicalMapGroupName = technologicalMapGroupName;
    }
}
