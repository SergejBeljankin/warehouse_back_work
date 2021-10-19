package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.Shipment;
import com.warehouse_accounting.models.dto.ShipmentDto;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ShipmentService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@Api(tags = "Shipment Rest Controller")
@Tag(name = "Shipment Rest Controller", description = "API для работы с отгрузкой")
public class ShipmentRestController {
    private final ShipmentService shipmentService;
    private final CheckEntityService checkEntityService;

    public ShipmentRestController(ShipmentService shipmentService, CheckEntityService checkEntityService) {
        this.shipmentService = shipmentService;
        this.checkEntityService = checkEntityService;
    }


    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех отгрузок",
            response = Shipment.class,
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
            response = TechnologicalOperationDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение отгрузки по id"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<ShipmentDto> getById(@ApiParam(name = "id", value = "id для получения отгрузки", required = true)
                                             @PathVariable("id") Long id){
        checkEntityService.checkExistShipmentId(id);
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
        checkEntityService.checkExistShipmentId(shipmentDto.getId());
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
        checkEntityService.checkExistShipmentId(id);
        shipmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
