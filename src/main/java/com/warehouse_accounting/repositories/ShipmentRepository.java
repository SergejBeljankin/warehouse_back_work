package com.warehouse_accounting.repositories;


import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.Shipment;
import com.warehouse_accounting.models.dto.ShipmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
    @Query("SELECT NEW com.warehouse_accounting.models.dto.ShipmentDto(" +
            "s.id," +
            "s.dataTime," +
            "s.warehouse.id," +
            "s.contract.id," +
            "s.contractor.id," +
            "s.company.id," +
            "s.sum," +
            "s.paid," +
            "s.isSent," +
            "s.isPrinted," +
            "s.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh " +
            "LEFT JOIN Supply s ON (s.id = sh.id)")
    List<ShipmentDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ShipmentDto(" +
            "s.id," +
            "s.dataTime," +
            "s.warehouse.id," +
            "s.contract.id," +
            "s.contractor.id," +
            "s.company.id," +
            "s.sum," +
            "s.paid," +
            "s.isSent," +
            "s.isPrinted," +
            "s.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh " +
            "LEFT JOIN Supply s ON (s.id = sh.id)" +
            "WHERE s.id = :id")
    ShipmentDto getById(@Param("id") Long id);


}
