package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.TechnologicalMap;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for entity {@link TechnologicalMap}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Repository
public interface TechnologicalMapRepository extends JpaRepository<TechnologicalMap, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapDto(" +
            "map.id," +
            "map.name," +
            "map.comment," +
            "map.isArchived," +
            "map.productionCost," +
            "map_group.id," +
            "map_group.name)" +
            "FROM TechnologicalMap map " +
            "LEFT JOIN TechnologicalMapGroup map_group ON (map.technologicalMapGroup.id = map_group.id)")
    List<TechnologicalMapDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapDto(" +
            "map.id, " +
            "map.name, " +
            "map.comment, " +
            "map.isArchived, " +
            "map.productionCost, " +
            "map_group.id, " +
            "map_group.name) " +
            "FROM TechnologicalMap map " +
            "LEFT JOIN TechnologicalMapGroup map_group ON (map.technologicalMapGroup.id = map_group.id) " +
            "WHERE map.id = :id")
    TechnologicalMapDto getById(@Param("id") Long id);
}
