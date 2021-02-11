package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TypeOfPriceDto;
import com.warehouse_accounting.services.interfaces.TypeOfPriceService;
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
@RequestMapping("/api/types_of_price")
@Tag(name = "TypeOfPrice Rest Controller", description = "CRUD операции с объектами TypeOfPrice")
public class TypeOfPriceController {

    private final TypeOfPriceService service;

    public TypeOfPriceController(TypeOfPriceService service) {
        this.service = service;
    }

    @GetMapping
    @Tag(name = "TypeOfPrice Rest Controller")
    @ApiOperation(value = "getAll", notes = "Получение списка всех TypeOfPrice")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка TypeOfPrice"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public List<TypeOfPriceDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Tag(name = "TypeOfPrice Rest Controller")
    @ApiOperation(value = "getById", notes = "Получение TypeOfPrice")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TypeOfPrice"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public TypeOfPriceDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Tag(name = "TypeOfPrice Rest Controller")
    @ApiOperation(value = "create", notes = "Создание TypeOfPrice")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TypeOfPrice"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void create(TypeOfPriceDto typeOfPriceDto) {
        service.create(typeOfPriceDto);
    }

    @PutMapping
    @Tag(name = "TypeOfPrice Rest Controller")
    @ApiOperation(value = "update", notes = "Изменение TypeOfPrice")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное изменение TypeOfPrice"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void update(TypeOfPriceDto typeOfPriceDto) {
        service.update(typeOfPriceDto);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "TypeOfPrice Rest Controller")
    @ApiOperation(value = "deleteById", notes = "Удаление TypeOfPrice")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TypeOfPrice"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void deleteById(@PathVariable Long id) { service.deleteById(id); }

}
