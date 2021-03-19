package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.LegalDetailRestController;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = {"classpath:init-type_of_contractor-table.sql", "classpath:init-legal_detail-table.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class LegalDetailRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LegalDetailRestController legalDetailRestController;
    @Autowired
    private ObjectMapper mapper;

    private static List<LegalDetailDto> legalDetailDtoList = new ArrayList<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeAll
    private static void initLegalDetail() {
        TypeOfContractorDto legal = TypeOfContractorDto.builder()
                .id(1L)
                .name("Юридическое лицо")
                .sortNumber("1").build();

        TypeOfContractorDto entrepreneur = TypeOfContractorDto.builder()
                .id(2L)
                .name("Индивидуальный предприниматель")
                .sortNumber("2").build();

        LegalDetailDto legalDetailDto_1 = LegalDetailDto.builder()
                .id(1L)
                .lastName("Александра")
                .firstName("Васина")
                .middleName("Валерьевна")
                .address("1-й Вязовский пр-д, 4, стр. 19, Москва, 109428")
                .commentToAddress("-")
                .inn("7731537604")
                .okpo("93318947")
                .ogrnip("1067746195330")
                .numberOfTheCertificate("241")
                .dateOfTheCertificate(LocalDate.parse("2020-04-03", formatter))
                .typeOfContractorDto(legal)
                .build();

        LegalDetailDto legalDetailDto_2 = LegalDetailDto.builder()
                .id(2L)
                .lastName("Спартак")
                .firstName("Сократян")
                .middleName("Мушегович")
                .address("Омская обл., г. Омск, ул. Ленина, д. 38 пом. 16, этаж 4")
                .commentToAddress("-")
                .inn("7631588604")
                .okpo("04152913")
                .ogrnip("1165543081879")
                .numberOfTheCertificate("10021")
                .dateOfTheCertificate(LocalDate.parse("2021-02-21", formatter))
                .typeOfContractorDto(legal)
                .build();

        LegalDetailDto legalDetailDto_3 = LegalDetailDto.builder()
                .id(3L)
                .lastName("Оксана")
                .firstName("Демченко")
                .middleName("Владимировна")
                .address("Краснодарский кр., г. Горячий Ключ, ул. Ленина, д. 37")
                .commentToAddress("основной")
                .inn("2305023045")
                .okpo("93814283")
                .ogrnip("1062305001440")
                .numberOfTheCertificate("741000А")
                .dateOfTheCertificate(LocalDate.parse("2020-01-12", formatter))
                .typeOfContractorDto(entrepreneur)
                .build();

        LegalDetailDto legalDetailDto_4 = LegalDetailDto.builder()
                .id(4L)
                .lastName("Сергей")
                .firstName("Кондратенко")
                .middleName("Сергеевич")
                .address("г. Москва, ул. 1-Я Магистральная, д. 2 стр. 1 этаж 3, ком. 8")
                .commentToAddress("")
                .inn("7714921994")
                .okpo("22709223")
                .ogrnip("5137746124368")
                .numberOfTheCertificate("241")
                .dateOfTheCertificate(LocalDate.parse("2021-01-23", formatter))
                .typeOfContractorDto(entrepreneur)
                .build();

        legalDetailDtoList.addAll(Arrays.asList(legalDetailDto_1, legalDetailDto_2, legalDetailDto_3, legalDetailDto_4));
    }

    @Test
    void testExistence() {
        assertThat(legalDetailRestController).isNotNull();
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/api/legal_details"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(legalDetailDtoList)));
    }

    @Test
    void testGetById() throws Exception {
        mockMvc.perform(get("/api/legal_details/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(legalDetailDtoList.get(1))));
    }

    @Test
    void testCreate() throws Exception {
        TypeOfContractorDto physical = TypeOfContractorDto.builder()
                .id(3L)
                .name("Физическое лицо")
                .sortNumber("3").build();

        LegalDetailDto legalDetailDto_5 = LegalDetailDto.builder()
                .id(5L)
                .lastName("Остап")
                .firstName("Бендер-Задунайский")
                .middleName("Ибрагимович")
                .address("Московская обл., г. Ногинск, рабочий пос. Обухово, шоссе Кудиновское, д. 6 стр. 1 офис 59")
                .commentToAddress("")
                .inn("7743013902")
                .okpo("")
                .ogrnip("")
                .numberOfTheCertificate("10050004")
                .dateOfTheCertificate(LocalDate.parse("2019-05-25", formatter))
                .typeOfContractorDto(physical)
                .build();

        legalDetailDtoList.add(legalDetailDto_5);

        mockMvc.perform(put("/api/legal_details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(legalDetailDto_5)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/legal_details/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(legalDetailDto_5)));

        mockMvc.perform(get("/api/legal_details"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(legalDetailDtoList)));

        legalDetailDtoList.remove(legalDetailDto_5);
    }

    @Test
    void testUpdate() throws Exception {
        LegalDetailDto legalDetailDto_1 = LegalDetailDto.builder()
                .id(1L)
                .lastName("Александра")
                .firstName("Васина")
                .middleName("Валерьевна")
                .address("1-й Вязовский пр-д, 4, стр. 19, Москва, 109428")
                .commentToAddress("-")
                .inn("7731537604")
                .okpo("93318947")
                .ogrnip("1067746195330")
                .numberOfTheCertificate("241")
                .dateOfTheCertificate(LocalDate.parse("2020-04-21", formatter))
                .typeOfContractorDto(null)
                .build();

        mockMvc.perform(post("/api/legal_details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(legalDetailDto_1)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/legal_details/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(legalDetailDto_1)));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/legal_details/4"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/legal_details/4"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testFilter() throws Exception {
        List<LegalDetailDto> collectBetween = legalDetailDtoList.stream()
                .filter(dto -> dto.getId().equals(2L) | dto.getId().equals(4L))
                .collect(Collectors.toList());

        List<LegalDetailDto> collectBetweenAndType = legalDetailDtoList.stream()
                .filter(dto -> dto.getId().equals(2L))
                .collect(Collectors.toList());

        mockMvc.perform(get("/api/legal_details/filter?dateOfTheCertificateBetween=2021-01-01;2021-03-18"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(collectBetween)));

        mockMvc.perform(get("/api/legal_details/filter?dateOfTheCertificateBetween=2021-01-01;2021-03-18" +
                "&typeOfContractorName=Юридическое лицо"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(collectBetweenAndType)));

        mockMvc.perform(get("/api/legal_details/filter?dateOfTheCertificateBetween=2021-01-01;2021-03-18" +
                "&typeOfContractorName=Юридическое лицо" +
                "&inn=1234567890"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
