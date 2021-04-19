package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TaskDto;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TaskService;
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

/**
 * This class implements API for working with {@link com.warehouse_accounting.models.Task}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 30.03.2021
 */
@RestController
@RequestMapping("/api/tasks")
@Api(tags = "Task Rest Controller")
@Tag(name = "Task Rest Controller", description = "API for doing some CRUD with Task")
public class TaskRestController {
    private final TaskService taskService;
    private final CheckEntityService checkEntityService;

    public TaskRestController(TaskService taskService, CheckEntityService checkEntityService) {
        this.taskService = taskService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "return List<TaskDto>",
            response = TaskDto.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Task"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<TaskDto>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "getById",
            notes = "return Task",
            response = TaskDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Task"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<TaskDto> getById(
            @ApiParam(name = "id", value = "id для получения Task", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTaskById(id);
        return ResponseEntity.ok(taskService.getById(id));
    }

    @PostMapping
    @ApiOperation(
            value = "create",
            notes = "Create Task")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Task"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
            @ApiParam(name = "TaskDto", value = "TaskDto for create Task", required = true)
            @RequestBody TaskDto taskDto) {
        taskService.create(taskDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(
            value = "update",
            notes = "Update Task")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное изменение Task"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
            @ApiParam(name = "TaskDto", value = "TaskDto for update Task", required = true)
            @RequestBody TaskDto taskDto) {
        checkEntityService.checkExistTaskById(taskDto.getId());
        taskService.update(taskDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "deleteById",
            notes = "Deleting a Task by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Task"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "id удаляемого Task", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistTaskById(id);
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
