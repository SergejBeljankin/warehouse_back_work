package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequisitesDto {

    private Long id;

    private String organization;

    private String legalAddress;

    private Integer INN;

    private Integer KPP;

    private Integer BIK;

    private Integer checkingAccount;
}
