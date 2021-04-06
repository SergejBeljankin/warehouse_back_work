package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Country;
import com.warehouse_accounting.models.dto.CountryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.CountryDto(" +
            "c.id," +
            "c.shortName," +
            "c.longName," +
            "c.code," +
            "c.codeOne," +
            "c.codeTwo)" +
            "FROM Country c")
    List<CountryDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.CountryDto(" +
            "c.id," +
            "c.shortName," +
            "c.longName," +
            "c.code," +
            "c.codeOne," +
            "c.codeTwo)" +
            "FROM Country c WHERE c.id = :id")
    CountryDto getById(@Param("id") Long id);
}

