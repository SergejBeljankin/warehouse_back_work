package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.UnitsOfMeasure;
import com.warehouse_accounting.models.dto.UnitsOfMeasureDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitsOfMeasureRepository extends JpaRepository<UnitsOfMeasure, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.UnitsOfMeasureDto(" +
            "u.id," +
            "u.type," +
            "u.name," +
            "u.fullName," +
            "u.code" +
            ")"+
            "FROM UnitsOfMeasure u")
    List<UnitsOfMeasureDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.UnitsOfMeasureDto(" +
            "u.id," +
            "u.type," +
            "u.name," +
            "u.fullName," +
            "u.code" +
            ")"+
            "FROM UnitsOfMeasure u WHERE u.id=:id")
    UnitsOfMeasureDto getById(@Param("id") Long id);
}
