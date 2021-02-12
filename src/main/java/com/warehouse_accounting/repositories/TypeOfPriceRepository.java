package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.TypeOfPrice;
import com.warehouse_accounting.models.dto.TypeOfPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeOfPriceRepository extends JpaRepository<TypeOfPrice, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.TypeOfPriceDto(" +
            "p.id," +
            "p.name," +
            "p.sortNumber"+
            ")"+
            "FROM TypeOfPrice p")
    List<TypeOfPriceDto> getAll();


    @Query("SELECT new com.warehouse_accounting.models.dto.TypeOfPriceDto(" +
            "p.id," +
            "p.name," +
            "p.sortNumber"+
            ")"+
            "FROM TypeOfPrice p WHERE p.id = :id")
    TypeOfPriceDto getById(@Param("id") Long id);

}