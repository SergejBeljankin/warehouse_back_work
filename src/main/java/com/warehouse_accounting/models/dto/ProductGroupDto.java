package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductGroupDto {
    private Long id = -1L;
    private String name;
    private String sortNumber;
//    private ProductGroup productGroup; (ManyToOne)
    private String productGroup;

//    public static ProductGroupDto toDto(ProductGroup productGroup) {
//        return new ProductGroupDto(
//                productGroup.getId(),
//                productGroup.getName(),
//                productGroup.getSortNumber(),
//                productGroup.getProductGroup().getName()
//        );
//    }

//    public static ProductGroup fromDto(ProductGroupDto productGroupDto, ProductGroup productGroup) {
//        return new ProductGroup(
//                productGroupDto.getId(),
//                productGroupDto.getName(),
//                productGroupDto.getSortNumber(),
//                productGroup
//        );
//    }
}
