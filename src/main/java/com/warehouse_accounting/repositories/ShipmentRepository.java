package com.warehouse_accounting.repositories;


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
            "sh.id," +
            "sh.movingFields.dateOfCreation," +
            "sh.movingFields.warehouse.id," +
            "sh.movingFields.contract.id," +
            "sh.movingFields.contractor.id," +
            "sh.movingFields.company.id," +
            "sh.movingFields.sum," +
            "sh.movingFields.paid," +
            "sh.movingFields.isSent," +
            "sh.movingFields.isPrinted," +
            "sh.movingFields.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh " )
    List<ShipmentDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ShipmentDto(" +
            "sh.id," +
            "sh.movingFields.dateOfCreation," +
            "sh.movingFields.warehouse.id," +
            "sh.movingFields.contract.id," +
            "sh.movingFields.contractor.id," +
            "sh.movingFields.company.id," +
            "sh.movingFields.sum," +
            "sh.movingFields.paid," +
            "sh.movingFields.isSent," +
            "sh.movingFields.isPrinted," +
            "sh.movingFields.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh WHERE sh.id = :id")
    ShipmentDto getById(@Param("id") Long id);


}
