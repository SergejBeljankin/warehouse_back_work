package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceDto {

    private Long id;

    private ProductDto productDto = new ProductDto();

    private TypeOfPriceDto typeOfPriceDto = new TypeOfPriceDto();

    private BigDecimal price;

    public ProductPriceDto(Long id, Long productDtoId, Long typeOfPriceId, BigDecimal price){
        this.id = id;
        this.productDto.setId(productDtoId);
        this.typeOfPriceDto.setId(typeOfPriceId);
        this.price=price;
    }


}
