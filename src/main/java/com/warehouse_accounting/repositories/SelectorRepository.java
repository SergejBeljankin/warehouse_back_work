package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.dto.ProjectDto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SelectorRepository {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.SelectorDto(" +
            "s.id," +
            "s.activate," +
            "s.phone," +
            "s.post)" +
            "FROM Selector s")
    List<ProjectDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.SelectorDto(" +
            "s.id," +
            "s.activate," +
            "s.phone," +
            "s.post)" +
            "FROM Selector s WHERE s.id = :id")
    ProjectDto getById(@Param("id") Long id);
}
