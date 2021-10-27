package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ContractorGetALLDto;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ContractorService;
import com.warehouse_accounting.models.dto.ContractorDto;
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
@RequestMapping("/api/contractors")
@Api(tags = "Contractor Rest Controller")
@Tag(name = "Contractor Rest Controller", description = "CRUD операции с объектами")
public class ContractorRestController {
    private final ContractorService contractorService;
    private final CheckEntityService checkEntityService;
    private final ContractorRepository repository;

    public ContractorRestController(ContractorService contractorService, CheckEntityService checkEntityService, ContractorRepository repository) {
        this.contractorService = contractorService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все параметры рассчитываемого объекта", notes = "Возвращает список ContractorGetALLDto",
            response = ContractorGetALLDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа ContractorGetALLDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<ContractorGetALLDto>> getAll() {
        return ResponseEntity.ok(contractorService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id", notes = "Возвращает ContractorDto",
            response = ContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение ContractorDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<ContractorDto> getById(@ApiParam(name = "id", value = "Id нужного ContractorDto", required = true)
                                                                   @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Contractor");
        return ResponseEntity.ok(contractorService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание ContractorDto",
                    response = ContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "ContractorDto", value = "Объект ContractorDto для создания",
            required = true) @RequestBody ContractorDto contractorDto) {
        contractorService.create(contractorDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление ContractorDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "ContractorDto", value = "Объект ContractorDto для обновления",
            required = true) @RequestBody ContractorDto contractorDto) {
        checkEntityService.checkExist(contractorDto.getId(), repository, "Contractor");
        contractorService.update(contractorDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет параметр рассчитываемого объекта с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление ContractorDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id ContractorDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Contractor");
        contractorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
