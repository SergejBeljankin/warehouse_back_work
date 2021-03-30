package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapGroupService;
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
 * This class implements API for working with {@link com.warehouse_accounting.models.TechnologicalMapGroup}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 30.03.2021
 */
@RestController
@RequestMapping("/api/technological_map_group")
@Api(tags = "TechnologicalMapGroup Rest Controller")
@Tag(name = "TechnologicalMapGroup Rest Controller", description = "API for doing some CRUD with TechnologicalMapGroup")
public class TechnologicalMapGroupRestController {
    private final TechnologicalMapGroupService technologicalMapGroupService;
    private final CheckEntityService checkEntityService;

    public TechnologicalMapGroupRestController(TechnologicalMapGroupService technologicalMapGroupService,
                                               CheckEntityService checkEntityService) {
        this.technologicalMapGroupService = technologicalMapGroupService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "return List<TechnologicalMapGroupDto>",
            response = TechnologicalMapGroupDto.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка TechnologicalMapGroup"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<TechnologicalMapGroupDto>> getAll() {
        return ResponseEntity.ok(technologicalMapGroupService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "geById",
            notes = "return TechnologicalMapGroup",
            response = TechnologicalMapGroupDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TechnologicalMapGroup"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TechnologicalMapGroupDto> getById(
            @ApiParam(name = "id", value = "id для получения TechnologicalMapGroup", required = true)
            @PathVariable("id") Long id) {
//        TODO: Need to implement
//        checkEntityService.checkExistTechnologicalMapGroupById(id);
        return ResponseEntity.ok(technologicalMapGroupService.getById(id));
    }

    @PostMapping
    @ApiOperation(
            value = "create",
            notes = "Create new TechnologicalMapGroup")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TechnologicalMapGroup"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
            @ApiParam(name = "TechnologicalMapGroupDto", value = "TechnologicalMapGroupDto for create TechnologicalMapGroup", required = true)
            @RequestBody TechnologicalMapGroupDto technologicalMapGroupDto) {
        technologicalMapGroupService.create(technologicalMapGroupDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(
            value = "update",
            notes = "Update TechnologicalMapGroup")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление TechnologicalMapGroup"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
            @ApiParam(name = "TechnologicalMapGroupDto", value = "TechnologicalMapGroupDto for update TechnologicalMapGroup", required = true)
            @RequestBody TechnologicalMapGroupDto technologicalMapGroupDto) {
//        TODO: Need to implement
//        checkEntityService.checkExistTechnologicalMapGroupById(technologicalMapGroupDto.getId());
        technologicalMapGroupService.update(technologicalMapGroupDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Deleting a TechnologicalMapGroup by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TechnologicalMapGroup"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "id удаляемого TechnologicalMapGroup", required = true)
            @PathVariable("id") Long id) {
//        TODO: Need to implement
//        checkEntityService.checkExistTechnologicalMapGroupById(id);
        technologicalMapGroupService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
