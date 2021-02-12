package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.services.interfaces.PositionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@Tag(name = "Position Rest Controller", description = "CRUD операции с объектами Position")
public class PositionController {

    private final PositionService service;

    public PositionController(PositionService service) {
        this.service = service;
    }

    @GetMapping
    @Tag(name = "Position Rest Controller")
    @ApiOperation(value = "getAll", notes = "Получение списка всех Position")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Position"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public List<PositionDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Tag(name = "Position Rest Controller")
    @ApiOperation(value = "getById", notes = "Получение Position")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Position"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public PositionDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Tag(name = "Position Rest Controller")
    @ApiOperation(value = "create", notes = "Создание Position")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Position"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void create(PositionDto dto) {
        service.create(dto);
    }

    @PutMapping
    @Tag(name = "Position Rest Controller")
    @ApiOperation(value = "update", notes = "Изменение Position")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное изменение Position"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void update(PositionDto dto) {
        service.update(dto);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Position Rest Controller")
    @ApiOperation(value = "deleteById", notes = "Удаление Position")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Position"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}



