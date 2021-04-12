package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.WarehouseService;
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
@RequestMapping("/api/warehouses")
@Api(tags = "Warehouse Rest Controller")
@Tag(name = "Warehouse Rest Controller", description = "CRUD операции с объектами")
public class WarehouseRestController{

    private final WarehouseService warehouseService;
    private final CheckEntityService checkEntityService;

    public WarehouseRestController(WarehouseService warehouseService, 
                                   CheckEntityService checkEntityService) {
        this.warehouseService = warehouseService;
        this.checkEntityService = checkEntityService;
    }


    @GetMapping()
    @ApiOperation(value = "Возвращает список объектов WarehouseDto", notes = "Возвращает List WarehouseDto", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<WarehouseDto>> getAll() {
        return ResponseEntity.ok(warehouseService.getAll());
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает объект WarehouseDto", notes = "Возвращает объект WarehouseDto по его ID", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<WarehouseDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistWarehouseById(id);
        return ResponseEntity.ok(warehouseService.getById(id));
    }


    @PostMapping()
    @ApiOperation(value = "Создает объект WarehouseDto", notes = "Создает объект WarehouseDto в программе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "WarehouseDto", value = "Объект WarehouseDto который нужно сохранить в программе")
            @RequestBody WarehouseDto warehouseDto) {
        warehouseService.create(warehouseDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping()
    @ApiOperation(value = "Обновляет объект WarehouseDto", notes = "Обновляет объект WarehouseDto в программе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "WarehouseDto", value = "Объект WarehouseDto который нужно обновить в программе")
            @RequestBody WarehouseDto warehouseDto) {
        checkEntityService.checkExistWarehouseById(warehouseDto.getId());
        warehouseService.update(warehouseDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет объект WarehouseDto", notes = "Удаляет объект WarehouseDto по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> delete(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistWarehouseById(id);
        warehouseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


