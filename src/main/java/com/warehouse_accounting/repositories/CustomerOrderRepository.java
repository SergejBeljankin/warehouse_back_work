package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.CustomerOrder;
import com.warehouse_accounting.models.dto.CustomerOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.CustomerOrderDto(" +
            "co.id," +
            "co.date," +
            "co.warehouse.id," +
            "co.contract.id," +
            "co.contractor.id," +
            "co.company.id," +
            "co.sum," +
            "co.comment," +
            "co.isPaid)" +
            " FROM CustomerOrder co")
    List<CustomerOrderDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CustomerOrderDto(" +
            "co.id," +
            "co.date," +
            "co.warehouse.id," +
            "co.contract.id," +
            "co.contractor.id," +
            "co.company.id," +
            "co.sum," +
            "co.comment," +
            "co.isPaid)" +
            " FROM CustomerOrder co WHERE co.id = :id")
    CustomerOrderDto getById(@Param("id") Long id);
}

