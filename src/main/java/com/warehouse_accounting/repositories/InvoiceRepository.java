package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.Invoice;
import com.warehouse_accounting.models.dto.InvoiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceDto(" +
            "i.id, " +
            "i.number, " +
            "i.invoiceDateTime, " +
            "i.type, " +
            "i.isPosted, " +
            "e.id, " +
            "e.lastName," +
            "e.firstName," +
            "c.id," +
            "c.name, " +
            "p.id," +
            "p.name, " +
            "w.id," +
            "w.name, " +
            "i.comment," +
            "con.id, " +
            "con.name, " +
            "cont.id," +
            "cont.number, " +
            "cont.contractDate)" +
            "FROM Invoice i " +
            "LEFT JOIN Employee e ON (i.invoiceAuthor.id = e.id)" +
            "LEFT JOIN Company c ON (i.company.id = c.id)" +
            "LEFT JOIN Project p ON (i.project.id = p.id)" +
            "LEFT JOIN Warehouse w ON (i.warehouse.id = w.id)" +
            "LEFT JOIN Contractor con ON (i.contractor.id = con.id)" +
            "LEFT JOIN Contract cont ON (i.contract.id = cont.id)")
    List<InvoiceDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceDto(" +
            "i.id, " +
            "i.number, " +
            "i.invoiceDateTime, " +
            "i.type, " +
            "i.isPosted, " +
            "e.id, " +
            "e.lastName," +
            "e.firstName," +
            "c.id," +
            "c.name, " +
            "p.id," +
            "p.name, " +
            "w.id," +
            "w.name, " +
            "i.comment," +
            "con.id, " +
            "con.name, " +
            "cont.id," +
            "cont.number, " +
            "cont.contractDate)" +
            "FROM Invoice i " +
            "LEFT JOIN Employee e ON (i.invoiceAuthor.id = e.id)" +
            "LEFT JOIN Company c ON (i.company.id = c.id)" +
            "LEFT JOIN Project p ON (i.project.id = p.id)" +
            "LEFT JOIN Warehouse w ON (i.warehouse.id = w.id)" +
            "LEFT JOIN Contractor con ON (i.contractor.id = con.id)" +
            "LEFT JOIN Contract cont ON (i.contract.id = cont.id)" +
            "WHERE i.id = :id")
    InvoiceDto getById(@Param("id") Long id);

}
