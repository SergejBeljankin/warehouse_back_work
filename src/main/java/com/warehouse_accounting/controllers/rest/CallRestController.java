package com.warehouse_accounting.controllers.rest;


import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.services.interfaces.CallService;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/calls")
@Api(tags = "Contractor Rest Controller")
@Tag(name = "Contractor Rest Controller", description = "CRUD операции с объектами")
public class CallRestController {
    private final CallService callService;
    private final CheckEntityService checkEntityService;

    @Autowired
    public CallRestController(CallService callService, CheckEntityService checkEntityService) {
        this.callService = callService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все параметры рассчитываемого объекта", notes = "Возвращает список Call",
            response = CallDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа CallDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<CallDto>> getAll() {
        return ResponseEntity.ok(callService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id", notes = "Возвращает CallDto",
            response = CallDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение CallDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<CallDto> getById(@ApiParam(name = "id", value = "Id нужного CallDto", required = true)
                                                 @PathVariable("id") Long id) {
        checkEntityService.checkExistCallById(id);
        return ResponseEntity.ok(callService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание CallDto",
                    response = CallDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "CallDto", value = "Объект CallDto для создания",
            required = true) @RequestBody CallDto callDto) {
        callService.create(callDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление CallDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "CallDto", value = "Объект CallDto для обновления",
            required = true) @RequestBody CallDto callDto) {
        checkEntityService.checkExistCallById(callDto.getId());
        callService.update(callDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет параметр рассчитываемого объекта с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление CallDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id CallDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistCallById(id);
        callService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
