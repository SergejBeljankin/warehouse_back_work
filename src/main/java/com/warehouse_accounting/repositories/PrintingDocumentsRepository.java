package com.warehouse_accounting.repositories;

import com.warehouse_accounting.models.dto.PrintingDocumentsDto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PrintingDocumentsRepository {
    @Query("SELECT NEW com.warehouse_accounting.models.dto.PrintingDocumentsDto("+

            "pd.id, " +
            "pd.printDoc" +
            ")"+
            "FROM  PrintingDocuments  pd")
    List<PrintingDocumentsDto> getAll();

    @Query("SELECT new com.warehouse_accounting.models.dto.PrintingDocumentsDto(" +
            "pd.id, " +
            "pd.printDoc" +
            ")"+
            "FROM  PrintingDocuments  pd WHERE pd.id=:id")
    PrintingDocumentsDto getById(@Param("id") Long id);
}
