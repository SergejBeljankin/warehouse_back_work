package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.CustomerReturns;
import com.warehouse_accounting.models.dto.CustomerReturnsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface CustomerReturnsRepository extends JpaRepository<CustomerReturns, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.CustomerReturnsDto(" +
            "c.id," +
            "c.date," +
            "c.sum," +
            "c.isPaid," +
            "c.isSend," +
            "c.comment," +
            "warehouse.id," +
            "contract.id," +
            "company.id," +
            "contractor.id)" +
            "FROM CustomerReturns c " +
            "left join Warehouse warehouse on (c.warehouse.id = warehouse.id)" +
            "left join Contract contract on (c.contract.id = contract.id)" +
            "left join Contractor contractor on (c.contractor.id = contractor.id)" +
            "left join Company company on (c.company.id = company.id)")
    List<CustomerReturnsDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.CustomerReturnsDto(" +
            "c.id," +
            "c.date," +
            "c.sum," +
            "c.isPaid," +
            "c.isSend," +
            "c.comment," +
            "warehouse.id," +
            "contract.id," +
            "company.id," +
            "contractor.id)" +
            "FROM CustomerReturns c " +
            "left join Warehouse warehouse on (c.warehouse.id = warehouse.id)" +
            "left join Contract contract on (c.contract.id = contract.id)" +
            "left join Contractor contractor on (c.contractor.id = contractor.id)" +
            "left join Company company on (c.company.id = company.id)" +
            "WHERE c.id = :id")
    CustomerReturnsDto getById(@Param("id") Long id);
}
