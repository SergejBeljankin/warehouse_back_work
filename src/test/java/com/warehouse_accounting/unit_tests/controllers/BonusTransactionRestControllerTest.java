package com.warehouse_accounting.unit_tests.controllers;

import com.warehouse_accounting.controllers.rest.BonusTransactionRestController;
import com.warehouse_accounting.models.BonusTransaction;
import com.warehouse_accounting.models.dto.BonusTransactionDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.repositories.BonusTransactionRepository;
import com.warehouse_accounting.services.impl.BonusTransactionServiceImpl;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import org.apache.xpath.Arg;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.util.Assert.notNull;

@SpringBootTest
public class BonusTransactionRestControllerTest {

    private static BonusTransactionDto bonusDto1;
    private static BonusTransactionDto bonusDto2;
    private static List<BonusTransactionDto> listBonusDto;

    @InjectMocks
    BonusTransactionRestController bonusTransactionRestController;

    @Mock
    BonusTransactionServiceImpl bonusTransactionService;

    @Mock
    CheckEntityService checkEntityService;

    @Mock
    BonusTransactionRepository repository;


    @BeforeAll
    static void initMethod(){
        bonusDto1 = BonusTransactionDto.builder()
                .id(3L)
                .created(LocalDateTime.now())
                .transactionType(BonusTransaction.TransactionType.EARNING)
                .bonusValue(5L)
                .transactionStatus(BonusTransaction.TransactionStatus.COMPLETED)
                .executionDate(LocalDateTime.now())
                .bonusProgram("beginer")
                .contragent(ContractorDto.builder().build())
                .comment("First Transaction!")
                .owner(EmployeeDto.builder().build())
                .build();
        bonusDto2 = BonusTransactionDto.builder()
                .id(2L)
                .created(LocalDateTime.now())
                .transactionType(BonusTransaction.TransactionType.SPENDING)
                .bonusValue(10L)
                .transactionStatus(BonusTransaction.TransactionStatus.CANCELED)
                .executionDate(LocalDateTime.now())
                .bonusProgram("vip")
                .comment("Second Transaction")
                .contragent(ContractorDto.builder().build())
                .owner(EmployeeDto.builder().build())
                .build();
        listBonusDto = List.of(bonusDto1,bonusDto2);
    }

    @Test
    void getAll(){
        when(bonusTransactionService.getAll()).thenReturn(listBonusDto);
        ResponseEntity<List<BonusTransactionDto>> responseEntity = bonusTransactionRestController.getAll();
        notNull(responseEntity.getBody(), "Result: NULL");
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(), listBonusDto);
        verify(bonusTransactionService, times(1))
                .getAll();

    }

    @Test
    void getById(){
        when(bonusTransactionService.getById(1L)).thenReturn(bonusDto1);
        ResponseEntity<BonusTransactionDto> responseEntity = bonusTransactionRestController.getById(1L);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(), bonusDto1);
        verify(checkEntityService, times(1))
                .checkExist(ArgumentMatchers.eq(1L), repository, "BonusTransaction");
        verify(bonusTransactionService, times(1))
                .getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create(){
        assertEquals(bonusTransactionRestController.create(bonusDto1).getStatusCode(),HttpStatus.OK);
        verify(bonusTransactionService, times(1))
                .create(ArgumentMatchers.eq(bonusDto1));
    }

    @Test
    void update(){
        assertEquals(bonusTransactionRestController.update(bonusDto2).getStatusCode(), HttpStatus.OK);
        verify(bonusTransactionService, times(1))
                .update(ArgumentMatchers.eq(bonusDto2));
    }

    @Test
    void deletById(){
        assertEquals(bonusTransactionRestController.deleteById(999L).getStatusCode(), HttpStatus.OK);
        verify(bonusTransactionService, times(1))
                .deleteById(ArgumentMatchers.eq(999L));
    }
}
