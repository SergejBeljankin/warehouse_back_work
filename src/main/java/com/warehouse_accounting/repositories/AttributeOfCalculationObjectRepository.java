package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.AttributeOfCalculationObject;
import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface AttributeOfCalculationObjectRepository extends JpaRepository <AttributeOfCalculationObject, Long> {

    @Query("SELECT new com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto(" +
            "r.id," +
            "r.name," +
            "r.sortNumber,"+
            "r.isService" +
            ")"+
            "FROM AttributeOfCalculationObject r")
    List<AttributeOfCalculationObjectDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto(" +
            "r.id," +
            "r.name," +
            "r.sortNumber," +
            "r.isService) " +
            "FROM AttributeOfCalculationObject r WHERE r.id = :id")
    AttributeOfCalculationObjectDto getById(@Param("id") Long id);

}
