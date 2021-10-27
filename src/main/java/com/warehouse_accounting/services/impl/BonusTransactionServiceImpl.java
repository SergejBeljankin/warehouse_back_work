package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.BonusTransactionDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.repositories.BonusTransactionRepository;
import com.warehouse_accounting.repositories.DepartmentRepository;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.ImageRepository;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.services.interfaces.BonusTransactionService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static com.warehouse_accounting.util.ConverterDto.convertToDto;

@Service
@Transactional
public class BonusTransactionServiceImpl implements BonusTransactionService {
    private final BonusTransactionRepository bonusTransactionRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;
    private final ImageRepository imageRepository;
    private final PositionRepository positionRepository;

    public BonusTransactionServiceImpl(BonusTransactionRepository bonusTransactionRepository,
                                       EmployeeRepository employeeRepository,
                                       DepartmentRepository departmentRepository,
                                       RoleRepository roleRepository,
                                       ImageRepository imageRepository, PositionRepository positionRepository) {
        this.bonusTransactionRepository = bonusTransactionRepository;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.imageRepository = imageRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<BonusTransactionDto> getAll() {
        List<BonusTransactionDto> bonusTransactionDtos = bonusTransactionRepository.getAll();

        bonusTransactionDtos.forEach(bonusTransactionDto -> {
            EmployeeDto employeeDto = employeeRepository.getById(bonusTransactionDto.getOwner().getId());

            bonusTransactionDto.setOwner(employeeRepository.getById(bonusTransactionDto.getOwner().getId()));
            bonusTransactionDto.getOwner().setDepartment(departmentRepository.getById(employeeDto.getDepartment().getId()));
            bonusTransactionDto.getOwner().setPosition(positionRepository.getById(employeeDto.getDepartment().getId()));
            bonusTransactionDto.getOwner().setRoles(convertToDto(roleRepository.getRolesByEmployeeId(employeeDto.getId())));
            bonusTransactionDto.getOwner().setImage(imageRepository.getById(employeeDto.getImage().getId()));

        });
        return bonusTransactionDtos;
    }

    @Override
    public BonusTransactionDto getById(Long id) {

        BonusTransactionDto bonusTransactionDto =  bonusTransactionRepository.getById(id);
        EmployeeDto employeeDto = employeeRepository.getById(bonusTransactionDto.getOwner().getId());

        bonusTransactionDto.setOwner(employeeRepository.getById(bonusTransactionDto.getOwner().getId()));
        bonusTransactionDto.getOwner().setDepartment(departmentRepository.getById(employeeDto.getDepartment().getId()));
        bonusTransactionDto.getOwner().setPosition(positionRepository.getById(employeeDto.getDepartment().getId()));
        bonusTransactionDto.getOwner().setRoles(convertToDto(roleRepository.getRolesByEmployeeId(employeeDto.getId())));
        bonusTransactionDto.getOwner().setImage(imageRepository.getById(employeeDto.getImage().getId()));

        return bonusTransactionDto;
    }

    @Override
    public void create(BonusTransactionDto bonusTransactionDto) {
        bonusTransactionRepository.save(ConverterDto.convertToModel(bonusTransactionDto));
    }

    @Override
    public void update(BonusTransactionDto bonusTransactionDto) {
        bonusTransactionRepository.save(ConverterDto.convertToModel(bonusTransactionDto));
    }

    @Override
    public void deleteById(Long id) {
        bonusTransactionRepository.deleteById(id);
    }
}

