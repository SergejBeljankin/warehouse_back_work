package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.SettingsDto;
import com.warehouse_accounting.services.impl.SettingServiceImpl;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
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
@RequestMapping("/api/settings")
@Api(tags = "Setting Rest Controller")
@Tag(name = "Setting Rest Controller", description = "API для работы с настройками")
public class SettingsRestController {
    private final SettingServiceImpl settingService;
    private final CheckEntityService checkEntityService;

    public SettingsRestController(SettingServiceImpl settingService, CheckEntityService checkEntityService) {
        this.settingService = settingService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список настроек", notes = "Возвращает список SettingsDto", response = SettingsDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение списка настроек"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<SettingsDto>> getAll() {
        return ResponseEntity.ok(settingService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает настройки по id пользователя", notes = "Возвращает SettingsDto", response = SettingsDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<SettingsDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistSettingsById(id);
        return ResponseEntity.ok(settingService.getByIdEmployee(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает настройки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание настроек"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "SettingsDto", value = "Объект SettingsDto который нужно сохранить в программе")
            @RequestBody SettingsDto settingsDto) {
        settingService.create(settingsDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет настройки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение настроек"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "SettingsDto", value = "Объект SettingsDto который нужно изменить в программе")
            @RequestBody SettingsDto settingsDto) {
        checkEntityService.checkExistSettingsById(settingsDto.getId());
        settingService.update(settingsDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет настройки по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление настроек"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistSettingsById(id);
        settingService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
