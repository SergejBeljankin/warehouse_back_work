package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CustomerOrderDto;
import com.warehouse_accounting.repositories.CustomerOrderRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.CustomerOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/customer_orders")
@Api(tags = "CustomerOrder Rest Controller")
@Tag(name = "CustomerOrder Rest Controller", description = "CRUD операции с объектами")
public class CustomerOrderRestController {

    private final CustomerOrderService customerOrderService;
    private final CheckEntityService checkEntityService;
    private final CustomerOrderRepository repository;

    @Autowired
    public CustomerOrderRestController(CustomerOrderService customerOrderService,
                                       CheckEntityService checkEntityService,
                                       CustomerOrderRepository repository) {
        this.customerOrderService = customerOrderService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все параметры рассчитываемого объекта",
            notes = "Возвращает список CustomerOrderDto",
            response = CustomerOrderDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа CustomerOrderDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<CustomerOrderDto>> getAll() {
        return ResponseEntity.ok(customerOrderService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id",
            notes = "Возвращает CustomerOrderDto",
            response = CustomerOrderDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение CustomerOrderDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 402, message = "Нет доступа к данной операции")})
    public ResponseEntity<CustomerOrderDto> getById(@ApiParam(name = "id", value = "Id нужного CustomerOrderDto", required = true)
                                              @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "CustomerOrder");
        return ResponseEntity.ok(customerOrderService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание CustomerOrderDto",
                    response = CustomerOrderDto.class),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 402, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "CustomerOrderDto", value = "Объект CustomerOrderDto для создания",
            required = true) @RequestBody CustomerOrderDto customerOrderDto) {
        customerOrderService.create(customerOrderDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление CustomerOrderDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "CustomerOrderDto", value = "Объект CustomerOrderDto для обновления",
            required = true) @RequestBody CustomerOrderDto customerOrderDto) {
        customerOrderService.update(customerOrderDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Обновляет параметр рассчитываемого объекта c выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление CustomerOrderDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id CustomerOrderDto для удаления", required = true)
                                        @PathVariable Long id) {
        checkEntityService.checkExist(id, repository, "CustomerOrder");
        customerOrderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
