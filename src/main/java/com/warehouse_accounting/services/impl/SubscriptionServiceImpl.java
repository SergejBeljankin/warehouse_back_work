package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.SubscriptionDto;
import com.warehouse_accounting.repositories.EmployeeRepository;
import com.warehouse_accounting.repositories.RequisitesRepository;
import com.warehouse_accounting.repositories.RoleRepository;
import com.warehouse_accounting.repositories.SubscriptionRepository;
import com.warehouse_accounting.repositories.TariffRepository;
import com.warehouse_accounting.services.interfaces.SubscriptionService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.warehouse_accounting.util.ConverterDto.convertToDtoTariff;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final TariffRepository tariffRepository;
    private final RequisitesRepository requisitesRepository;
    private final EmployeeRepository employeeRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   RoleRepository roleRepository,
                                   RequisitesRepository requisitesRepository,
                                   EmployeeRepository employeeRepository,
                                   TariffRepository tariffRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.tariffRepository = tariffRepository;
        this.requisitesRepository = requisitesRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<SubscriptionDto> getAll() {
        List<SubscriptionDto> subscriptionDtos = subscriptionRepository.getAll();

        subscriptionDtos.forEach(subscriptionDto -> {
            subscriptionDto.setRequisites(requisitesRepository.getById(subscriptionDto.getRequisites().getId()));
            subscriptionDto.setEmployee((employeeRepository.getById(subscriptionDto.getEmployee().getId())));
            subscriptionDto.setTariff(convertToDtoTariff(tariffRepository.getAllTariffById(subscriptionDto.getId())));
        });
        return subscriptionDtos;
    }

    @Override
    public SubscriptionDto getById(Long id) {
        SubscriptionDto subscriptionDto = subscriptionRepository.getById(id);
        subscriptionDto.setRequisites(requisitesRepository.getById(subscriptionDto.getRequisites().getId()));
        subscriptionDto.setEmployee(employeeRepository.getById(subscriptionDto.getEmployee().getId()));
        subscriptionDto.setTariff(convertToDtoTariff(tariffRepository.getAllTariffById(subscriptionDto.getId())));
        return subscriptionDto;
    }

    @Override
    public void create(SubscriptionDto subscriptionDto) {
        subscriptionRepository.save(ConverterDto.convertToModel(subscriptionDto));
    }

    @Override
    public void update(SubscriptionDto subscriptionDto) {
        subscriptionRepository.save(ConverterDto.convertToModel(subscriptionDto));
    }

    @Override
    public void deleteById(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
