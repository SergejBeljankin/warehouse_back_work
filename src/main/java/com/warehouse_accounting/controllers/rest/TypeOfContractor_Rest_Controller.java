package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.services.interfaces.TypeOfContractorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RequestMapping("/api/type_of_contractor")
public class TypeOfContractor_Rest_Controller {

    private final TypeOfContractorService typeOfContractorService;


    public TypeOfContractor_Rest_Controller(TypeOfContractorService typeOfContractorService) {
        this.typeOfContractorService = typeOfContractorService;
    }

    //GET ALL CONTRACTORS
    @GetMapping(value = "/tocs")
    @ApiOperation(value = "Все типы контрагентов", notes = "return List<TypeOfContractorDTO>", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа типов контрагентов", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> getAll() {
        List<TypeOfContractorDto> all_TOC = typeOfContractorService.getAll();
        return ResponseEntity.ok(all_TOC);
    }

    //DELETE
    @DeleteMapping(value = "/tocs/delete{id}")
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
        return ResponseEntity.ok().body("Котрагент ликвидрован");

    }

    //GET BY ID
    @GetMapping(value = "/tocs/{id}")
    @ApiOperation(value = "получить тип контрагента по ID", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента найден", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> getById(
            @ApiParam(name = "id", required = true)
            @PathVariable("id") long id) {
        TypeOfContractorDto typeOfContractorDto = typeOfContractorService.getById(id);
        return ResponseEntity.ok(typeOfContractorDto);
    }

    //UPDATE
    @PutMapping(value = "/tocs/update")
    @ApiOperation(value = "Редактировать данные типа контрагента", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента найден", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
            @ApiParam(name = "update typeofContractor")
            @RequestBody TypeOfContractorDto typeOfContractorDto) {
        typeOfContractorService.update(typeOfContractorDto);
        return ResponseEntity.ok().body("Данные типа котрагента обновлены");
    }

    //CREATE
    @PutMapping(value = "/tocs/add")
    @ApiOperation(value = "Создать  тип контрагента", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента создан", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
            @ApiParam(name = "create type of Contractor")
            @RequestBody TypeOfContractorDto typeOfContractorDto) {
        typeOfContractorService.create(typeOfContractorDto);
        return ResponseEntity.ok().body(" новый тип контрактора создан");
    }
}
