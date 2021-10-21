package com.warehouse_accounting.unit_tests.services;

import com.warehouse_accounting.models.BonusTransaction;
import com.warehouse_accounting.models.dto.BonusTransactionDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.repositories.BonusTransactionRepository;
import com.warehouse_accounting.services.impl.BonusTransactionServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@SpringBootTest
class BonusTransactionServiceImplTest {

    private static BonusTransactionDto bonusDto1;
    private static BonusTransactionDto bonusDto2;
    private static List<BonusTransactionDto> listBonusDto;

    @Mock
    BonusTransactionRepository bonusTransactionRepository;

    @InjectMocks
    BonusTransactionServiceImpl bonusTransactionService;




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
        when(bonusTransactionRepository.getAll()).thenReturn(listBonusDto);
        List<BonusTransactionDto> resultBonusDtoList = bonusTransactionService.getAll();
        Assert.assertNotNull("get NULL", resultBonusDtoList);
        Assert.assertEquals(resultBonusDtoList, listBonusDto);
        Mockito.verify(bonusTransactionRepository,Mockito.times(1))
                .getAll();

    }

    @Test
    void getById(){
     when(bonusTransactionRepository.getById(1L)).thenReturn(bonusDto1);
     Assert.assertEquals(bonusTransactionService.getById(1L), bonusDto1);
     Mockito.verify(bonusTransactionRepository, Mockito.times(1))
             .getById(ArgumentMatchers.eq(1L));
    }

    @Test
    void create(){
     bonusTransactionService.create(bonusDto1);
     Mockito.verify(bonusTransactionRepository, times(1))
             .save(ArgumentMatchers.eq(ConverterDto.convertToModel(bonusDto1)));
    }

    @Test
    void update(){
     bonusTransactionService.update(bonusDto2);
     Mockito.verify(bonusTransactionRepository, Mockito.times(1))
             .save(ArgumentMatchers.eq(ConverterDto.convertToModel(bonusDto2)));
    }

    @Test
    void delete(){
     bonusTransactionService.deleteById(999L);
     Mockito.verify(bonusTransactionRepository, Mockito.times(1))
             .deleteById(ArgumentMatchers.eq(999L));
    }

}
