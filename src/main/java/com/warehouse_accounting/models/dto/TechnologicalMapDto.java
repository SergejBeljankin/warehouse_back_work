package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.TechnologicalMapGroup;
import com.warehouse_accounting.models.TechnologicalMapMaterial;
import com.warehouse_accounting.models.TechnologicalMapProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private boolean isArhived = false;
    private BigDecimal productionCost = BigDecimal.valueOf(0);

    private Long technologicalMapGroupId;
    private String technologicalMapGroupName;

    private List<TechnologicalMapProduct> finishedProducts = new ArrayList<>();

    private List<TechnologicalMapMaterial> materials = new ArrayList<>();

    public TechnologicalMapDto(Long id,
                               String name,
                               String comment,
                               boolean isArhived,
                               BigDecimal productionCost,
                               Long technologicalMapGroupId,
                               String technologicalMapGroupName) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.isArhived = isArhived;
        this.productionCost = productionCost;
        this.technologicalMapGroupId = technologicalMapGroupId;
        this.technologicalMapGroupName = technologicalMapGroupName;
    }
}
