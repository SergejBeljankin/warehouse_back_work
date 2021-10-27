package com.warehouse_accounting.services.interfaces;

import com.warehouse_accounting.models.dto.PrintingDocumentsDto;
import java.util.List;

public interface PrintingDocumentsService {
    List<PrintingDocumentsDto> getAll();

    PrintingDocumentsDto getById(Long id);

    void create(PrintingDocumentsDto printingDocumentsDto);

    void update(PrintingDocumentsDto printingDocumentsDto);

    void deleteById(Long id);
}
