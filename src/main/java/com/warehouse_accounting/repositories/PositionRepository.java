package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Position;
import com.warehouse_accounting.models.dto.PositionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("SELECT " +
            "NEW com.warehouse_accounting.models.dto.PositionDto(" +
            "p.id, " +
            "p.name, " +
            "p.sortNumber) " +
            "FROM Position p")
    List<PositionDto> getAll();

    @Query("SELECT " +
            "NEW com.warehouse_accounting.models.dto.PositionDto(" +
            "p.id, " +
            "p.name, " +
            "p.sortNumber) " +
            "FROM Position p " +
            "WHERE p.id=:id")
    PositionDto getById(@Param("id") Long id);

    @Query("SELECT " +
            "NEW com.warehouse_accounting.models.dto.PositionDto(" +
            "p.id, " +
            "p.name, " +
            "p.sortNumber) " +
            "FROM Position p " +
            "WHERE LOWER(CONCAT(p.id, p.name)) like LOWER(CONCAT('%', :searchValue, '%'))")
    List<PositionDto> getAllByLikeQuery(@Param("searchValue") String searchValue);
}
