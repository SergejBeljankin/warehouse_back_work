package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.BankAccountDto;
import com.warehouse_accounting.repositories.BankAccountRepository;
import com.warehouse_accounting.services.interfaces.BankAccountService;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
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
@RequestMapping("/api/bank_accounts")
@Api(tags = "BankAccount Rest Controller")
@Tag(name = "BankAccount Rest Controller", description = "CRUD операции с объектами")
public class BankAccountRestController {

    private final BankAccountService bankAccountService;

    private final CheckEntityService checkEntityService;
    private final BankAccountRepository repository;

    public BankAccountRestController(BankAccountService bankAccountService, CheckEntityService checkEntityService, BankAccountRepository repository) {
        this.bankAccountService = bankAccountService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping()
    @ApiOperation(value = "Возвращает список объектов BankAccountDto", notes = "Возвращает List BankAccountDto", response = BankAccountDto.class)
    @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
           @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
           @ApiResponse(responseCode = "403", description = "Операция запрещена"),
           @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<BankAccountDto>> getAll() {
        return ResponseEntity.ok(bankAccountService.getAll());
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Возвращает объект BankAccountDto", notes = "Возвращает объект BankAccountDto по его ID", response = BankAccountDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<BankAccountDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExist(id, repository, "BankAccount");
        return ResponseEntity.ok(bankAccountService.getById(id));

    }


    @PostMapping()
    @ApiOperation(value = "Создает объект BankAccountDto", notes = "Создает объект BankAccountDto в программе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "BankAccountDto", value = "Объект BankAccountDto который нужно сохранить в программе")
            @RequestBody BankAccountDto bankAccountDto) {
        bankAccountService.create(bankAccountDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping()
    @ApiOperation(value = "Обновляет объект BankAccountDto", notes = "Обновляет объект BankAccountDto в программе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "BankAccountDto", value = "Объект BankAccountDto который нужно обновить в программе")
            @RequestBody BankAccountDto bankAccountDto) {
        checkEntityService.checkExist(bankAccountDto.getId(), repository, "BankAccount");
        bankAccountService.update(bankAccountDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Удаляет объект BankAccountDto", notes = "Удаляет объект BankAccountDto по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> delete(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExist(id, repository, "BankAccount");
        bankAccountService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}



