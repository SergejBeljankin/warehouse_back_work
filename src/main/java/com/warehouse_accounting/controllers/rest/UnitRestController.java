package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.services.interfaces.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/api")
@Api(value = "Unit", tags = "unit")
public class UnitRestController {

    private final UnitService unitService;

    public UnitRestController(UnitService unitService) {
        this.unitService = unitService;
    }

    @ApiOperation(
            value = "Получить все подразделения",
            notes = "Возвращает список всех Unit",
            response = UnitDto.class,
            responseContainer = "List",
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получения списка подразделений", response = UnitDto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Подразделений не существует"),
            @ApiResponse(code = 500, message = "Веутренняя ошибка сервера")}
    )
    @GetMapping("/units")
    public List<UnitDto> getAll() {
        return unitService.getAll();
    }

    @ApiOperation(
            value = "Получить подразделение по id",
            notes = "Возвращает Unit по id",
            response = UnitDto.class,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение подразделения", response = UnitDto.class),
            @ApiResponse(code = 404, message = "Подразделения не существует"),
            @ApiResponse(code = 500, message = "Веутренняя ошибка сервера")}
    )
    @GetMapping("/units/{id}")
    public UnitDto getById(@ApiParam(name = "id", value = "id нужного подразделения", required = true) @PathVariable("id") Long id) {
        return unitService.getById(id);
    }

    @ApiOperation(
            value = "Создать новое подразделение",
            notes = "Создает новый Unit",
            response = UnitDto.class,
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание подразделения", response = UnitDto.class),
            @ApiResponse(code = 404, message = "Не удалось создать подразделение"),
            @ApiResponse(code = 500, message = "Веутренняя ошибка сервера")}
    )
    @PostMapping("/units")
    public UnitDto create(@ApiParam(name = "UnitDto", value = "UnitDto для создания подразделения", required = true) @RequestBody UnitDto unitDto) {
        unitService.create(unitDto);
        return unitService.getById(unitDto.getId());
    }

    @ApiOperation(
            value = "Обновить подразделение",
            notes = "Обновляет Unit",
            response = UnitDto.class,
            httpMethod = "PUT"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление подразделения", response = UnitDto.class),
            @ApiResponse(code = 404, message = "Подразделения не существует"),
            @ApiResponse(code = 500, message = "Веутренняя ошибка сервера")}
    )
    @PutMapping("/units")
    public UnitDto update(@ApiParam(name = "UnitDto", value = "UnitDto для обновления подразделения", required = true) @RequestBody UnitDto unitDto) {
        unitService.update(unitDto);
        return unitService.getById(unitDto.getId());
    }

    @ApiOperation(
            value = "Удалить подразделение",
            notes = "Удаляет Unit",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление подразделения"),
            @ApiResponse(code = 404, message = "Подразделения не существует"),
            @ApiResponse(code = 500, message = "Веутренняя ошибка сервера")}
    )
    @DeleteMapping("/units/{id}")
    public void deleteById(@ApiParam(name = "id", value = "id удаляемого подразделения", required = true) @PathVariable("id") Long id) {
        unitService.deleteById(id);
    }
}
