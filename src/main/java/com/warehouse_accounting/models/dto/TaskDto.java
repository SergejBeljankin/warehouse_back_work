package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.Contractor;
import com.warehouse_accounting.models.Document;
import com.warehouse_accounting.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * This DTO class for {@link com.warehouse_accounting.models.Task}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 10.04.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String description;
    private LocalDateTime deadline;
    private LocalDateTime dateOfCreation;
    private Boolean isDone = false;

    private Long executorId;
    private String executorName;

    private Long contractorId;
    private String contractorName;

    private Long documentId;
    private String documentName;
}
