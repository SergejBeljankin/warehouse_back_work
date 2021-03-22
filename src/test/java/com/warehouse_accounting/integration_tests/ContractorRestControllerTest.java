package com.warehouse_accounting.integration_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse_accounting.controllers.rest.ContractorRestController;
import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.models.dto.ContractorDto;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql(value = {"classpath:init-type_of_contractor-table.sql", "classpath:init-type_of_price-table.sql",
        "classpath:init-contractor_group-table.sql", "classpath:init-legal_detail-table.sql",
        "classpath:init-contractor-table.sql", "classpath:init-bank_account.sql",
        "classpath:init-contractor_bank_account-table.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ContractorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContractorRestController contractorRestController;

    @Autowired
    private ObjectMapper objectMapper;

    private static final List<ContractorDto> contractorDtoList = new ArrayList<>();

    @BeforeAll
    static void init() {
        BankAccountDto bankAccountDto1 = BankAccountDto.builder()
                .id(1L)
                .account("account")
                .address("address")
                .bank("bank")
                .correspondentAccount("correspondent_account")
                .mainAccount(true)
                .rcbic("rcbic")
                .sortNumber("sort_number")
                .build();
        BankAccountDto bankAccountDto2 = BankAccountDto.builder()
                .id(2L)
                .account("account1")
                .address("address1")
                .bank("bank1")
                .correspondentAccount("correspondent_account1")
                .mainAccount(false)
                .rcbic("rcbic1")
                .sortNumber("sort_number1")
                .build();

        List<BankAccountDto> bankAccountDtoList = List.of(bankAccountDto1, bankAccountDto2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LegalDetailDto legalDetailDto = LegalDetailDto.builder()
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
                .typeOfContractorDto(new TypeOfContractorDto(1L, null, null))
                .build();

        ContractorDto contractorDto = ContractorDto.builder()
                .id(1L)
                .address("address")
                .comment("comment")
                .commentToAddress("commentToAddress")
                .name("name")
                .inn("inn")
                .sortNumber("sortNumber")
                .phone("phone")
                .fax("fax")
                .email("email")
                .contractorGroupId(1L)
                .contractorGroupName("Покупатель")
                .typeOfContractorId(1L)
                .typeOfContractorName("Юридическое лицо")
                .typeOfPriceId(1L)
                .typeOfPriceName("Оптовая")
                .legalDetailDto(legalDetailDto)
                .bankAccountDtos(bankAccountDtoList)
                .build();

        contractorDtoList.addAll(Collections.singletonList(contractorDto));

    }


    @Test
    void testExistence() {
        assertThat(contractorRestController).isNotNull();
    }

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get("/api/contractors"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(contractorDtoList)));
    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/contractors/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(contractorDtoList.get(0))));
    }

    @Test
    void create() throws Exception {
        ContractorDto contractorDto2 = ContractorDto.builder()
                .id(2L)
                .address("address1")
                .comment("comment1")
                .commentToAddress("commentToAddress1")
                .name("name1")
                .inn("inn1")
                .sortNumber("sortNumber1")
                .phone("phone1")
                .fax("fax1")
                .email("email1")
                .contractorGroupId(1L)
                .contractorGroupName("Покупатель")
                .typeOfContractorId(1L)
                .typeOfContractorName("Юридическое лицо")
                .typeOfPriceId(1L)
                .typeOfPriceName("Оптовая")
                .legalDetailDto(null)
                .bankAccountDtos(new ArrayList<>())
                .build();

        contractorDtoList.add(contractorDto2);
        mockMvc.perform(post("/api/contractors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contractorDto2)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/contractors/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(contractorDtoList.get(1))));

        contractorDtoList.remove(contractorDto2);

    }

    @Test
    void update() throws Exception {
        ContractorDto contractorDto1 = ContractorDto.builder()
                .id(1L)
                .address("address1")
                .comment("comment")
                .commentToAddress("commentToAddress")
                .name("name")
                .inn("inn")
                .sortNumber("sortNumber")
                .phone("phone")
                .fax("fax")
                .email("email")
                .contractorGroupId(1L)
                .contractorGroupName("Покупатель")
                .typeOfContractorId(1L)
                .typeOfContractorName("Юридическое лицо")
                .typeOfPriceId(1L)
                .typeOfPriceName("Оптовая")
                .legalDetailDto(null)
                .bankAccountDtos(new ArrayList<>())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/contractors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contractorDto1)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/contractors/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(contractorDto1)));
    }

    @Test
    void deleteById() throws Exception {
        mockMvc.perform(delete("/api/contractors/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/contractors/1"))
                .andExpect(status().isNotFound());
    }
}
