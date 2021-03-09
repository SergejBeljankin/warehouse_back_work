package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.InvoiceDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.InvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@Api(tags = "Invoice Rest Controller")
@Tag(name = "Invoice Rest Controller", description = "API для работы с накладными")
public class InvoiceRestController {

    private final InvoiceService invoiceService;
    private final CheckEntityService checkEntityService;

    public InvoiceRestController(InvoiceService invoiceService, CheckEntityService checkEntityService) {
        this.invoiceService = invoiceService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает из базы данных список всех накладных", notes = "Возвращает из базы данных список всех накладных", response = InvoiceDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список накладных успешно получен"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден")
    })
    public ResponseEntity<List<InvoiceDto>> getAll() {
        return ResponseEntity.ok(invoiceService.getAll());
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Накладная успешно получена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден")
    })
    public ResponseEntity<InvoiceDto> getById(
            @ApiParam(name = "id", value = "Значение поля id объекта, который требуется получить", example = "1", required = true)
            @PathVariable Long id) {
        checkEntityService.checkExistInvoiceById(id);
        return ResponseEntity.ok(invoiceService.getById(id));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Накладная успешно создана"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден")
    })
    public ResponseEntity<?> create(
            @ApiParam(name = "invoiceDto", value = "Накладная (Объект InvoiceDto), которую требуется сохранить в базе данных.")
            @RequestBody InvoiceDto invoiceDto){
        checkEntityService.checkExistInvoiceById(invoiceDto.getId());
        invoiceService.create(invoiceDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Накладная успешно обновлена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден")
    })
    public ResponseEntity<?> update(
            @ApiParam(name = "invoiceDto", value = "Накладная (Объект InvoiceDto), которую требуется обновить в базе данных.")
            @RequestBody InvoiceDto invoiceDto){
        checkEntityService.checkExistInvoiceById(invoiceDto.getId());
        invoiceService.create(invoiceDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Накладная успешно удалена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден")
    })
    public ResponseEntity<?> delete(
            @ApiParam(name = "id", value = "Значение поля id объекта, который требуется удалить", example = "1", required = true)
            @PathVariable Long id){
        checkEntityService.checkExistInvoiceById(id);
        invoiceService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
