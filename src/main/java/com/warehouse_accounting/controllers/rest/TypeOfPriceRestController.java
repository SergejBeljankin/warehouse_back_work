package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TypeOfPriceDto;
import com.warehouse_accounting.services.interfaces.TypeOfPriceService;
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
@RequestMapping("/api/types_of_price")
@Api(tags = "TypeOfPrice Rest Controller")
@Tag(name = "TypeOfPrice Rest Controller", description = "CRUD операции с объектами")
public class TypeOfPriceRestController {

    private final TypeOfPriceService typeOfPriceService;

    public TypeOfPriceRestController(TypeOfPriceService service) {
        this.typeOfPriceService = service;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список TypeOfPriceDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка TypeOfPriceDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<TypeOfPriceDto>> getAll() {
        return ResponseEntity.ok(typeOfPriceService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает TypeOfPriceDto по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TypeOfPriceDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<TypeOfPriceDto> getById(@ApiParam(name = "id", value = "id для получения TypeOfPriceDto", required = true)
                                                  @PathVariable("id") Long id) {
        return ResponseEntity.ok(typeOfPriceService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает TypeOfPriceDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TypeOfPriceDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "TypeOfPriceDto", value = "объект TypeOfPriceDto для создания",
            required = true) @RequestBody TypeOfPriceDto typeOfPriceDto) {
        typeOfPriceService.create(typeOfPriceDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет TypeOfPriceDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление TypeOfPriceDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "TypeOfPriceDto", value = "объект TypeOfPriceDto для обновления",
            required = true) @RequestBody TypeOfPriceDto typeOfPriceDto) {
        typeOfPriceService.update(typeOfPriceDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет TypeOfPriceDto по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TypeOfPriceDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id для удаления TypeOfPriceDto",
            required = true) @PathVariable("id") Long id) {
        typeOfPriceService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}