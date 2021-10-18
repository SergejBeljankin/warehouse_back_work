package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.ProductGroup;
import com.warehouse_accounting.models.dto.ProductGroupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {


    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductGroupDto(" +
            "pg.id," +
            "pg.name," +
            "pg.sortNumber," +
            "pg.parentId" +
            ") " +
            "FROM ProductGroup pg")
    List<ProductGroupDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductGroupDto(" +
            "pg.id," +
            "pg.name," +
            "pg.sortNumber," +
            "pg.parentId" +
            ") " +
            "FROM ProductGroup pg WHERE pg.id = :id")
    ProductGroupDto getById(@Param("id") Long id);


    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductGroupDto(" +
            "pg.id," +
            "pg.name," +
            "pg.sortNumber," +
            "pg.parentId" +
            ") " +
            "FROM ProductGroup pg WHERE pg.parentId = :id")
    List<ProductGroupDto> getAllIds(@Param("id") Long id);

}
