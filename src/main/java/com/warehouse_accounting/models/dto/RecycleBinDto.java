package com.warehouse_accounting.models.dto;


import com.warehouse_accounting.models.Document;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder(toBuilder = true)
@Jacksonized
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RecycleBinDto {
    Long id;
    Integer quantity;
    Date createdDate;
    Document document;

}
