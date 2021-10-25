package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.Company;
import com.warehouse_accounting.models.Contract;
import com.warehouse_accounting.models.Contractor;
import com.warehouse_accounting.models.File;
import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.Task;
import com.warehouse_accounting.models.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CustomerReturnsDto {

    Long id;

    LocalDateTime date;

    WarehouseDto warehouseDto = new WarehouseDto();

    ContractDto contractDto = new ContractDto();

    ContractorDto contractorDto = new ContractorDto();

    CompanyDto companyDto = new CompanyDto();

    List<ProductDto> productDtos = new ArrayList<>();

    List<TaskDto> taskDtos = new ArrayList<>();

    List<FileDto> fileDtos = new ArrayList<>();

    BigDecimal sum;

    Boolean isPaid;

    Boolean isSend;

    String comment;

    public CustomerReturnsDto(Long id,
                              LocalDateTime date,
                              BigDecimal sum,
                              Boolean isPaid,
                              Boolean isSend,
                              String comment,
                              Long warehouseId,
                              Long contractId,
                              Long companyId,
                              Long contractorId) {
        this.id = id;
        this.date = date;
        this.sum = sum;
        this.isPaid = isPaid;
        this.isSend = isSend;
        this.comment = comment;
        this.warehouseDto.setId(warehouseId);
        this.contractDto.setId(contractId);
        this.companyDto.setId(companyId);
        this.contractorDto.setId(contractorId);
    }
}
