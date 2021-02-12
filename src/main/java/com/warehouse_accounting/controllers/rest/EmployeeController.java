package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.services.interfaces.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api/employees")
@Api(value = "Employee Rest Controlle")
@Tag(name = "Employee Rest Controller", description = "CRUD операции с Employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ApiOperation(value = "getAll", notes = "Получение списка всех Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Employee"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Employee по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Employee"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public EmployeeDto getById(@ApiParam(name = "id", value = "id для получения Employee", required = true) @PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Employee"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public EmployeeDto create(@ApiParam(name = "EmployeeDto", value = "EmployeeDto для создания Employee", required = true) @RequestBody EmployeeDto employeeDto) {
        employeeService.create(employeeDto);
        return employeeService.getById(employeeDto.getId());
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление Employee")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление Employee"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public EmployeeDto update(@ApiParam(name = "EmployeeDto", value = "EmployeeDto для обновления Employee", required = true) @RequestBody EmployeeDto employeeDto) {
        employeeService.update(employeeDto);
        return employeeService.getById(employeeDto.getId());
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Employee по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Employee"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public void deleteById(@ApiParam(name = "id", value = "id удаляемого Employee", required = true) @PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }
}
