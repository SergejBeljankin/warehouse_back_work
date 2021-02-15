package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.services.interfaces.UnitService;
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
@RequestMapping("/api/units")
@Api(tags = "Unit Rest Controller")
@Tag(name = "Unit Rest Controller", description = "CRUD операции с Unit")
public class UnitRestController {

    private final UnitService unitService;

    public UnitRestController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех Unit",
            response = UnitDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Unit"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<UnitDto>> getAll() {
        return ResponseEntity.ok(unitService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Unit по id", response = UnitDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Unit"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<UnitDto> getById(@ApiParam(name = "id", value = "id для получения Unit", required = true) @PathVariable("id") Long id) {
        return ResponseEntity.ok(unitService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового Unit")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Unit"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "UnitDto", value = "UnitDto для создания Unit", required = true) @RequestBody UnitDto unitDto) {
        unitService.create(unitDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление Unit")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление Unit"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "UnitDto", value = "UnitDto для обновления Unit", required = true) @RequestBody UnitDto unitDto) {
        unitService.update(unitDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Unit по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Unit"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id удаляемого Unit", required = true) @PathVariable("id") Long id) {
        unitService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
