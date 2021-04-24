package com.warehouse_accounting.models.dto;


import com.warehouse_accounting.models.Document;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecycleBinDto {
    private Long id;
    private Integer quantity;
    private Date createdDate;
    private Document document;
}
