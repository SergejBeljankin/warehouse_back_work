package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Currency;
import com.warehouse_accounting.models.dto.CurrencyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CurrencyDto(" +
            "c.id," +
            "c.shortName," +
            "c.fullName," +
            "c.digitalCode,"+
            "c.letterCode,"+
            "c.sortNumber)" +
            "FROM Currency c")
    List<CurrencyDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.CurrencyDto(" +
            "c.id, " +
            "c.shortName," +
            "c.fullName," +
            "c.digitalCode,"+
            "c.letterCode,"+
            "c.sortNumber)" +
            "FROM Currency c where c.id = :id")
    CurrencyDto getById(Long id);
}
