package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.repositories.LegalDetailRepository;
import com.warehouse_accounting.repositories.TypeOfContractorRepository;
import com.warehouse_accounting.services.impl.LegalDetailServiceImpl;
import com.warehouse_accounting.services.interfaces.LegalDetailService;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class LegalDetailServiceTest {

    @Mock
    private LegalDetailRepository legalDetailRepository;

    @InjectMocks
    private LegalDetailServiceImpl legalDetailService;

    private static LegalDetailDto legalDetailDto_1;
    private static LegalDetailDto legalDetailDto_2;
    private static List<LegalDetailDto> legalDetailDtoList;

    @BeforeAll
    static void initLegalDetail() {

        legalDetailDto_1 = LegalDetailDto.builder()
                .id(1L)
                .fullName("Александра")
                .address("1-й Вязовский пр-д, 4, стр. 19, Москва, 109428")
                .commentToAddress("-")
                .inn("7731537604")
                .kpp("111111111")
                .okpo("93318947")
                .ogrn("1067746195330")
                .typeOfContractorId(1L)
                .typeOfContractorName("Юридическое лицо")
                .build();

        legalDetailDto_2 = LegalDetailDto.builder()
                .id(2L)
                .fullName("Спартак")
                .address("Омская обл., г. Омск, ул. Ленина, д. 38 пом. 16, этаж 4")
                .commentToAddress("-")
                .inn("7631588604")
                .kpp("111111111")
                .okpo("04152913")
                .ogrn("1165543081879")
                .typeOfContractorId(2L)
                .typeOfContractorName("Индивидуальный предприниматель")
                .build();

        legalDetailDtoList = List.of(legalDetailDto_1, legalDetailDto_2);
    }

    @Test
    void getAll() {
        when(legalDetailRepository.getAll()).thenReturn(legalDetailDtoList);
        List<LegalDetailDto> resultRoleDtoList = legalDetailService.getAll();
        Assert.notNull(resultRoleDtoList, "getAll return null");
        Assertions.assertEquals(resultRoleDtoList, legalDetailDtoList);
        Mockito.verify(legalDetailRepository, Mockito.times(1))
                .getAll();
    }

    @Test
    void getById() {
        when(legalDetailRepository.getById(1L)).thenReturn(legalDetailDto_1);
        Assertions.assertEquals(legalDetailService.getById(1L), legalDetailDto_1);
        Mockito.verify(legalDetailRepository, Mockito.times(1))
                .getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create() {
        legalDetailService.create(legalDetailDto_1);
        Mockito.verify(legalDetailRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(legalDetailDto_1)));
    }

    @Test
    void update() {
        legalDetailService.update(legalDetailDto_2);
        Mockito.verify(legalDetailRepository, Mockito.times(1))
                .save(ArgumentMatchers.eq(ConverterDto.convertToModel(legalDetailDto_2)));
    }

    @Test
    void deleteById() {
        legalDetailService.deleteById(999L);
        Mockito.verify(legalDetailRepository, Mockito.times(1))
                .deleteById(ArgumentMatchers.eq(999L));
    }
}