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

//    private Long idTechnologicalMap;
//    private String nameTechnologicalMap;

    private Long idWarehouseForMaterials;
    private String nameWarehouseForMaterials;

    private Long idWarehouseForProduct;
    private String nameWarehouseForProduct;


    public TechnologicalОperationDto(Long id,
                                     String number,
                                     LocalDateTime technologicalОperationDateTime,
                                     BigDecimal volumeOfProduction,
//                                     TechnologicalMap technologicalMap,
                                     Warehouse warehouseForMaterials,
                                     Warehouse warehouseForProduct){
        this.id = id;
        this.number = number;
        this.technologicalОperationDateTime = technologicalОperationDateTime;
        this.volumeOfProduction = volumeOfProduction;
//        this.idTechnologicalMap = technologicalMap.getId();
//        this.nameTechnologicalMap = technologicalMap.getName();
        this.idWarehouseForMaterials = warehouseForMaterials.getId();
        this.nameWarehouseForMaterials = warehouseForMaterials.getName();
        this.idWarehouseForProduct = warehouseForProduct.getId();
        this.nameWarehouseForProduct =warehouseForProduct.getName();
    }
}
