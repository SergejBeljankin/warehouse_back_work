package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.repositories.TaxSystemRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TaxSystemService;
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
@RequestMapping("/api/tax_systems")
@Api(tags = "TaxSystem Rest Controller")
@Tag(name = "TaxSystem Rest Controller", description = "CRUD операции с объектами")
public class TaxSystemRestController {
    private final TaxSystemService taxSystemService;
    private final CheckEntityService checkEntityService;
    private final TaxSystemRepository repository;

    public TaxSystemRestController(TaxSystemService taxSystemService, CheckEntityService checkEntityService, TaxSystemRepository repository) {
        this.taxSystemService = taxSystemService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все системы налогообложения", notes = "Возвращает список TaxSystemDto",
            response = TaxSystemDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа систем налогообложения",
                    response = TaxSystemDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<TaxSystemDto>> getAll() {
        return ResponseEntity.ok(taxSystemService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает систему налогообложения с выбранным id", notes = "Возвращает TaxSystemDto",
            response = TaxSystemDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение системы налогообложения",
                    response = TaxSystemDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<TaxSystemDto> getById(@ApiParam(name = "id", value = "Id нужного TaxSystemDto",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "TaxSystem");
        return ResponseEntity.ok(taxSystemService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданную систему налогообложения")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление системы налогообложения",
                    response = TaxSystemDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "TaxSystemDto", value = "объект TaxSystemDto для обновления",
            required = true) @RequestBody TaxSystemDto taxSystemDto) {
        checkEntityService.checkExist(taxSystemDto.getId(), repository, "TaxSystem");
        taxSystemService.update(taxSystemDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Создает переданную систему налогообложения")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание системы налогообложения",
                    response = TaxSystemDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "TaxSystemDto", value = "объект TaxSystemDto для создания",
            required = true) @RequestBody TaxSystemDto taxSystemDto) {
        taxSystemService.create(taxSystemDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет систему налогообложения с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление системы налогообложения",
                    response = TaxSystemDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id TaxSystemDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "TaxSystem");
        taxSystemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
