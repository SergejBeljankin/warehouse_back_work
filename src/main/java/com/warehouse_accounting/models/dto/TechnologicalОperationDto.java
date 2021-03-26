package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Dto модель для подвкладки "Тех. операции" во вкладки "Производство".
 * Необходимо доработать при добавлении модели TechnologicalMap
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologicalОperationDto {

    private Long id;
    private String number;
    private LocalDateTime technologicalОperationDateTime;
    private BigDecimal volumeOfProduction;

//    private Long TechnologicalMapId;
//    private String TechnologicalMapName;

    private Long warehouseForMaterialsId;
    private String warehouseForMaterialsName;

    private Long warehouseForProductId;
    private String warehouseForProductName;
}
