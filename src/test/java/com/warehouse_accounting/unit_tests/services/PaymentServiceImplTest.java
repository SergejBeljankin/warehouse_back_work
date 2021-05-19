package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.ContractorGroup;
import com.warehouse_accounting.models.TypeOfPayment;
import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ContractorGroupDto;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.PaymentDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.PaymentRepository;
import com.warehouse_accounting.repositories.TaskRepository;
import com.warehouse_accounting.services.impl.PaymentServiceImpl;
import com.warehouse_accounting.services.interfaces.PaymentService;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private ContractorRepository contractorRepository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private static PaymentDto paymentDto;

    private static List<PaymentDto> paymentDtoList = new ArrayList<>();

    @BeforeAll
    static void init() {
        LegalDetailDto legalDetailDto = LegalDetailDto.builder()
                .id(10L)
                .build();

        CompanyDto companyDto = CompanyDto.builder()
                .id(10L)
                .legalDetailDto(legalDetailDto)
                .build();

        paymentDto = PaymentDto.builder()
                .id(1L)
                .number("1")
                .isDone(true)
                .contractorDto(ContractorDto.builder().build())
                .companyDto(companyDto)
                .paymentExpenditureId(1L)
                .paymentExpenditureName("Категория")
                .taskDtos(new ArrayList<>())
                .documents(new ArrayList<>())
                .contractId(1L)
                .contractNumber("Контракт")
                .comment("Комментарий")
                .purpose("Цель")
                .amount(BigDecimal.valueOf(10L))
                .tax(BigDecimal.valueOf(1L))
                .typeOfPayment(TypeOfPayment.INCOMING_PAYMENT)
                .projectId(1L)
                .projectName("Проект")
                .build();

        paymentDtoList.add(paymentDto);
    }

    @Test
    void getAll() {
        when(paymentRepository.getAll()).thenReturn(paymentDtoList);
        List<PaymentDto> paymentDtoListTest = paymentService.getAll();
        assertNotNull(paymentDtoListTest, "paymentDtoListTest == null");
        assertEquals(paymentDtoListTest, paymentDtoList);
        verify(paymentRepository, times(1)).getAll();
    }

    @Test
    void getById() {
        when(paymentRepository.getById(1L)).thenReturn(paymentDto);
        assertEquals(paymentRepository.getById(1L), paymentDto);
        verify(paymentRepository, times(1)).getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create() {
        paymentService.create(paymentDto);
        verify(paymentRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(paymentDto)));
    }

    @Test
    void update() {
        paymentService.update(paymentDto);
        verify(paymentRepository, times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(paymentDto)));
    }

    @Test
    void deleteById() {
        paymentService.delete(1L);
        verify(paymentRepository, times(1)).deleteById(ArgumentMatchers.eq(1L));
    }

}
