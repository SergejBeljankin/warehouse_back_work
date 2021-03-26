package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.TechnologicalMapMaterial;
import com.warehouse_accounting.models.TechnologicalMapProduct;
import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;
import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for entity {@link TechnologicalMapMaterial}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Repository
public interface TechnologicalMapMaterialRepository extends JpaRepository<TechnologicalMapMaterial,Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto(" +
            "material.id," +
            "material.materials.id," +
            "material.materials.name," +
            "material.count," +
            "material.technologicalMap.id)" +
            "FROM TechnologicalMapMaterial material")
    List<TechnologicalMapMaterialDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto(" +
            "material.id," +
            "material.materials.id," +
            "material.materials.name," +
            "material.count," +
            "material.technologicalMap.id)" +
            "FROM TechnologicalMapMaterial material WHERE material.id = :id")
    TechnologicalMapMaterialDto getById(@Param("id") Long id);

    @Query("SELECT material.finishedProducts FROM TechnologicalMap material WHERE material.id = :id")
    List<TechnologicalMapMaterialDto> getListTechnologicalMapMaterialById(@Param("id") Long id);
}
