package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.services.interfaces.TypeOfContractorService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/type_of_contractors")
@Api(value = "TypeOfContractor Rest")
@Tag(name = "TypeOfContractor Rest", description = "controller for doing some CRUD with Type Of Contractor")
public class TypeOfContractorRestController {

    private final TypeOfContractorService typeOfContractorService;


    public TypeOfContractorRestController(TypeOfContractorService typeOfContractorService) {
        this.typeOfContractorService = typeOfContractorService;
    }


    @GetMapping
    @ApiOperation(value = "Все типы контрагентов", notes = "return List<TypeOfContractorDTO>", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа типов контрагентов", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<TypeOfContractorDto>> getAll() {
        List<TypeOfContractorDto> typeOfContractorDtos = typeOfContractorService.getAll();
        return ResponseEntity.ok(typeOfContractorDtos);
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "удалить тип контрагента по ID", notes = "return List<TypeOfContractorDTO>", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контрагента удален", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> delete(
            @ApiParam(name = "id", required = true)
            @PathVariable("id") long id
    ) {
        typeOfContractorService.deleteById(id);
        return ResponseEntity.ok().build();

    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "получить тип контрагента по ID", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента найден", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TypeOfContractorDto> getById(
            @ApiParam(name = "id", required = true)
            @PathVariable("id") long id) {
        TypeOfContractorDto typeOfContractorDto = typeOfContractorService.getById(id);
        return ResponseEntity.ok(typeOfContractorDto);
    }


    @PostMapping
    @ApiOperation(value = "Редактировать данные типа контрагента", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента найден", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TypeOfContractorDto> update(
            @ApiParam(name = "update typeofContractor")
            @RequestBody TypeOfContractorDto typeOfContractorDto) {
        typeOfContractorService.update(typeOfContractorDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    @ApiOperation(value = "Создать  тип контрагента", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента создан", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TypeOfContractorDto> create(
            @ApiParam(name = "create type of Contractor")
            @RequestBody TypeOfContractorDto typeOfContractorDto) {
        typeOfContractorService.create(typeOfContractorDto);
        return ResponseEntity.ok().build();
    }
}
