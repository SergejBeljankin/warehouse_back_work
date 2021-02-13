package com.warehouse_accounting.controllers.rest;


import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.services.interfaces.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/api/currency")
@Api(tags = "Currency Rest Controller")
@Tag(name = "Currency Rest Controller",
        description = "CRUD операции с объектами")
public class CurrencyRestController {

    private final CurrencyService currencyService;

    public CurrencyRestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список объектов CurrencyDto",
            notes = "Возвращает List CurrencyDto",
            response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<List<CurrencyDto>> getAll() {
        return ResponseEntity.ok(currencyService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает объект CurrencyDto", notes = "Возвращает объект CurrencyDto по его ID", response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<CurrencyDto> getById(@ApiParam(name =
            "id", value = "Id нужного CurrencyDto", required = true)
                                           @PathVariable("id") Long id) {
        return ResponseEntity.ok(currencyService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает объект CurrencyDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "CurrencyDto",
            value = "Объект CurrencyDto для создания",
            required = true) @RequestBody CurrencyDto currencyDto) {
        currencyService.create(currencyDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    @ApiOperation(value = "Обновляет объект CurrencyDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "CurrencyDto", value = "Объект CurrencyDto для обновления",
            required = true) @RequestBody CurrencyDto currencyDto) {
        currencyService.update(currencyDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет объект CurrencyDto с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name =
            "id", value = "Id CurrencyDto для удаления", required = true)
    @PathVariable("id") Long id) {
        currencyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}