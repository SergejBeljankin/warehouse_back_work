package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Transfer;
import com.warehouse_accounting.models.dto.TransferDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TransferDto(" +
            "t.id," +
            "t.dateTime," +
            "t.warehouseFrom.id," +
            "t.warehouseTo.id," +
            "t.company.id," +
            "t.sum," +
            "t.transferred," +
            "t.printed," +
            "t.comment" +
            ")" +
            " FROM Transfer t")
    List<TransferDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TransferDto(" +
            "t.id," +
            "t.dateTime," +
            "t.warehouseFrom.id," +
            "t.warehouseTo.id," +
            "t.company.id," +
            "t.sum," +
            "t.transferred," +
            "t.printed," +
            "t.comment" +
            ")" +
            " FROM Transfer t WHERE t.id=:id")
    TransferDto getById(@Param("id") Long id);
}
