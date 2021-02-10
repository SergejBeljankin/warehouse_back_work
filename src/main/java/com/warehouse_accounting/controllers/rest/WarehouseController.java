package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.services.interfaces.WarehouseService;
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
@RequestMapping("/api/warehouse")
@Tag(name = "WarehouseDto Rest Controller", description = "CRUD операции с объектами")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }


    @GetMapping()
    @Tag(name = "WarehouseDto Rest Controller")
    @ApiOperation(value = "Возвращает список объектов WarehouseDto", notes = "Возвращает List WarehouseDto", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> getAll() {
        List<WarehouseDto> all = warehouseService.getAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping(value = "/{id}")
    @Tag(name = "WarehouseDto Rest Controller")
    @ApiOperation(value = "Возвращает объект WarehouseDto", notes = "Возвращает объект WarehouseDto по его ID", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") long id) {
        WarehouseDto warehouseDto = warehouseService.getById(id);
        return ResponseEntity.ok(warehouseDto);
    }


    @PostMapping()
    @Tag(name = "WarehouseDto Rest Controller")
    @ApiOperation(value = "Создает объект WarehouseDto", notes = "Создает объект WarehouseDto в программе", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "WarehouseDto", value = "Объект WarehouseDto который нужно сохранить в программе")
            @RequestBody WarehouseDto warehouseDto) {
        warehouseService.create(warehouseDto);
        return ResponseEntity.ok(warehouseDto);
    }


    @PutMapping()
    @Tag(name = "WarehouseDto Rest Controller")
    @ApiOperation(value = "Обновляет объект WarehouseDto", notes = "Обновляем объект WarehouseDto в программе", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "WarehouseDto", value = "Объект WarehouseDto который нужно обновить в программе")
            @RequestBody WarehouseDto warehouseDto) {
        warehouseService.update(warehouseDto);
        return ResponseEntity.ok(warehouseDto);
    }


    @DeleteMapping(value = "/{id}")
    @Tag(name = "WarehouseDto Rest Controller")
    @ApiOperation(value = "Удаляет объект WarehouseDto", notes = "Удаляет объект WarehouseDto по его ID", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> delete(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        warehouseService.deleteById(id);
        return ResponseEntity.ok().body("User deleted successfully");
    }
}


