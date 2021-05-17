package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoDto {

    private Long id;
    private LocalDateTime createDate;
    private String content;

    private String contractorName;
    private Long contractorId;

    private String employeeWhoCreatedName;
    private Long employeeWhoCreatedId;

    private String employeeWhoEditedName;
    private Long employeeWhoEditedId;


}
