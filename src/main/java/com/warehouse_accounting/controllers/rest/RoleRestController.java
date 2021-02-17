package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.RoleService;
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
@RequestMapping("/api/role")
@Api(tags = "Role Rest Controller")
@Tag(name = "Role Rest Controller",
        description = "CRUD операции с объектами")
public class RoleRestController {

    private final RoleService roleService;

    private final CheckEntityService checkEntityService;

    public RoleRestController(RoleService roleService, CheckEntityService checkEntityService) {
        this.roleService = roleService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список объектов", notes = "Возвращает список RoleDto",
            response = RoleDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает объект RoleDto",
            notes = "Возвращает объект RoleDto по его ID", response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<RoleDto> getById(@ApiParam(name =
            "id", value = "Id нужного RoleDto", required = true)
    @PathVariable("id") Long id) {
        checkEntityService.checkExistRoleById(id);
        return ResponseEntity.ok(roleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает объект Role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "RoleDto", value = "Объект RoleDto для создания",
            required = true) @RequestBody RoleDto roleDto) {
        roleService.create(roleDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет объект RoleDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "RoleDto", value = "Объект RoleDto для обновления",
            required = true) @RequestBody RoleDto roleDto) {
        checkEntityService.checkExistRoleById(roleDto.getId());
        roleService.update(roleDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет объект RoleDto с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name =
            "id", value = "Id RoleDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistRoleById(id);
        roleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}