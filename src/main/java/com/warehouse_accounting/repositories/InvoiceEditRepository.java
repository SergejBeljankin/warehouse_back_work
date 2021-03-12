package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.InvoiceEdit;
import com.warehouse_accounting.models.dto.InvoiceEditDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceEditRepository extends JpaRepository<InvoiceEdit, Long> {

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceEditDto(" +
            "ie.id," +
            "ie.editAuthor.id," +
            "ie.dateTime," +
            "ie.field," +
            "ie.before," +
            "ie.after)" +
            "FROM InvoiceEdit ie")
    List<InvoiceEditDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceEditDto(" +
            "ie.id," +
            "ie.editAuthor.id," +
            "ie.dateTime," +
            "ie.field," +
            "ie.before," +
            "ie.after)" +
            "FROM InvoiceEdit ie WHERE ie.id = :id")
    InvoiceEditDto getById(@Param("id") Long id);

    @Query("SELECT i.edits FROM Invoice i WHERE i.id = :id")
    List<InvoiceEdit> getListInvoiceEditById(@Param("id") Long id);
}
