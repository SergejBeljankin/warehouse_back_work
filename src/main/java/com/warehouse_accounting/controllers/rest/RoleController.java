package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.services.interfaces.RoleService;
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
@RequestMapping("/api/role")
@Tag(name = "RoleDto Rest Controller",
        description = "CRUD операции с объектами RoleDto")
public class RoleController {

        private final RoleService roleService;

        public RoleController(RoleService roleService) {
            this.roleService = roleService;
        }



    @GetMapping()
    @Tag(name = "RoleDto Rest Controller")
    @ApiOperation(value = "Возвращает список объектов RoleDto", notes = "Возвращает List RoleDto", response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> getAll() {
        List<RoleDto> all = roleService.getAll();
        return ResponseEntity.ok(all);
    }


    @GetMapping(value = "/{id}")
    @Tag(name = "RoleDto Rest Controller")
    @ApiOperation(value = "Возвращает объект RoleDto", notes = "Возвращает объект RoleDto по его ID", response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") long id) {
        RoleDto roleDto = roleService.getById(id);
        return ResponseEntity.ok(roleDto);
    }


    @PostMapping()
    @Tag(name = "RoleDto Rest Controller")
    @ApiOperation(value = "Создает объект RoleDto", notes = "Создает объект RoleDto в программе", response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "RoleDto", value = "Объект RoleDto который нужно сохранить в программе")
            @RequestBody RoleDto roleDto) {
        roleService.create(roleDto);
        return ResponseEntity.status(200).body(roleDto);
    }


    @PutMapping()
    @Tag(name = "RoleDto Rest Controller")
    @ApiOperation(value = "Обновляет объект RoleDto", notes = "Обновляем объект RoleDto в программе", response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "RoleDto", value = "Объект RoleDto который нужно обновить в программе")
            @RequestBody RoleDto roleDto) {
        roleService.update(roleDto);
        return ResponseEntity.ok(roleDto);
    }


    @DeleteMapping(value = "/{id}")
    @Tag(name = "RoleDto Rest Controller")
    @ApiOperation(value = "Удаляет объект RoleDto", notes = "Удаляет объект RoleDto по его ID", response = RoleDto.class)
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
        roleService.deleteById(id);
        return ResponseEntity.status(200).body("User deleted successfully");
    }
}