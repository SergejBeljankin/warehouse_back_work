package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Movement;
import com.warehouse_accounting.models.dto.MovementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.MovementDto(" +
            "m.id," +
            "m.dateTime," +
            "m.warehouseFrom.id," +
            "m.warehouseTo.id," +
            "m.company.id," +
            "m.sum," +
            "m.moved," +
            "m.printed," +
            "m.comment" +
            ")" +
            " FROM Movement m")
    List<MovementDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.MovementDto(" +
            "m.id," +
            "m.dateTime," +
            "m.warehouseFrom.id," +
            "m.warehouseTo.id," +
            "m.company.id," +
            "m.sum," +
            "m.moved," +
            "m.printed," +
            "m.comment" +
            ")" +
            " FROM Movement m WHERE m.id=:id")
    MovementDto getById(@Param("id") Long id);
}
