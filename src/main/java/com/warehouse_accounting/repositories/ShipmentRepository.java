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
            "s.movingFields.dateOfCreation," +
            "s.movingFields.warehouse.id," +
            "s.movingFields.contract.id," +
            "s.movingFields.contractor.id," +
            "s.movingFields.company.id," +
            "s.movingFields.sum," +
            "s.movingFields.paid," +
            "s.movingFields.isSent," +
            "s.movingFields.isPrinted," +
            "s.movingFields.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh " +
            "LEFT JOIN Supply s ON (s.id = sh.id)")
    List<ShipmentDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ShipmentDto(" +
            "s.id," +
            "s.movingFields.dateOfCreation," +
            "s.movingFields.warehouse.id," +
            "s.movingFields.contract.id," +
            "s.movingFields.contractor.id," +
            "s.movingFields.company.id," +
            "s.movingFields.sum," +
            "s.movingFields.paid," +
            "s.movingFields.isSent," +
            "s.movingFields.isPrinted," +
            "s.movingFields.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh " +
            "LEFT JOIN Supply s ON (s.id = sh.id)" +
            "WHERE s.id = :id")
    ShipmentDto getById(@Param("id") Long id);


}
