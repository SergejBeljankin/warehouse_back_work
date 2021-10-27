package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.repositories.ContractRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ContractService;
import io.swagger.annotations.Api;
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
@RequestMapping("/api/contracts")
@Api(tags = "Contract Rest Controller")
@Tag(name = "Contract Rest Controller", description = "API для работы с договорами")
public class ContractRestController {
    private final ContractService contractService;
    private final CheckEntityService checkEntityService;
    private final ContractRepository repository;

    public ContractRestController(ContractService contractService, CheckEntityService checkEntityService, ContractRepository repository) {
        this.contractService = contractService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список договоров", notes = "Возвращает список ContractDto", response = ContractDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка договоров"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ContractDto>> getAll() {
        return ResponseEntity.ok(contractService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает договор по id", notes = "Возвращает ContractDto", response = ContractDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение договора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ContractDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Contract");
        return ResponseEntity.ok(contractService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает договор")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание договора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "ContractDto", value = "Объект ContractDto который нужно сохранить в программе")
            @RequestBody ContractDto contractDto) {
        contractService.create(contractDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет договор")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение договора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "ContractDto", value = "Объект ContractDto который нужно изменить в программе")
            @RequestBody ContractDto contractDto) {
        checkEntityService.checkExist(contractDto.getId(), repository, "Contract");
        contractService.update(contractDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет договор по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление договора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExist(id, repository, "Contract");
        contractService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
