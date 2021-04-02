package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapMaterialService;
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
 * This class implements API for working with {@link com.warehouse_accounting.models.TechnologicalMapMaterial}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 30.03.2021
 */
@RestController
@RequestMapping("/api/technological_map_material")
@Api(tags = "TechnologicalMapMaterial Rest Controller")
@Tag(name = "TechnologicalMapMaterial Rest Controller", description = "API for doing some CRUD with TechnologicalMapMaterial")
public class TechnologicalMapMaterialRestController {
    private final TechnologicalMapMaterialService technologicalMapMaterialService;
    private final CheckEntityService checkEntityService;

    public TechnologicalMapMaterialRestController(TechnologicalMapMaterialService technologicalMapMaterialService,
                                                  CheckEntityService checkEntityService) {
        this.technologicalMapMaterialService = technologicalMapMaterialService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "return List<TechnologicalMapMaterialDto>",
            response = TechnologicalMapMaterialDto.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка TechnologicalMapMaterial"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<TechnologicalMapMaterialDto>> getAll() {
        return ResponseEntity.ok(technologicalMapMaterialService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "geById",
            notes = "return TechnologicalMapMaterialDto",
            response = TechnologicalMapMaterialDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TechnologicalMapMaterial"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TechnologicalMapMaterialDto> getById(
            @ApiParam(name = "id", value = "id для получения TechnologicalMapMaterialDto", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTechnologicalMapMaterialById(id);
        return ResponseEntity.ok(technologicalMapMaterialService.getById(id));
    }

    @PostMapping
    @ApiOperation(
            value = "create",
            notes = "Create TechnologicalMapMaterial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TechnologicalMapMaterial"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
            @ApiParam(name = "TechnologicalMapMaterialDto", value = "TechnologicalMapMaterialDto for create TechnologicalMapMaterial", required = true)
            @RequestBody TechnologicalMapMaterialDto technologicalMapMaterialDto) {
        technologicalMapMaterialService.create(technologicalMapMaterialDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(
            value = "update",
            notes = "Update TechnologicalMapMaterial")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление TechnologicalMapMaterial"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
            @ApiParam(name = "TechnologicalMapMaterialDto", value = "TechnologicalMapMaterialDto for update TechnologicalMapMaterial", required = true)
            @RequestBody TechnologicalMapMaterialDto technologicalMapMaterialDto) {
        checkEntityService.checkExistTechnologicalMapMaterialById(technologicalMapMaterialDto.getId());
        technologicalMapMaterialService.update(technologicalMapMaterialDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "deleteById",
            notes = "Deleting a TechnologicalMapMaterial by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TechnologicalMapMaterial"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> delById(
            @ApiParam(name = "id", value = "id удаляемого TechnologicalMapMaterial", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTechnologicalMapMaterialById(id);
        technologicalMapMaterialService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

