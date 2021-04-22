package com.warehouse_accounting.controllers.rest;


import com.warehouse_accounting.models.dto.AdjustmentDto;
import com.warehouse_accounting.services.interfaces.AdjustmentService;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/api/adjustments")
@Api(tags = "Adjustment Rest Controller")
//@Tag(name = "Adjustment Rest Controller", description = "CRUD операции с объектами")
public class AdjustmentRestController {
    private final AdjustmentService adjustmentService;
    private final CheckEntityService checkEntityService;

    public AdjustmentRestController(AdjustmentService adjustmentService, CheckEntityService checkEntityService) {
        this.adjustmentService = adjustmentService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все корректировки", notes = "Возвращает List всех корректировок",
            response = AdjustmentDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа AdjustmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<AdjustmentDto>> getAll() {
        return ResponseEntity.ok(adjustmentService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id", notes = "Возвращает AdjustmentDto",
            response = AdjustmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение AdjustmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<AdjustmentDto> getById(@ApiParam(name = "id", value = "Id нужного AdjustmentDto", required = true)
                                           @PathVariable("id") Long id) {
        checkEntityService.checkExistAdjustmentById(id);
        return ResponseEntity.ok(adjustmentService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Сохранение коректировки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание AdjustmentDto",
                    response = AdjustmentDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "AdjustmentDto", value = "Объект AdjustmentDto для создания",
            required = true) @RequestBody AdjustmentDto adjustmentDto) {
        adjustmentService.create(adjustmentDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление AdjustmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "AdjustmentDto", value = "Объект AdjustmentDto для обновления",
            required = true) @RequestBody AdjustmentDto adjustmentDto) {
        checkEntityService.checkExistAdjustmentById(adjustmentDto.getId());
        adjustmentService.update(adjustmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет коректировку с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление AdjustmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id AdjustmentDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistAdjustmentById(id);
        adjustmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
