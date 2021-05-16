package com.warehouse_accounting.models.dto;


import com.warehouse_accounting.models.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecycleBinDto {
    Long id;
    String name;
    Date createdDate;
    List<Document> document;
}
