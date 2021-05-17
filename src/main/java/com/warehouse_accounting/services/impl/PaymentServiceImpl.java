package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.PaymentDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.PaymentRepository;
import com.warehouse_accounting.repositories.TaskRepository;
import com.warehouse_accounting.services.interfaces.PaymentService;
import com.warehouse_accounting.util.ConverterDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final TaskRepository taskRepository;
    private final ContractorRepository contractorRepository;
    private final CompanyRepository companyRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              TaskRepository taskRepository,
                              ContractorRepository contractorRepository,
                              CompanyRepository companyRepository) {
        this.paymentRepository = paymentRepository;
        this.taskRepository = taskRepository;
        this.contractorRepository = contractorRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<PaymentDto> getAll() {
        List<PaymentDto> paymentDtos = paymentRepository.getAll();
        for (PaymentDto paymentDto : paymentDtos) {
            paymentDto.setTaskDtos(taskRepository.getListTaskById(paymentDto.getId())
                    .stream()
                    .map(ConverterDto::convertToDto)
                    .collect(Collectors.toList()));
            paymentDto.setContractorDto(contractorRepository.getById(paymentDto.getContractorDto().getId()));
            paymentDto.setCompanyDto(companyRepository.getById(paymentDto.getCompanyDto().getId()));
        }
        return paymentDtos;
    }

    @Override
    public PaymentDto getById(Long id) {
        PaymentDto paymentDto = paymentRepository.getById(id);
        paymentDto.setTaskDtos(taskRepository.getListTaskById(paymentDto.getId())
                .stream()
                .map(ConverterDto::convertToDto)
                .collect(Collectors.toList()));
        paymentDto.setContractorDto(contractorRepository.getById(paymentDto.getContractorDto().getId()));
        paymentDto.setCompanyDto(companyRepository.getById(paymentDto.getCompanyDto().getId()));
        return paymentDto;
    }

    @Override
    public void create(PaymentDto paymentDto) {
        paymentRepository.save(ConverterDto.convertToModel(paymentDto));
    }

    @Override
    public void update(PaymentDto paymentDto) {
        paymentRepository.save(ConverterDto.convertToModel(paymentDto));
    }

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}
