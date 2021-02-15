package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.DepartmentDto;
import com.warehouse_accounting.services.interfaces.DepartmentService;
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



@RestController
@RequestMapping("/api/departments")
@Api(tags = "Department Rest Controller")
@Tag(name = "Department Rest Controller", description = "CRUD операции с объектами")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все департаменты", notes = "Возвращает список DepartmentDto",
            response = DepartmentDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа DepartmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<DepartmentDto>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает департамент с выбранным id", notes = "DepartmentDto",
            response = DepartmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение DepartmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<DepartmentDto> getById(@ApiParam(name = "id", value = "Id нужного DepartmentDto", required = true)
                                            @PathVariable("id") Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Обновляет выбранный департамент")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление DepartmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "DepartmentDto", value = "Объект DepartmentDto для обновления",
            required = true) @RequestBody DepartmentDto departmentDto) {
        departmentService.update(departmentDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Создает новый департамент")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание DepartmentDto",
                    response = DepartmentDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "DepartmentDto", value = "Объект DepartmentDto для создания",
            required = true) @RequestBody DepartmentDto departmentDto) {
        departmentService.create(departmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет департамент с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление DepartmentDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id DepartmentDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
