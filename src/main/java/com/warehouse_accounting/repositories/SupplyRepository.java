package com.warehouse_accounting.repositories;

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
            "s.movingFields.dateOfCreation," +
            "s.movingFields.warehouse.id," +
            "s.movingFields.contract.id," +
            "s.movingFields.contractor.id," +
            "s.movingFields.company.id," +
            "s.movingFields.sum," +
            "s.movingFields.paid," +
            "s.movingFields.isSent," +
            "s.movingFields.isPrinted," +
            "s.movingFields.comment)" +
            " FROM Supply s")
    List<SupplyDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.SupplyDto(" +
            "s.id," +
            "s.movingFields.dateOfCreation," +
            "s.movingFields.warehouse.id," +
            "s.movingFields.contract.id," +
            "s.movingFields.contractor.id," +
            "s.movingFields.company.id," +
            "s.movingFields.sum," +
            "s.movingFields.paid," +
            "s.movingFields.isSent," +
            "s.movingFields.isPrinted," +
            "s.movingFields.comment)" +
            " FROM Supply s WHERE s.id = :id")
    SupplyDto getById(@Param("id") Long id);

}
