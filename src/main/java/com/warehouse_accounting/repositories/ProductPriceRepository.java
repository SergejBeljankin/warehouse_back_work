package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductPriceDto(pp.id," +
            "pp.product.id," +
            "pp.typeOfPrice.id," +
            "pp.price)" +
            "FROM ProductPrice pp")
    List<ProductPrice> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductPriceDto(pp.id," +
            "pp.product.id," +
            "pp.typeOfPrice.id," +
            "pp.price)" +
            "FROM ProductPrice pp WHERE pp.id = :id")
    ProductPrice getById(@Param("id") Long id);

}
