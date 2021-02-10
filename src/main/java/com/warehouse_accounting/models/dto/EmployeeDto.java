package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    private String lastName;

    private String firstName;

    private String middleName;

    private String sortNumber;

    private String phone;

    private String inn;

    private String description;

    private String email;

    private String password;

    private DepartmentDto department;

    private PositionDto position;

    private Set<RoleDto> roles;

    private ImageDto image;

    public EmployeeDto(Long id, String lastName, String firstName, String middleName, String sortNumber, String phone, String inn, String description, String email, String password, DepartmentDto department, PositionDto position, ImageDto image) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sortNumber = sortNumber;
        this.phone = phone;
        this.inn = inn;
        this.description = description;
        this.email = email;
        this.password = password;
        this.department = department;
        this.position = position;
        this.image = image;
    }
}
