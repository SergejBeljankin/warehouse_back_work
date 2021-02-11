package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.services.CheckEntityService;
import com.warehouse_accounting.services.impl.CompanyServiceImpl;
import com.warehouse_accounting.util.ConverterDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/companies")
@Tag(name = "Company RESTController", description = "controller for doing some CRUD-magic with companies")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @ApiOperation(value = "getAll", notes = "Получение списка всех Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public List<CompanyDto> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Company по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public CompanyDto getById(@PathVariable("id") long id) {
        return companyService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Сохранение Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное сохранение Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public void create(@RequestBody CompanyDto companyDto) {
        companyService.create(companyDto);
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Изменение Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public void update(@RequestBody CompanyDto companyDto) {
        companyService.update(companyDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public void deleteById(@PathVariable("id") Long id) {
        companyService.deleteById(id);
    }

}
