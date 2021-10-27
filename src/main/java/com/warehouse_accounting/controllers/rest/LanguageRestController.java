package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.LanguageDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.LanguageService;
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
@RequestMapping("/api/language")
@Api(tags = "Language Rest Controller")
@Tag(name = "Language Rest Controller", description = "API для работы с настройками языка")
public class LanguageRestController {
    private final LanguageService languageService;
    private final CheckEntityService checkEntityService;

    public LanguageRestController(LanguageService languageService,
                                  CheckEntityService checkEntityService) {
        this.languageService = languageService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список языков", notes = "Возвращает список LanguageDto", response = LanguageDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка языков"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<LanguageDto>> getAll() {
        return ResponseEntity.ok(languageService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает языки по id пользователя", notes = "Возвращает LanguageDto", response = LanguageDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение языков"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<LanguageDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistLanguageById(id);
        return ResponseEntity.ok(languageService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает языки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание настроек языка"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "LanguageDto", value = "Объект LanguageDto который нужно сохранить в программе")
            @RequestBody LanguageDto languageDto) {
        languageService.create(languageDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет настройки языка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение настроек языка"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "LanguageDto", value = "Объект LanguageDto который нужно изменить в программе")
            @RequestBody LanguageDto languageDto) {
        checkEntityService.checkExistLanguageById(languageDto.getId());
        languageService.update(languageDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет настройки языка по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление языка настроек"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistLanguageById(id);
        languageService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
