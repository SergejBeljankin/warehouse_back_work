package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.SelectorDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.SelectorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/selector")
@Api(tags = "Selector Rest Controller")
@Tag(name = "Selector Rest Controller", description = "API для работы с селектором")
public class SelectorRestController {
    private final SelectorService selectorService;
    private final CheckEntityService checkEntityService;

    public SelectorRestController(
           SelectorService selectorService, CheckEntityService checkEntityService) {
        this.selectorService = selectorService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список селекторов", notes = "Возвращает список SelectorDto",
            response = SelectorDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение селекторов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<SelectorDto>> getAll() {
        return ResponseEntity.ok(selectorService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает селекторы по id пользователя", notes = "Возвращает SelectorDto",
            response = SelectorDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение селекторов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<SelectorDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(selectorService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает селектор")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание селектора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "SelectorDto", value = "Объект  SelectorDto который нужно сохранить в программе")
            @RequestBody SelectorDto selectorDto) {
        selectorService.create(selectorDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет селектор")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение селектора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "SelectorDto", value = "Объект SelectorDto который нужно изменить в программе")
            @RequestBody SelectorDto selectorDto) {

        selectorService.update(selectorDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет селектор по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление селектора"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {

        selectorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
