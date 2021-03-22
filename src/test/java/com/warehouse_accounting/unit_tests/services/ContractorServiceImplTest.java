package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.services.impl.ContractorServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class ContractorServiceImplTest {

    @Mock
    private ContractorRepository contractorRepository;

    @Mock
    private LegalDetailRepository legalDetailRepository;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private ContractorServiceImpl contractorService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final LegalDetailDto legalDetailDto = LegalDetailDto.builder()
            .id(1L)
            .lastName("lastName")
            .firstName("tst")
            .middleName("firstName")
            .address("address")
            .commentToAddress("-")
            .inn("inn")
            .okpo("okpo")
            .ogrnip("ogrnip")
            .numberOfTheCertificate("numberOfTheCertificate")
            .dateOfTheCertificate(LocalDate.parse("2021-03-22", formatter))
            .typeOfContractorDto(new TypeOfContractorDto())
            .build();

    private final ContractorDto contractorDto = ContractorDto.builder()
            .id(1L)
            .name("name")
            .inn("inn")
            .sortNumber("sortNumber")
            .phone("phone")
            .fax("fax")
            .email("email")
            .address("address")
            .commentToAddress("commentToAddress")
            .comment("comment")
            .contractorGroupId(1L)
            .contractorGroupName("test")
            .typeOfContractorId(1L)
            .typeOfContractorName("test")
            .typeOfPriceId(1L)
            .typeOfPriceName("test")
            .legalDetailDto(legalDetailDto)
            .bankAccountDtos(new ArrayList<>())
            .build();
    private final List<ContractorDto> contractorDtoList = List.of(contractorDto);

    @Test
    void getAll() {
        when(contractorRepository.getAll()).thenReturn(contractorDtoList);
        when(legalDetailRepository.getById(contractorDto.getLegalDetailDto().getId()))
                .thenReturn(contractorDto.getLegalDetailDto());
        when(bankAccountRepository.getListById(contractorDto.getId()).stream()
                .map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .thenReturn(contractorDto.getBankAccountDtos());
        List<ContractorDto> contractorDtoListTest = contractorService.getAll();
        assertNotNull(contractorDtoListTest, "contractorDtoListTestTest = null");
        assertEquals(contractorDtoListTest, contractorDtoList);
        System.out.println(contractorDtoList);
        verify(contractorRepository, times(1)).getAll();
    }

    @Test
    void getById() {
        when(contractorRepository.getById(1L)).thenReturn(contractorDto);
        when(legalDetailRepository.getById(contractorDto.getLegalDetailDto().getId()))
                .thenReturn(contractorDto.getLegalDetailDto());
        when(bankAccountRepository.getListById(contractorDto.getId()).stream()
                .map(ConverterDto::convertToDto).collect(Collectors.toList()))
                .thenReturn(contractorDto.getBankAccountDtos());
        assertEquals(contractorService.getById(1L), contractorDto);
        verify(contractorRepository, Mockito.times(1))
                .getById(ArgumentMatchers.eq(1L));
        System.out.println(contractorDto);
    }

    @Test
    void create() {
        contractorService.create(contractorDto);
        verify(contractorRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(contractorDto)));
    }

    @Test
    void update() {
        contractorService.update(contractorDto);
        verify(contractorRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(contractorDto)));
    }

    @Test
    void deleteById() {
        contractorService.deleteById(1L);
        verify(contractorRepository, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq(1L));
    }
}