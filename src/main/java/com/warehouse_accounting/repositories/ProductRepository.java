package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductDto(" +
            "p.id, " +
            "p.name, " +
            "p.weight, " +
            "p.volume, " +
            "p.purchasePrice, " +
            "p.description, " +
            "p.unit.id, " +
            "p.archive, " +
            "p.contractor.id, " +
            "p.taxSystem.id, " +
            "p.productGroup.id, " +
            "p.attributeOfCalculationObject.id " +
            ")" +
            "FROM Product p")
    List<ProductDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ProductDto(" +
            "p.id, " +
            "p.name, " +
            "p.weight, " +
            "p.volume, " +
            "p.purchasePrice, " +
            "p.description, " +
            "p.unit.id, " +
            "p.archive, " +
            "p.contractor.id, " +
            "p.taxSystem.id, " +
            "p.productGroup.id, " +
            "p.attributeOfCalculationObject.id " +
            ")" +
            "FROM Product p WHERE p.id = :id")
    ProductDto getById(@Param("id") Long id);

    @Query("SELECT sh.products FROM Shipment sh WHERE sh.id = :id")
    List<Product> getShipmentProductById(@Param("id") Long id);

    @Query("SELECT s.products FROM Supply s WHERE s.id = :id")
    List<Product> getSupplyProductById(@Param("id") Long id);

}
