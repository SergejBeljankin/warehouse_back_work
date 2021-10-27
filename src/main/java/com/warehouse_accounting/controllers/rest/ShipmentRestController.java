package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ShipmentDto;
import com.warehouse_accounting.repositories.ShipmentRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ShipmentService;
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
@RequestMapping("/api/shipments")
@Api(tags = "Shipment Rest Controller")
@Tag(name = "Shipment Rest Controller", description = "API для работы с отгрузкой")
public class ShipmentRestController {
    private final ShipmentService shipmentService;
    private final CheckEntityService checkEntityService;
    private final ShipmentRepository repository;

    public ShipmentRestController(ShipmentService shipmentService, CheckEntityService checkEntityService, ShipmentRepository repository) {
        this.shipmentService = shipmentService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех отгрузок",
            response = ShipmentDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получены все отгрузки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<List<ShipmentDto>> getAll(){
        return ResponseEntity.ok(shipmentService.getAll());
    }


    @GetMapping("{id}")
    @ApiOperation(
            value = "getById",
            notes = "Получение отгрузки по id",
            response = ShipmentDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение отгрузки по id"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<ShipmentDto> getById(@ApiParam(name = "id", value = "id для получения отгрузки", required = true)
                                             @PathVariable("id") Long id){
        checkEntityService.checkExist(id, repository, "Shipment");
        return ResponseEntity.ok(shipmentService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание отгрузки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание отгрузки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<? extends ShipmentDto> create(@ApiParam(name = "ShipmentDto", value = "ShipmentDto для создания отгрузки", required = true)
                                                      @RequestBody ShipmentDto shipmentDto) {
        shipmentService.create(shipmentDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Редактирование отгрузки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное редактирование отгрузки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<? extends ShipmentDto> update(@ApiParam(name = "ShipmentDto", value = "ShipmentDto для редактирования отгрузки", required = true)
                                                      @RequestBody ShipmentDto shipmentDto) {
        checkEntityService.checkExist(shipmentDto.getId(), repository, "Shipment");
        shipmentService.update(shipmentDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "delete", notes = "Удаление отгрузки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление отгрузки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<? extends ShipmentDto> delete(@ApiParam(name = "id", value = "id отгрузки")
                                                      @PathVariable("id") Long id){
        checkEntityService.checkExist(id, repository, "Shipment");
        shipmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
