package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapProductService;
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
 * This class implements API for working with {@link com.warehouse_accounting.models.TechnologicalMapProduct}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 30.03.2021
 */
@RestController
@RequestMapping("/api/technological_map_product")
@Api(tags = "TechnologicalMapProduct Rest Controller")
@Tag(name = "TechnologicalMapProduct Rest Controller", description = "API for doing some CRUD with TechnologicalMapProduct")
public class TechnologicalMapProductRestController {
    private final TechnologicalMapProductService technologicalMapProductService;
    private final CheckEntityService checkEntityService;

    public TechnologicalMapProductRestController(TechnologicalMapProductService technologicalMapProductService,
                                                 CheckEntityService checkEntityService) {
        this.technologicalMapProductService = technologicalMapProductService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "return List<TechnologicalMapProductDto>",
            response = TechnologicalMapProductDto.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка TechnologicalMapProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<TechnologicalMapProductDto>> getAll() {
        return ResponseEntity.ok(technologicalMapProductService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "geById",
            notes = "return TechnologicalMapProductDto",
            response = TechnologicalMapProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TechnologicalMapProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TechnologicalMapProductDto> getById(
            @ApiParam(name = "id", value = "id для получения TechnologicalMapProductDto", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTechnologicalMapProductById(id);
        return ResponseEntity.ok(technologicalMapProductService.getById(id));
    }

    @PostMapping
    @ApiOperation(
            value = "create",
            notes = "Create TechnologicalMapProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TechnologicalMapProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
            @ApiParam(name = "TechnologicalMapProductDto", value = "TechnologicalMapProductDto for create TechnologicalMapProduct", required = true)
            @RequestBody TechnologicalMapProductDto technologicalMapProductDto) {
        technologicalMapProductService.create(technologicalMapProductDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(
            value = "update",
            notes = "Update TechnologicalMapProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление TechnologicalMapProductDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
            @ApiParam(name = "TechnologicalMapProductDto", value = "TechnologicalMapProductDto for update TechnologicalMapProduct", required = true)
            @RequestBody TechnologicalMapProductDto technologicalMapProductDto) {
        checkEntityService.checkExistTechnologicalMapProductById(technologicalMapProductDto.getId());
        technologicalMapProductService.update(technologicalMapProductDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "deleteById",
            notes = "Deleting a TechnologicalMapProduct by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TechnologicalMapProduct"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> delById(
            @ApiParam(name = "id", value = "id удаляемого TechnologicalMapProduct", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTechnologicalMapProductById(id);
        technologicalMapProductService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
