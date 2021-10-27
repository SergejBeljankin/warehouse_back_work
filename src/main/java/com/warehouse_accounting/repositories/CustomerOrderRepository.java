package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.CustomerOrder;
import com.warehouse_accounting.models.dto.CustomerOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.CustomerOrderDto(" +
            "customer_order.id," +
            "customer_order.date," +
            "warehouse.id," +
            "contract.id," +
            "company.id," +
            "contractor.id," +
            "customer_order.sum," +
            "customer_order.comment," +
            "customer_order.isPaid)" +
            "FROM CustomerOrder customer_order " +
            "left join Warehouse warehouse on (customer_order.warehouse.id = warehouse.id)" +
            "left join Contract contract on (customer_order.contract.id = contract.id)" +
            "left join Contractor contractor on (customer_order.contractor.id = contractor.id)" +
            "left join Company company on (customer_order.company.id = company.id)")
    List<CustomerOrderDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CustomerOrderDto(" +
            "customer_order.id," +
            "customer_order.date," +
            "warehouse.id," +
            "contract.id," +
            "company.id," +
            "contractor.id," +
            "customer_order.sum," +
            "customer_order.comment," +
            "customer_order.isPaid)" +
            "FROM CustomerOrder customer_order " +
            "left join Warehouse warehouse on (customer_order.warehouse.id = warehouse.id)" +
            "left join Contract contract on (customer_order.contract.id = contract.id)" +
            "left join Contractor contractor on (customer_order.contractor.id = contractor.id)" +
            "left join Company company on (customer_order.company.id = company.id)" +
            "WHERE customer_order.id = :id")
    CustomerOrderDto getById(@Param("id") Long id);
}

