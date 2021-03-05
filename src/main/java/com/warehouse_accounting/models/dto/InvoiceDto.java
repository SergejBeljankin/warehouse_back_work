package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.TypeOfInvoice;
import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.models.dto.InvoiceEditDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Long id;
    private String number;
    private LocalDateTime invoiceDateTime;
    private String type;
    private boolean isPosted;
    private EmployeeDto invoiceAuthor = new EmployeeDto();
    private CompanyDto companyDto = new CompanyDto();
    private ProjectDto projectDto = new ProjectDto();
    private WarehouseDto warehouseDto = new WarehouseDto();
//    private Set<InvoiceProductDto> productDtos = new HashSet();
    private String comment;
    private ContractorDto contractorDto = new ContractorDto();
    private ContractDto contractDto = new ContractDto();
    private Set<InvoiceEditDto> edits = new HashSet<>();

    public InvoiceDto(Long id,
                      String number,
                      LocalDateTime invoiceDateTime,
                      TypeOfInvoice type,
                      boolean isPosted,
                      Long invoiceAuthorId,
                      Long companyDtoId,
                      Long projectDtoId,
                      Long warehouseDtoId,
                      String comment,
                      Long contractorDtoId,
                      Long contractDtoId) {
        this.id = id;
        this.number = number;
        this.invoiceDateTime = invoiceDateTime;
        this.type = type.name();
        this.isPosted = isPosted;
        this.invoiceAuthor.setId(invoiceAuthorId);
        this.companyDto.setId(companyDtoId);
        this.projectDto.setId(projectDtoId);
        this.warehouseDto.setId(warehouseDtoId);
        this.comment = comment;
        this.contractorDto.setId(contractorDtoId);
        this.contractDto.setId(contractDtoId);
    }
}
