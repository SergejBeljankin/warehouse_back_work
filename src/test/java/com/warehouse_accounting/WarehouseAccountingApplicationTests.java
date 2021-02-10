package com.warehouse_accounting;

import com.warehouse_accounting.models.TypeOfContractor;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.services.impl.LegalDetailServiceImpl;
import com.warehouse_accounting.services.impl.TypeOfContractorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WarehouseAccountingApplicationTests {

    @Autowired
    private LegalDetailServiceImpl service;

    @Autowired
    private TypeOfContractorServiceImpl typeOfContractorService;

    TypeOfContractorDto contractor1 = TypeOfContractorDto.builder()
            .id((long)1)
            .sortNumber("sin")
            .name("sin").build();
    TypeOfContractorDto contractor2 = TypeOfContractorDto.builder()
            .id((long)2)
            .sortNumber("sobaki")
            .name("sobaki").build();

    @Test
    void contextLoads() {
/*
        typeOfContractorService.create(contractor1);
        typeOfContractorService.create(contractor2);
*/
    }

    @Test
    void create() {
        LegalDetailDto legalDetailDto = LegalDetailDto.builder()
                .firstName("sdfsdf")
                .address("sdfdfsdfddddddddddddddd")
                .typeOfContractorDto(contractor1).build();
        service.create(legalDetailDto);
    }

    @Test
    void update() {
        LegalDetailDto legalDetailDto = LegalDetailDto.builder()
                .id((long)2)
                .firstName("lol")
                .address("kek")
                .typeOfContractorDto(contractor2).build();
        service.update(legalDetailDto);
    }

    @Test
    void getAll() {
        for(LegalDetailDto legalDetailDto : service.getAll()) {
            System.out.println(legalDetailDto);
        }
    }

    @Test
    void getOne() {
        System.out.println(service.getById((long)1));
    }

    @Test
    void delete() {
        service.deleteById((long)2);
    }


}
