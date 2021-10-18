package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.File;
import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class CustomerOrderDto {

    Long id;

    LocalDateTime date;

    Long warehouseId;

    Long contractId;

    Long contractorId;

    Long companyId;

    List<Product> productDto = new ArrayList<>();

    List<Task> taskDto = new ArrayList<>();

    List<File> fileDto = new ArrayList<>();

    BigDecimal sum;

    String comment;

    Boolean isPaid;

    public CustomerOrderDto(Long id, LocalDateTime date, Long warehouseId, Long contractId, Long contractorId,
                            Long companyId, BigDecimal sum, String comment, Boolean isPaid) {
        this.id = id;
        this.date = date;
        this.warehouseId = warehouseId;
        this.contractId = contractId;
        this.contractorId = contractorId;
        this.companyId = companyId;
        this.sum = sum;
        this.comment = comment;
        this.isPaid = isPaid;
    }
}
