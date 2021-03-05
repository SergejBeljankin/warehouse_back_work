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

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceDto" +
            "(i.id, " +
            "i.number, " +
            "i.invoiceDateTime, " +
            "i.type.name(), " +
            "i.isPosted, " +
            "i.invoiceAuthor.id, " +
            "i.company.id, " +
            "i.project.id, " +
            "i.warehouse.id, " +
            "i.comment, " +
            "i.contractor.id, " +
            "i.contract.id)" +
            "FROM Invoice i")
    List<InvoiceDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceDto(" +
            "(i.id, " +
            "i.number, " +
            "i.invoiceDateTime, " +
            "i.type.name(), " +
            "i.isPosted, " +
            "i.invoiceAuthor.id, " +
            "i.company.id, " +
            "i.project.id, " +
            "i.warehouse.id, " +
            "i.comment, " +
            "i.contractor.id, " +
            "i.contract.id)" +
            "FROM Invoice i WHERE i.id = :id")
    InvoiceDto getById(@Param("id") Long id);

}
