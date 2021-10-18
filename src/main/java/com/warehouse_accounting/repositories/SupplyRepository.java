package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.Supply;
import com.warehouse_accounting.models.dto.SupplyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.SupplyDto(" +
            "s.id," +
            "s.dataTime," +
            "s.warehouse.id," +
            "s.contract.id," +
            "s.contractor.id," +
            "s.company.id," +
            "s.sum," +
            "s.paid," +
            "s.isSent," +
            "s.isPrinted," +
            "s.comment)" +
            " FROM Supply s")
    List<SupplyDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.SupplyDto(" +
            "s.id," +
            "s.dataTime," +
            "s.warehouse.id," +
            "s.contract.id," +
            "s.contractor.id," +
            "s.company.id," +
            "s.sum," +
            "s.paid," +
            "s.isSent," +
            "s.isPrinted," +
            "s.comment)" +
            " FROM Supply s WHERE s.id = :id")
    SupplyDto getById(@Param("id") Long id);

}
