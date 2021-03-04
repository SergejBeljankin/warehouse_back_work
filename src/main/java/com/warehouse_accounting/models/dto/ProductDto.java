package com.warehouse_accounting.models.dto;
import com.warehouse_accounting.models.ProductPrice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    private String name;

    private BigDecimal weight;

    private BigDecimal volume;

    private BigDecimal purchasePrice;

    private String description;

    private UnitDto unitDto = new UnitDto();

    private Boolean archive = false;

    private ContractorDto contractorDto = new ContractorDto();

    private List<ProductPrice> productPricesDto = new ArrayList<>();

    private TaxSystemDto taxSystemDto = new TaxSystemDto();

    private List<ImageDto> imagesDto = new ArrayList<>();

    private ProductGroupDto productGroupDto = new ProductGroupDto();

    private AttributeOfCalculationObjectDto attributeOfCalculationObjectDto = new AttributeOfCalculationObjectDto();

    public ProductDto(Long id,
                      String name,
                      BigDecimal weight,
                      BigDecimal volume,
                      BigDecimal purchasePrice,
                      String description,
                      Long unitDtoId,
                      Boolean archive,
                      Long contractorDtoId,
                      Long taxSystemDtoId,
                      Long productGroupDtoId,
                      Long attributeOfCalculationObjectDtoId) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.purchasePrice = purchasePrice;
        this.description = description;
        this.unitDto.setId(unitDtoId);
        this.archive = archive;
        this.contractorDto.setId(contractorDtoId);
        this.taxSystemDto.setId(taxSystemDtoId);
        this.productGroupDto.setId(productGroupDtoId);
        this.attributeOfCalculationObjectDto.setId(attributeOfCalculationObjectDtoId);
    }
}
