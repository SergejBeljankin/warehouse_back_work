package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.BonusTransactionDto;
import com.warehouse_accounting.services.impl.BonusTransactionServiceImpl;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/api/bonus_transactions")
public class BonusTransactionRestController {

    private final CheckEntityService checkEntityService;
    private final BonusTransactionServiceImpl bonusTransactionService;

    public BonusTransactionRestController(CheckEntityService checkEntityService,
                                          BonusTransactionServiceImpl bonusTransactionService) {
        this.checkEntityService = checkEntityService;
        this.bonusTransactionService = bonusTransactionService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список объектов", notes = "Возвращает список BonusTransactionDTO",
            response = BonusTransactionDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<List<BonusTransactionDto>> getAll() {
        return ResponseEntity.ok(bonusTransactionService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает объект BonusTransactionDto",
            notes = "Возвращает объект BonusTransactionDto по его ID", response = BonusTransactionDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<BonusTransactionDto> getById(@ApiParam(name =
            "id", value = "Id нужного BonusTransactionDto", required = true)
                                           @PathVariable("id") Long id) {
        checkEntityService.checkExistBonusTransactionById(id);
        return ResponseEntity.ok(bonusTransactionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает объект BonusTransactionDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "BonusTransactionDto", value = "Объект BonusTransactionDto для создания",
            required = true) @RequestBody BonusTransactionDto bonusTransactionDto) {
        bonusTransactionService.create(bonusTransactionDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет объект BonusTransactionDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "BonusTransactionDto", value = "Объект BonusTransactionDto для обновления",
            required = true) @RequestBody BonusTransactionDto bonusTransactionDto) {
        checkEntityService.checkExistBonusTransactionById(bonusTransactionDto.getId());
        bonusTransactionService.update(bonusTransactionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет объект BonusTransactionDto с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name =
            "id", value = "Id BonusTransactionDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistBonusTransactionById(id);
        bonusTransactionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
