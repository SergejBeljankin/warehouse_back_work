package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractorDto {
    private Long id;

    private String name;

    private String inn;

    private String sortNumber;

    private String phone;

    private String fax;

    private String email;

    private String address;

    private String commentToAddress;

    private String comment;

    private ContractorGroupDto contractorGroupDto = new ContractorGroupDto();

    private TypeOfContractorDto typeOfContractorDto = new TypeOfContractorDto();

    private TypeOfPriceDto typeOfPriceDto = new TypeOfPriceDto();

    private List<BankAccountDto> bankAccountDtos = new ArrayList<>();

    private LegalDetailDto legalDetailDto = new LegalDetailDto();

    public ContractorDto(
            Long id,
            String name,
            String inn,
            String sortNumber,
            String phone,
            String fax,
            String email,
            String address,
            String commentToAddress,
            String comment,
            Long contractorGroupDtoId,
            Long typeOfContractorDtoId,
            Long typeOfPriceDtoId,
            Long legalDetailDtoId
    ) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.sortNumber = sortNumber;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.address = address;
        this.commentToAddress = commentToAddress;
        this.comment = comment;
        this.contractorGroupDto.setId(contractorGroupDtoId);
        this.typeOfContractorDto.setId(typeOfContractorDtoId);
        this.typeOfPriceDto.setId(typeOfPriceDtoId);
        this.legalDetailDto.setId(legalDetailDtoId);
    }
}
