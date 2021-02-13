package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ContractDto;
import com.warehouse_accounting.services.interfaces.ContractService;
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
@RequestMapping("/api/contract")
@Api(tags = "Contract Rest Controller")
@Tag(name = "Contract Rest Controller", description = "API для работы с договорами")
public class ContractRestController {
    private final ContractService contractService;

    public ContractRestController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список договоров", notes = "Возвращает список ContractDto", response = ContractDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка договоров"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ContractDto>> getAll() {
        return ResponseEntity.ok(contractService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает договор по id", notes = "Возвращает ContractDto", response = ContractDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение договора"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ContractDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(contractService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает договор")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание договора"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
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
            @ApiResponse(code = 200, message = "Успешное изменение договора"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "ContractDto", value = "Объект ContractDto который нужно изменить в программе")
            @RequestBody ContractDto contractDto) {
        contractService.update(contractDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет договор по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление договора"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        contractService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
