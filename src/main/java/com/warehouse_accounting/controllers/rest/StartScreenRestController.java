package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.StartScreenDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.StartScreenService;
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
@RequestMapping("/api/start_screen")
@Api(tags = "StartScreen Rest Controller")
@Tag(name = "StartScreen Rest Controller", description = "API для работы с настройками стартовой страницы")
public class StartScreenRestController {
    private final StartScreenService startScreenService;
    private final CheckEntityService checkEntityService;

    public StartScreenRestController(
           StartScreenService startScreenService, CheckEntityService checkEntityService) {
        this.startScreenService = startScreenService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список настроек стартовой страницы", notes = "Возвращает список StartScreenDto",
            response = StartScreenDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек стартовой страницы"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<StartScreenDto>> getAll() {
        return ResponseEntity.ok(startScreenService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает настройки стартовой страницы по id пользователя", notes = "Возвращает StartScreenDto",
            response =  StartScreenDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек стартовой страницы"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<StartScreenDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistStartScreenById(id);
        return ResponseEntity.ok(startScreenService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает настройки стартовой страницы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание настроек стартовой страницыв"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "StartScreenDto", value = "Объект StartScreenDto который нужно сохранить в программе")
            @RequestBody StartScreenDto startScreenDto) {
        startScreenService.create(startScreenDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет настройки стартовой страницы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение настройки стартовой страницы"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "startScreenDto", value = "Объект startScreenDto который нужно изменить в программе")
            @RequestBody StartScreenDto startScreenDto) {
        checkEntityService.checkExistSettingsById(startScreenDto.getId());
        startScreenService.update(startScreenDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет настройки стартовой страницы по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление настроек стартовой страницы"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistStartScreenById(id);
        startScreenService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
