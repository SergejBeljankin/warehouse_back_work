package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * This DTO class for {@link com.warehouse_accounting.models.TechnologicalMapProduct}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 24.03.2021
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologicalMapProductDto {

    private Long id;

    private Long finishedProductId;
    private String finishedProductsName;

    private BigDecimal count = BigDecimal.valueOf(1);

    private TechnologicalMapDto technologicalMapDto = new TechnologicalMapDto();

    public TechnologicalMapProductDto(Long id,
                                      Long finishedProductId,
                                      String finishedProductsName,
                                      BigDecimal count,
                                      Long technologicalMapDto) {
        this.id = id;
        this.finishedProductId = finishedProductId;
        this.finishedProductsName = finishedProductsName;
        this.count = count;
        this.technologicalMapDto.setId(technologicalMapDto);
    }
}
