package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.TechnologicalMapProduct;
import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository class for entity {@link TechnologicalMapProduct}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 26.03.2021
 */
@Repository
public interface TechnologicalMapProductRepository extends JpaRepository<TechnologicalMapProduct, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapProductDto(" +
            "finprod.id," +
            "finprod.products.id," +
            "finprod.products.name," +
            "finprod.count," +
            "finprod.technologicalMap.id)" +
            "FROM TechnologicalMapProduct finprod")
    List<TechnologicalMapProductDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.TechnologicalMapProductDto(" +
            "finprod.id," +
            "finprod.products.id," +
            "finprod.products.name," +
            "finprod.count," +
            "finprod.technologicalMap.id)" +
            "FROM TechnologicalMapProduct finprod WHERE finprod.id = :id")
    TechnologicalMapProductDto getById(@Param("id") Long id);

    @Query("SELECT finprod FROM TechnologicalMapProduct finprod WHERE finprod.technologicalMap.id = :id")
    List<TechnologicalMapProduct> getListTechnologicalMapProductById(@Param("id") Long id);
}
