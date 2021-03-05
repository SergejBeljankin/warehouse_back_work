package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Project;
import com.warehouse_accounting.models.dto.ProjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProjectDto(" +
            "p.id," +
            "p.name," +
            "p.code," +
            "p.description)" +
            "FROM Project p")
    List<ProjectDto> getAll();


    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProjectDto(" +
            "p.id," +
            "p.name," +
            "p.code," +
            "p.description)" +
            "FROM Project p WHERE p.id = :id")
    ProjectDto getById(@Param("id") Long id);
}
