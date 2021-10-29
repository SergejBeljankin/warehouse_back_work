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
            "sh.dateOfCreation," +
            "sh.warehouse.id," +
            "sh.contract.id," +
            "sh.contractor.id," +
            "sh.company.id," +
            "sh.sum," +
            "sh.paid," +
            "sh.isSent," +
            "sh.isPrinted," +
            "sh.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh " )
    List<ShipmentDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.ShipmentDto(" +
            "sh.id," +
            "sh.dateOfCreation," +
            "sh.warehouse.id," +
            "sh.contract.id," +
            "sh.contractor.id," +
            "sh.company.id," +
            "sh.sum," +
            "sh.paid," +
            "sh.isSent," +
            "sh.isPrinted," +
            "sh.comment," +
            "sh.consignee.id," +
            "sh.carrier.id," +
            "sh.isPaid," +
            "sh.deliveryAddress)" +
            " FROM Shipment sh WHERE sh.id = :id")
    ShipmentDto getById(@Param("id") Long id);


}
