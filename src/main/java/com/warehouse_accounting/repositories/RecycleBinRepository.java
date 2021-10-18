package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.RecycleBin;
import com.warehouse_accounting.models.dto.RecycleBinDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecycleBinRepository extends JpaRepository<RecycleBin, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.RecycleBinDto(" +
            "re.id, " +
            "re.documentType, " +
            "re.number, " +
            "re.date, " +
            "re.sum, " +
            "re.warehouseTo, " +
            "re.warehouseFrom, " +
            "re.companyName, " +
            "re.contractorName, " +
            "re.status, " +
            "re.shipped, " +
            "re.printed, " +
            "re.comment" +
            ")" +
            " FROM RecycleBin re")
    List<RecycleBinDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.RecycleBinDto(" +
            "re.id, " +
            "re.documentType, " +
            "re.number, " +
            "re.date, " +
            "re.sum, " +
            "re.warehouseTo, " +
            "re.warehouseFrom, " +
            "re.companyName, " +
            "re.contractorName, " +
            "re.status, " +
            "re.shipped, " +
            "re.printed, " +
            "re.comment" +
            ")" +
            " FROM RecycleBin re WHERE re.id=:id")
    RecycleBinDto getById(@Param("id") Long id);
}

