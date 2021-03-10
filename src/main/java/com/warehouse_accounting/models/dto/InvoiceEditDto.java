package com.warehouse_accounting.models.dto;


import com.warehouse_accounting.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEditDto {
    private Long id;
    private EmployeeDto editAuthorDto;
    private LocalDateTime dateTime;
    private String field;
    private String before;
    private String after;

    InvoiceEditDto(Long id,
                   Long editAuthorId,
                   LocalDateTime dateTime,
                   String field,
                   String before,
                   String after) {
        this.id = id;
        this.editAuthorDto.setId(editAuthorId);
        this.dateTime = dateTime;
        this.field = field;
        this.before = before;
        this.after = after;
    }
}
