package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Selector;
import com.warehouse_accounting.models.dto.ProjectDto;
import com.warehouse_accounting.models.dto.SelectorDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SelectorRepository extends JpaRepository<Selector, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.SelectorDto(" +
            "s.id," +
            "s.activate," +
            "s.phone," +
            "s.post)" +
            "FROM Selector s")
    List<SelectorDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.SelectorDto(" +
            "s.id," +
            "s.activate," +
            "s.phone," +
            "s.post)" +
            "FROM Selector s WHERE s.id = :id")
    SelectorDto getById(@Param("id") Long id);
}
