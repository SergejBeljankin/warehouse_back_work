package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Unit;
import com.warehouse_accounting.models.dto.UnitDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.UnitDto(" +
            "u.id," +
            "u.shortName," +
            "u.fullName," +
            "u.sortNumber)" +
            "FROM Unit u")
    List<UnitDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.UnitDto(" +
            "u.id," +
            "u.shortName," +
            "u.fullName," +
            "u.sortNumber)" +
            "FROM Unit u WHERE u.id = :id")
    UnitDto getById(@Param("id") Long id);

}
