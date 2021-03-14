package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.InvoiceProductDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.InvoiceProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/api/invoice_products")
@Api(tags = "InvoiceProduct Rest Controller")
@Tag(name = "InvoiceProduct Rest Controller", description = "CRUD операции с InvoiceProduct")
public class InvoiceProductRestController {

    private final InvoiceProductService invoiceProductService;
    private final CheckEntityService checkEntityService;

    public InvoiceProductRestController(InvoiceProductService invoiceProductService, CheckEntityService checkEntityService) {
        this.invoiceProductService = invoiceProductService;
        this.checkEntityService = checkEntityService;
    }
    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех InvoiceProduct",
            response = InvoiceProductDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка InvoiceProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<InvoiceProductDto>> getAll(){
        return ResponseEntity.ok(invoiceProductService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "getById",
            notes = "Получение InvoiceProduct по id",
            response = InvoiceProductDto.class

    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение InvoiceProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<InvoiceProductDto> getById(@ApiParam(name = "id", value = "id для получения InvoiceProduct",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExistInvoiceProductById(id);
        return ResponseEntity.ok(invoiceProductService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового InvoiceProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание InvoiceProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "InvoiceProductDto", value = "InvoiceProductDto для создания InvoiceProduct",
            required = true)@RequestBody InvoiceProductDto invoiceProductDto){
        invoiceProductService.create(invoiceProductDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление InvoiceProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление InvoiceProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "InvoiceProductDto", value = "InvoiceProductDto для обновления InvoiceProduct",
            required = true)@RequestBody InvoiceProductDto invoiceProductDto) {
        checkEntityService.checkExistInvoiceProductById(invoiceProductDto.getId());
        invoiceProductService.update(invoiceProductDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление InvoiceProduct по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление InvoiceProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id удаляемого InvoiceProduct",
            required = true)@PathVariable("id") Long id) {
        checkEntityService.checkExistInvoiceProductById(id);
        invoiceProductService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
