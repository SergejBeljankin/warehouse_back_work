package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CustomerReturnsDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.CustomerReturnsService;
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
@RequestMapping("/api/customerreturns")
@Api(tags = "CustomerReturns Rest Controller")
@Tag(name = "CustomerReturns Rest Controller", description = "CRUD операции с объектами")
public class CustomerReturnsRestController {
    private final CustomerReturnsService customerReturnsService;
    private final CheckEntityService checkEntityService;

    public CustomerReturnsRestController(CustomerReturnsService customerReturnsService,
                                         CheckEntityService checkEntityService) {
        this.customerReturnsService = customerReturnsService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все возвраты покупателя", notes = "Возвращает список CustomerReturnsDto",
            response = CustomerReturnsDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа CustomerReturnsDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<CustomerReturnsDto>> getAll() {
        return ResponseEntity.ok(customerReturnsService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает возврат покупателя с выбранным id", notes = "CustomerReturnsDto",
            response = CustomerReturnsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение CustomerReturnsDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<CustomerReturnsDto> getById(@ApiParam(name = "id", value = "Id нужного CustomerReturnsDto", required = true)
                                                 @PathVariable("id") Long id) {
        checkEntityService.checkExistCustomerReturnsById(id);
        return ResponseEntity.ok(customerReturnsService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Обновляет выбранный возврат покупателя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление CustomerReturnsDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "CustomerReturnsDto", value = "Объект CustomerReturnsDto для обновления",
            required = true) @RequestBody CustomerReturnsDto customerReturnsDto) {
        checkEntityService.checkExistCustomerReturnsById(customerReturnsDto.getId());
        customerReturnsService.update(customerReturnsDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Создает новый возврат покупателя")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание CustomerReturnsDto",
                    response = CustomerReturnsDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "CustomerReturnsDto", value = "Объект CustomerReturnsDto для создания",
            required = true) @RequestBody CustomerReturnsDto customerReturnsDto) {
        customerReturnsService.create(customerReturnsDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет возврат покупателя с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление CustomerReturnsDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id CustomerReturnsDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistCustomerReturnsById(id);
        customerReturnsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
