package com.warehouse_accounting.controllers.rest;


import com.warehouse_accounting.models.dto.CurrencyDto;
import com.warehouse_accounting.services.interfaces.CurrencyService;
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
@Tag(name = "CurrencyDto Rest Controller",
        description = "CRUD операции с объектами CurrencyDto")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }



    @GetMapping()
    @Tag(name = "CurrencyDto Rest Controller")
    @ApiOperation(value = "Возвращает список объектов CurrencyDto", notes = "Возвращает List CurrencyDto", response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> getAll() {
        List<CurrencyDto> all = currencyService.getAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping(value = "/{id}")
    @Tag(name = "CurrencyDto Rest Controller")
    @ApiOperation(value = "Возвращает объект CurrencyDto", notes = "Возвращает объект CurrencyDto по его ID", response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") long id) {
        CurrencyDto currencyDto = currencyService.getById(id);
        return ResponseEntity.ok(currencyDto);
    }


    @PostMapping()
    @Tag(name = "CurrencyDto Rest Controller")
    @ApiOperation(value = "Создает объект CurrencyDto", notes = "Создает объект CurrencyDto в программе", response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "CurrencyDto", value = "Объект CurrencyDto который нужно сохранить в программе")
            @RequestBody CurrencyDto currencyDto) {
        currencyService.create(currencyDto);
        return ResponseEntity.status(200).body(currencyDto);
    }


    @PutMapping()
    @Tag(name = "CurrencyDto Rest Controller")
    @ApiOperation(value = "Обновляет объект CurrencyDto", notes = "Обновляем объект CurrencyDto в программе", response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "CurrencyDto", value = "Объект CurrencyDto который нужно обновить в программе")
            @RequestBody CurrencyDto currencyDto) {
        currencyService.update(currencyDto);
        return ResponseEntity.ok(currencyDto);
    }


    @DeleteMapping(value = "/{id}")
    @Tag(name = "CurrencyDto Rest Controller")
    @ApiOperation(value = "Удаляет объект CurrencyDto", notes = "Удаляет объект CurrencyDto по его ID", response = CurrencyDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> delete(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        currencyService.deleteById(id);
        return ResponseEntity.status(200).body("User deleted successfully");
    }
}
