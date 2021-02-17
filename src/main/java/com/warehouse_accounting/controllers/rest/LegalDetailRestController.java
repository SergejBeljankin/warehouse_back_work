package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.services.interfaces.LegalDetailService;
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
@RequestMapping("/api/legal_details")
@Api(tags = "LegalDetail Rest Controller")
@Tag(name = "LegalDetail Rest Controller", description = "API для работы с юрдической информацией")
public class LegalDetailRestController {
    private final LegalDetailService legalDetailService;

    public LegalDetailRestController(LegalDetailService legalDetailService) {
        this.legalDetailService = legalDetailService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список по юрдической информации", notes = "Возвращает список LegalDetailDto", response = LegalDetailDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Успешное получение листа юрдической информациии"),
            @ApiResponse(responseCode = "404", description  = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description  = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description  = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<LegalDetailDto>> getAll() {
        return ResponseEntity.ok(legalDetailService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает юрдическую информацию по id", notes = "Возвращает LegalDetailDto", response = LegalDetailDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Успешное получение юридической информации"),
            @ApiResponse(responseCode = "404", description  = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description  = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description  = "Нет доступа к данной операции")}
    )
    public ResponseEntity<LegalDetailDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(legalDetailService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает юрдическую информацию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Успешное создание юридической информации"),
            @ApiResponse(responseCode = "404", description  = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description  = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description  = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "LegalDetailDto", value = "Объект LegalDetailDto который нужно обновить в программе")
            @RequestBody LegalDetailDto legalDetailDto) {
        legalDetailDto.setTypeOfContractorDto(null);
        legalDetailService.create(legalDetailDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет юрдическую информацию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Успешное изменение юридической информации"),
            @ApiResponse(responseCode = "404", description  = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description  = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description  = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "LegalDetailDto", value = "Объект LegalDetailDto который нужно сохранить в программе")
            @RequestBody LegalDetailDto legalDetailDto) {
        legalDetailService.update(legalDetailDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет юрдическую информацию по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Успешное удаление юридической информации"),
            @ApiResponse(responseCode = "404", description  = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description  = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description  = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        legalDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
