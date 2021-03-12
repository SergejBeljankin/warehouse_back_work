package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.InvoiceProduct;
import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.models.dto.InvoiceProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long> {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceProductDto(" +
            "i.id, " +
            "i.invoice.id, " +
            "i.product.id, " +
            "i.count, " +
            "i.price, " +
            "i.sum)" +
            "FROM InvoiceProduct i")
    List<InvoiceProductDto> getAll();

    @Query("SELECT NEW com.warehouse_accounting.models.dto.InvoiceProductDto(" +
            "i.id, " +
            "i.invoice.id, " +
            "i.product.id, " +
            "i.count, " +
            "i.price, " +
            "i.sum)" +
            "FROM InvoiceProduct i WHERE i.id = :id")
    InvoiceProductDto getById(@Param("id") Long id);


    @Query("SELECT i.invoiceProducts FROM Invoice i WHERE i.id = :id")
    List<InvoiceProduct> getListInvoiceProductById(@Param("id") Long id);
}
