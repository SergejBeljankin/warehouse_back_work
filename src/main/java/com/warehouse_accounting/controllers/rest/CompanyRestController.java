package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.repositories.CompanyRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/companies")
@Api(tags = "Company RESTController")
@Tag(name = "Company RESTController", description = "controller for doing some CRUD-magic with companies")
public class CompanyRestController {
    private final CheckEntityService checkEntityService;
    private final CompanyService companyService;
    private final CompanyRepository repository;

    public CompanyRestController(CheckEntityService checkEntityService, CompanyService companyService, CompanyRepository repository) {
        this.checkEntityService = checkEntityService;
        this.companyService = companyService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "getAll", notes = "Получение списка всех Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<CompanyDto>> getAll() { return ResponseEntity.ok(companyService.getAll()); }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Company по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<CompanyDto> getById(@PathVariable("id") long id) {
        checkEntityService.checkExist(id, repository, "Company");
        return ResponseEntity.ok(companyService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Сохранение Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное сохранение Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@RequestBody CompanyDto companyDto) {
        companyService.create(companyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Изменение Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@RequestBody CompanyDto companyDto) {
        checkEntityService.checkExist(companyDto.getId(), repository, "Company");
        companyService.update(companyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Company")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление Company"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Company");
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
