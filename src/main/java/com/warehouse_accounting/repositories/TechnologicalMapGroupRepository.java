package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.TechnologicalMapGroup;
import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for entity {@link TechnologicalMapGroup}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */

@Repository
public interface TechnologicalMapGroupRepository extends JpaRepository<TechnologicalMapGroup, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapGroupDto(" +
            "g.id, " +
            "g.name, " +
            "g.code, " +
            "g.comment, " +
            "sub_g.id," +
            "sub_g.name) " +
            "FROM TechnologicalMapGroup g " +
            "LEFT JOIN TechnologicalMapGroup sub_g ON (g.parentTechnologicalMapGroup.id = sub_g.id)")
    List<TechnologicalMapGroupDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapGroupDto(" +
            "g.id, " +
            "g.name, " +
            "g.code, " +
            "g.comment, " +
            "sub_g.id," +
            "sub_g.name) " +
            "FROM TechnologicalMapGroup g " +
            "LEFT JOIN TechnologicalMapGroup sub_g ON (g.parentTechnologicalMapGroup.id = sub_g.id)" +
            "WHERE g.id = :id ")
    TechnologicalMapGroupDto getById(@Param("id") Long id);
}
