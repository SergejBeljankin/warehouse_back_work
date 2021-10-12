package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ApplicationDto;
import com.warehouse_accounting.services.impl.ApplicationServiceImpl;
import com.warehouse_accounting.services.interfaces.ApplicationService;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpEntity;
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
@RequestMapping("/api/applications")
@Api(tags = "Application REST Controller")
@Tag(name = "Application REST Controller", description = "CRUD for applications")
public class ApplicationRestController {
    private final CheckEntityService checkEntityService;
    private final ApplicationService applicationService;

    public ApplicationRestController(CheckEntityService checkEntityService, ApplicationService applicationService) {
        this.checkEntityService = checkEntityService;
        this.applicationService = applicationService;
    }

    @GetMapping
    @ApiOperation(value = "getAll", notes = "Получение списка всех ApplicationDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка ApplicationDto"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ApplicationDto>> getAll() {
        System.out.println(applicationService.getAll());
        return ResponseEntity.ok(applicationService.getAll()); }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Application по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение Application"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ApplicationDto> getById(@PathVariable("id") Long id) {
        checkEntityService.checkExistApplicationById(id);
        return ResponseEntity.ok(applicationService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание Application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное сохранение Application"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@RequestBody ApplicationDto applicationDto) {
        applicationService.create(applicationDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Изменение Application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение Application"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@RequestBody ApplicationDto applicationDto) {
        checkEntityService.checkExistApplicationById(applicationDto.getId());
        applicationService.update(applicationDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление Application"),
            @ApiResponse(responseCode = "404", description = "Данный контроллер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        checkEntityService.checkExistApplicationById(id);
        applicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
