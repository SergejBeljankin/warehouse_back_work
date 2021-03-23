package com.warehouse_accounting.models.dto;

import com.warehouse_accounting.models.TypeOfInvoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * ИНФОРМАЦИЯ ДЛЯ ФРОНТ-РАЗРАБОТЧИКА
 * Для снижения количества запросов к базе при передаче на фронт объектов типа Invoice
 * класс InvoiceDto реконструирован: там, где это было возможно, вместо полей-объектов
 * используются поля-примитивы или строки.
 * Ваша задача - при разработке фронтовой части Invoice собрать информацию для полей
 * "Создан" и "Договор", сконкатенировав поля InvoiceDto следующим образом:
 *
 * "Создан":
 * invoiceAuthorLastName + пробел + первая буква invoiceAuthorFirstName + точка.
 * "Договор":
 * "№" + contractNumber + пробел + "от" + пробел + contractDate
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Long id;
    private String number;
    private LocalDateTime invoiceDateTime;
    private String type;
    private boolean isPosted;

    private Long invoiceAuthorId;
    private String invoiceAuthorLastName;
    private String invoiceAuthorFirstName;

    private Long companyId;
    private String companyName;

    private Long projectId;
    private String projectName;

    private Long warehouseId;
    private String warehouseName;

    private List<InvoiceProductDto> productDtos = new ArrayList<>();
    private String comment;

    private Long contractorId;
    private String contractorName;

    private Long contractId;
    private String contractNumber;
    private LocalDate contractDate;

    private List<InvoiceEditDto> edits = new ArrayList<>();

    public InvoiceDto(Long id,
                      String number,
                      LocalDateTime invoiceDateTime,
                      TypeOfInvoice type,
                      boolean isPosted,
                      Long invoiceAuthorId,
                      String invoiceAuthorLastName,
                      String invoiceAuthorFirstName,
                      Long companyId,
                      String companyName,
                      Long projectId,
                      String projectName,
                      Long warehouseId,
                      String warehouseName,
                      String comment,
                      Long contractorId,
                      String contractorName,
                      Long contractId,
                      String contractNumber,
                      LocalDate contractDate) {
        this.id = id;
        this.number = number;
        this.invoiceDateTime = invoiceDateTime;
        this.type = type.name();
        this.isPosted = isPosted;
        this.invoiceAuthorId = invoiceAuthorId;
        this.invoiceAuthorLastName = invoiceAuthorLastName;
        this.invoiceAuthorFirstName = invoiceAuthorFirstName;
        this.companyId = companyId;
        this.companyName = companyName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.comment = comment;
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.contractId = contractId;
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
    }
}
