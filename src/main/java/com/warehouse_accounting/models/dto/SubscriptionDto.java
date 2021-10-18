package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDto {

    private Long id;

    private Date subscriptionExpirationDate;

    private Set<TariffDto> tariff;

    private RequisitesDto requisites = new RequisitesDto();

    private EmployeeDto employee = new EmployeeDto();

//    private OperationHistory operationHistory;TODO <make a dto with history an operation>


    public SubscriptionDto(Long id,
                           Date subscriptionExpirationDate,
                           Long requisitesId,
                           Long employeeId) {
        this.id = id;
        this.subscriptionExpirationDate = subscriptionExpirationDate;
        this.requisites.setId(requisitesId);
        this.employee.setId(employeeId);
    }
}
