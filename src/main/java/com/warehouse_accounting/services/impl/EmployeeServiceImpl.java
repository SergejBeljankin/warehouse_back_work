package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.repositories.DepartmentRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.ImageRepository;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.interfaces.EmployeeService;
import com.warehouse_accounting.util.ConverterDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final RoleRepository roleRepository;
    private final ImageRepository imageRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, PositionRepository positionRepository, RoleRepository roleRepository, ImageRepository imageRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
        this.roleRepository = roleRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public EmployeeDto getById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        employeeRepository.save(ConverterDto.convertToModel(employeeDto));
    }

    @Override
    public void update(EmployeeDto employeeDto) {
        employeeRepository.save(ConverterDto.convertToModel(employeeDto));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> employeeDtos = employeeRepository.getAll();
        employeeDtos.forEach(employeeDto -> {
            employeeDto.setDepartment(departmentRepository.getById(employeeDto.getDepartment().getId()));
            employeeDto.setPosition((positionRepository.getById(employeeDto.getPosition().getId())));
//            employeeDto.setRoles(roleRepository.getById(employeeDto.getRoles()));
            employeeDto.setRoles(getSetRoles(employeeDto));
            employeeDto.setImage(imageRepository.getById(employeeDto.getImage().getId()));
        });
        return employeeRepository.getAll();
    }

    public Set<RoleDto> getSetRoles(EmployeeDto employeeDto){
        String GET_ROLES = String.format("SELECT name FROM  roles inner join employees_roles er on roles.id = '%s'", employeeDto.getId());
        return (Set<RoleDto>) entityManager.createQuery(GET_ROLES);
    }

}
