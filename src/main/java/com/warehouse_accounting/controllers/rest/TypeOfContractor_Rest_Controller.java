package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.services.interfaces.TypeOfContractorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tocs")
@Api(value = "TypeOfContractor Rest")
@Tag(name = "TypeOfContractor Rest", description = "controller for doing some CRUD with Type Of Contractor")
public class TypeOfContractor_Rest_Controller {

    private final TypeOfContractorService typeOfContractorService;


    public TypeOfContractor_Rest_Controller(TypeOfContractorService typeOfContractorService) {
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
        List<TypeOfContractorDto> all_TOC = typeOfContractorService.getAll();
        return ResponseEntity.ok(all_TOC);
    }


    @DeleteMapping(value = "/{id}")
    @Tag(name = "TypeOfContractor Rest")
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
        typeOfContractorService.deleteByID(id);
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


    @PutMapping
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
    @Tag(name = "TypeOfContractor Rest")
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
