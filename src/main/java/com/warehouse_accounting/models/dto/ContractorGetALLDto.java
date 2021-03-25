package com.warehouse_accounting.models.dto;

/*
 * сущность для получения на форме всех контрагентов
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractorGetALLDto {

    private Long id;

    private String name;

    private String  sortNumber;

    private String phone;

    private String fax;

    private String email;

    private String address;

    private String comment;

    private String numberDiscountCard;

    private Long legalDetailId;

    private String legalDetailFullName;

    private String legalDetailAddress;

    private String legalDetailInn;

    private String legalDetailKpp;

    private Long legalDetailTypeOfContractorId;

    private String legalDetailTypeOfContractorName;

    private Long contractorGroupId;

    private String contractorGroupName;

    private Long typeOfPriceId;

    private String typeOfPriceName;
}
