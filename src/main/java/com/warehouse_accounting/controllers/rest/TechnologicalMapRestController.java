package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapService;
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

/**
 * This class implements API for working with {@link com.warehouse_accounting.models.TechnologicalMap}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 30.03.2021
 */
@RestController
@RequestMapping("/api/technological_map")
@Api(tags = "TechnologicalMap Rest Controller")
@Tag(name = "TechnologicalMap Rest Controller", description = "API for doing some CRUD with TechnologicalMap")
public class TechnologicalMapRestController {
    private final TechnologicalMapService technologicalMapService;
    private final CheckEntityService checkEntityService;

    public TechnologicalMapRestController(TechnologicalMapService technologicalMapService,
                                          CheckEntityService checkEntityService) {
        this.technologicalMapService = technologicalMapService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "return List<TechnologicalMapDto>",
            response = TechnologicalMapDto.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка TechnologicalMap"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<TechnologicalMapDto>> getAll() {
        return ResponseEntity.ok(technologicalMapService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "getById",
            notes = "return TechnologicalMap",
            response = TechnologicalMapDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TechnologicalMap"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TechnologicalMapDto> getById(
            @ApiParam(name = "id", value = "id для получения TechnologicalMap", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTechnologicalMapById(id);
        return ResponseEntity.ok(technologicalMapService.getById(id));
    }

    @PostMapping
    @ApiOperation(
            value = "create",
            notes = "Create TechnologicalMap")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TechnologicalMap"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
            @ApiParam(name = "TechnologicalMapDto", value = "TechnologicalMapDto for create TechnologicalMap", required = true)
            @RequestBody TechnologicalMapDto technologicalMapDto) {
        technologicalMapService.create(technologicalMapDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(
            value = "update",
            notes = "Update TechnologicalMap")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное изменение TechnologicalMap"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
            @ApiParam(name = "TechnologicalMapDto", value = "TechnologicalMapDto for update TechnologicalMap", required = true)
            @RequestBody TechnologicalMapDto technologicalMapDto) {
        checkEntityService.checkExistTechnologicalMapById(technologicalMapDto.getId());
        technologicalMapService.update(technologicalMapDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "deleteById",
            notes = "Deleting a TechnologicalMap by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TechnologicalMap"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "id удаляемого TechnologicalMap", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTechnologicalMapById(id);
        technologicalMapService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
