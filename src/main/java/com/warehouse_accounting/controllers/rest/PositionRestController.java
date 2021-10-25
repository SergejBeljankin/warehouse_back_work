package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.repositories.PositionRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.PositionService;
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
@RequestMapping("/api/positions")
@Api(tags = "Position Rest Controller")
@Tag(name = "Position Rest Controller", description = "CRUD операции с объектами")
public class PositionRestController {

    private final PositionService service;
    private final CheckEntityService checkEntityService;
    private final PositionRepository repository;

    public PositionRestController(PositionService service, CheckEntityService checkEntityService, PositionRepository repository) {
        this.service = service;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список PositionDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка PositionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<PositionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает PositionDto по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение PositionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<PositionDto> getById(@ApiParam(name = "id", value = "id для получения PositionDto",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Position");
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает PositionDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание PositionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "PositionDto", value = "объект PositionDto для создания",
            required = true) @RequestBody PositionDto positionDto) {
        service.create(positionDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет PositionDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление PositionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "PositionDto", value = "объект PositionDto для обновления",
            required = true) @RequestBody PositionDto positionDto) {
        checkEntityService.checkExist(positionDto.getId(), repository, "Position");
        service.update(positionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет PositionDto по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление PositionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id для удаления PositionDto",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Position");
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{value}")
    @ApiOperation(value = "Возвращает список PositionDto содержащее в полях value")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка PositionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<PositionDto>> searchPositionDto(@ApiParam(name = "value", value = "Значение для поиска в PositionDto",
            required = true) @PathVariable("value") String value) {
        return ResponseEntity.ok(service.getAllByLikeQuery(value));
    }
}
