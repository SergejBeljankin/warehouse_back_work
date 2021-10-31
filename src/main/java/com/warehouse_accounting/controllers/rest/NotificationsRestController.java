package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.NotificationsDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.NotificationsService;
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
@RequestMapping("/api/notifications")
@Api(tags = "Notifications Rest Controller")
@Tag(name = "Notifications Rest Controller", description = "API для работы с настройками уведомлений")
public class NotificationsRestController {
    private final NotificationsService notificationsService;
    private final CheckEntityService checkEntityService;

    public NotificationsRestController(
            NotificationsService notificationsService, CheckEntityService checkEntityService) {
        this.notificationsService = notificationsService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список настроек уведомлений", notes = "Возвращает список NotificationsDto",
            response = NotificationsDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек уведомлений"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<NotificationsDto>> getAll() {
        return ResponseEntity.ok(notificationsService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает настройки уведомлений по id пользователя", notes = "Возвращает NotificationsDto",
            response =  NotificationsDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек уведомлений"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<NotificationsDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistNotificationsById(id);
        return ResponseEntity.ok(notificationsService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает настройки уведомлений")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание настроек уведомлений"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "NotificationsDto", value = "Объект  NotificationsDto который нужно сохранить в программе")
            @RequestBody NotificationsDto notificationsDto) {
        notificationsService.create(notificationsDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет настройки уведомлений")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение настройки уведомлений"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "NotificationsDto", value = "Объект NotificationsDto который нужно изменить в программе")
            @RequestBody NotificationsDto notificationsDto) {
        checkEntityService.checkExistNotificationsById(notificationsDto.getId());
        notificationsService.update(notificationsDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет настройки уведомлений по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление настроек уведомлений"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistNotificationsById(id);
        notificationsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
