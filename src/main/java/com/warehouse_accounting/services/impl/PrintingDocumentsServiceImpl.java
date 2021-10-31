package com.warehouse_accounting.services.impl;

import com.warehouse_accounting.models.dto.PrintingDocumentsDto;
import com.warehouse_accounting.repositories.PrintingDocumentsRepository;
import com.warehouse_accounting.services.interfaces.PrintingDocumentsService;
import com.warehouse_accounting.util.ConverterDto;
import java.util.List;
import javax.transaction.Transactional;
import jdk.dynalink.linker.ConversionComparator;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PrintingDocumentsServiceImpl implements PrintingDocumentsService {
    private final PrintingDocumentsRepository printingDocumentsRepository;

    public PrintingDocumentsServiceImpl(PrintingDocumentsRepository printingDocumentsRepository) {
        this.printingDocumentsRepository = printingDocumentsRepository;
    }

    @Override
    public List<PrintingDocumentsDto> getAll() {
        return printingDocumentsRepository.getAll();
    }

    @Override
    public PrintingDocumentsDto getById(Long id) {
        return printingDocumentsRepository.getById(id);
    }

    @Override
    public void create(PrintingDocumentsDto printingDocumentsDto) {
        printingDocumentsRepository.save(ConverterDto.convertToModel(printingDocumentsDto));

    }

    @Override
    public void update(PrintingDocumentsDto printingDocumentsDto) {
        printingDocumentsRepository.save(ConverterDto.convertToModel(printingDocumentsDto));
    }

    @Override
    public void deleteById(Long id) {
        printingDocumentsRepository.deleteById(id);
    }
}
