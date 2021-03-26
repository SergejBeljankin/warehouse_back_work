package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * This DTO class for {@link com.warehouse_accounting.models.TechnologicalMapMaterial}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 24.03.2021
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologicalMapMaterialDto {
    private Long id;

    private Long materialId;
    private String materialName;

    private BigDecimal count= BigDecimal.valueOf(1);
}
