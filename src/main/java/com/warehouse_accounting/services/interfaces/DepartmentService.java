package com.warehouse_accounting.services.interfaces;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getAll();

    DepartmentDto getById(Long id);

    void create(DepartmentDto departmentDto);

    void update(DepartmentDto departmentDto);

    void deleteById(Long id);
}
