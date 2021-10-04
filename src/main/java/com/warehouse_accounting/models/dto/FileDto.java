package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.With;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import static lombok.AccessLevel.PRIVATE;

@With
@Getter
@Builder(toBuilder = true)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class FileDto {
    long id;
    String name;
    int size;
    String location;
    Date createdDate;
    List<Employee> employee;

}
