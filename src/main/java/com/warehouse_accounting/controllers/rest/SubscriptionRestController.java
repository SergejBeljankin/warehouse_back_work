package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.PaymentDto;
import com.warehouse_accounting.models.dto.SubscriptionDto;
import com.warehouse_accounting.repositories.SubscriptionRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.SubscriptionService;
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
@RequestMapping("api/subscription")
@Api(tags = "Payment Rest Controller")
@Tag(name = "Payment Rest Controller", description = "CRUD операции с объектами")
public class SubscriptionRestController {

    private final SubscriptionService subscriptionService;
    private final CheckEntityService checkEntityService;
    private final SubscriptionRepository repository;

    public SubscriptionRestController(SubscriptionService subscriptionService, CheckEntityService checkEntityService, SubscriptionRepository repository) {
        this.subscriptionService = subscriptionService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все параметры рассчитываемого объекта", notes = "Возвращает список Subscription",
            response = SubscriptionDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа SubscriptionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<SubscriptionDto>> getAll() {
        return ResponseEntity.ok(subscriptionService.getAll());
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает параметр рассчитываемого объекта с выбранным id", notes = "Возвращает SubscriptionDto",
            response = SubscriptionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение SubscriptionDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 402, message = "Нет доступа к данной операции")})
    public ResponseEntity<SubscriptionDto> getById(@ApiParam(name = "id", value = "Id нужного SubscriptionDto", required = true)
                                              @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Subscription");
        return ResponseEntity.ok(subscriptionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание SubscriptionDto",
                    response = PaymentDto.class),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 402, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "SubscriptionDto", value = "Объект SubscriptionDto для создания",
            required = true) @RequestBody SubscriptionDto subscriptionDto) {
        subscriptionService.create(subscriptionDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный параметр рассчитываемого объекта")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление SubscriptionDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "SubscriptionDto", value = "Объект SubscriptionDto для обновления",
            required = true) @RequestBody SubscriptionDto subscriptionDto) {
        checkEntityService.checkExist(subscriptionDto.getId(), repository, "Subscription");
        subscriptionService.update(subscriptionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Обновляет параметр рассчитываемого объекта c выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление SubscriptionDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id SubscriptionDto для удаления", required = true)
                                        @PathVariable Long id) {
        checkEntityService.checkExist(id, repository, "Subscription");
        subscriptionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
