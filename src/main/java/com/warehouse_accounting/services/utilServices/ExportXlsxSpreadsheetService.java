package com.warehouse_accounting.services.utilServices;

import com.warehouse_accounting.models.dto.MovementDto;
import com.warehouse_accounting.repositories.MovementRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

@Service
@Log4j2
public class ExportXlsxSpreadsheetService implements ExportSpreadsheetService {
    private final MovementRepository movementRepository;

    private XSSFWorkbook workbook = new XSSFWorkbook();
    private XSSFSheet sheet = workbook.createSheet();

    public ExportXlsxSpreadsheetService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    // общий метод для заполнения шапки таблицы
    public <T> InputStreamResource getWorkbook(Class<T> targetClass) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Row headerRow = sheet.createRow(0);
        int cellCounter = 0;
        for (Field field : targetClass.getDeclaredFields()) {
            headerRow.createCell(cellCounter).setCellValue(field.getName());
            cellCounter++;
        }
        defineClassAndCombineSheet(targetClass);
        try {
            workbook.write(byteArrayOutputStream);
        } catch (IOException e) {
            log.error("Записать книгу в ByteArrayInputStream не удалось", e);
        }
        return new InputStreamResource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }

    // метод для определения метода заполнения таблицы в зависимости от целевого класса
    private <T> void defineClassAndCombineSheet(Class<T> targetClass) {
        switch (targetClass.getSimpleName()) {
            case "MovementDto":
                combineSheet(MovementDto.class);
                break;
            case "Product":
                //TODO написать метод для наполнения таблицы Product
                break;
        }
    }

    // метод для сборки таблицы конкретно класса Movement
    private void combineSheet(Class<MovementDto> movementDtoClass) {
        int rowCounter = 0;
        for (MovementDto movementDto : movementRepository.getAll()) {
            Row row = sheet.createRow(++rowCounter);
            row.createCell(0).setCellValue(movementDto.getId());
            row.createCell(1).setCellValue(movementDto.getDateTime());
            row.createCell(2).setCellValue(movementDto.getWarehouseFrom().getId());
            row.createCell(3).setCellValue(movementDto.getWarehouseTo().getId());
            row.createCell(4).setCellValue(movementDto.getCompany().getId());
            row.createCell(5).setCellValue(movementDto.getSum().toString());
            row.createCell(6).setCellValue(movementDto.isMoved());
            row.createCell(7).setCellValue(movementDto.isPrinted());
            row.createCell(7).setCellValue(movementDto.getComment());
        }
    }
}
