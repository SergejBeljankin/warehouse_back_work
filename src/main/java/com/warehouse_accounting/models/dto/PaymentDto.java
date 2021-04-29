package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.TypeOfPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    private Long id;

    private LocalDateTime date;

    private BigDecimal amount;

    private String purpose;

    private BigDecimal tax;

    private String comment;

    private boolean isDone;

    private TypeOfPayment typeOfPayment;

    private EmployeeDto employeeDto;

    private CompanyDto companyDto;

    private ContractorDto contractorDto;

    private Long contractId;

    private String contractNumber;

    private Long projectId;

    private String projectName;

    private Long paymentExpenditureId;

    private String paymentExpenditureName;

    private List<Long> documentId;

    private List<String> documentName;

    private List<TaskDto> taskDtos = new ArrayList<>();
}
