package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.AttributeOfCalculationObjectService;
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
@RequestMapping("/api/attribute_of_calculation_objects")
@Api(tags = "AttributeOfCalculationObject Rest Controller")
@Tag(name = "AttributeOfCalculationObject Rest Controller", description = "CRUD операции с объектами")
public class AttributeOfCalculationObjectRestController {
    private final AttributeOfCalculationObjectService attributeOfCalculationObjectService;
    private final CheckEntityService checkEntityService;

    public AttributeOfCalculationObjectRestController(AttributeOfCalculationObjectService attributeOfCalculationObjectService, CheckEntityService checkEntityService) {
        this.attributeOfCalculationObjectService = attributeOfCalculationObjectService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все параметры рассчитываемого объекта", notes = "Возвращает список AttributeOfCalculationObjectDto",
            response = AttributeOfCalculationObjectDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа AttributeOfCalculationObjectDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<AttributeOfCalculationObjectDto>> getAll() {
        return ResponseEntity.ok(attributeOfCalculationObjectService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id", notes = "Возвращает AttributeOfCalculationObjectDto",
            response = AttributeOfCalculationObjectDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение AttributeOfCalculationObjectDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<AttributeOfCalculationObjectDto> getById(@ApiParam(name = "id", value = "Id нужного AttributeOfCalculationObjectDto", required = true)
                                            @PathVariable("id") Long id) {
        checkEntityService.checkExistAttributeOfCalculationObjectById(id);
        return ResponseEntity.ok(attributeOfCalculationObjectService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание AttributeOfCalculationObjectDto",
                    response = AttributeOfCalculationObjectDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "AttributeOfCalculationObjectDto", value = "Объект AttributeOfCalculationObjectDto для создания",
            required = true) @RequestBody AttributeOfCalculationObjectDto attributeOfCalculationObjectDto) {
        attributeOfCalculationObjectService.create(attributeOfCalculationObjectDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление AttributeOfCalculationObjectDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "AttributeOfCalculationObjectDto", value = "Объект AttributeOfCalculationObjectDto для обновления",
            required = true) @RequestBody AttributeOfCalculationObjectDto attributeOfCalculationObjectDto) {
        checkEntityService.checkExistAttributeOfCalculationObjectById(attributeOfCalculationObjectDto.getId());
        attributeOfCalculationObjectService.update(attributeOfCalculationObjectDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет параметр рассчитываемого объекта с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление AttributeOfCalculationObjectDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id AttributeOfCalculationObjectDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistAttributeOfCalculationObjectById(id);
        attributeOfCalculationObjectService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
