package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LegalDetailDto {
    private Long id;

    private String fullName;

    private String address;

    private String commentToAddress;

    private String inn;

    private String kpp;

    private String okpo;

    private String ogrn;

    private Long typeOfContractorId;

    private String typeOfContractorName;

}
