package com.warehouse_accounting.models.dto;


import com.warehouse_accounting.models.Document;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder(toBuilder = true)
@Jacksonized
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RecycleBinDto {
    UUID id;
    String name;
    Date createdDate;
    List<Document> document;
}
