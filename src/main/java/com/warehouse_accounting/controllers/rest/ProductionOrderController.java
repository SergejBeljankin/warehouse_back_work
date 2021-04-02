package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ProductionOrderDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ProductionOrderService;
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
@RequestMapping("/api/production_order")
@Api(tags = "ProductionOrder Rest Controller")
@Tag(name = "ProductionOrder Rest Controller", description = "CRUD операции с ProductionOrder")
public class ProductionOrderController {

    private final ProductionOrderService productionOrderService;
    private final CheckEntityService checkEntityService;

    public ProductionOrderController(ProductionOrderService productionOrderService,
                                     CheckEntityService checkEntityService) {
        this.productionOrderService = productionOrderService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех ProductionOrder",
            response = ProductionOrderDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка ProductionOrder"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ProductionOrderDto>> getAll(){
        return ResponseEntity.ok(productionOrderService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "getById",
            notes = "Получение ProductionOrder по id",
            response = ProductionOrderDto.class

    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение ProductionOrder"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ProductionOrderDto> getById(@ApiParam(name = "id", value = "id для получения ProductionOrder",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExistProductionOrderById(id);
        return ResponseEntity.ok(productionOrderService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового ProductionOrder")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание ProductionOrder"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "ProductionOrderDto", value = "ProductionOrderDto для создания ProductionOrder",
            required = true)@RequestBody ProductionOrderDto productionOrderDto){
        productionOrderService.create(productionOrderDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление ProductionOrder")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление ProductionOrder"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "ProductionOrderDto", value = "InvoiceProductDto для обновления ProductionOrder",
            required = true)@RequestBody ProductionOrderDto productionOrderDto) {
        checkEntityService.checkExistProductionOrderById(productionOrderDto.getId());
        productionOrderService.update(productionOrderDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление ProductionOrder по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление ProductionOrder"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id удаляемого ProductionOrder",
            required = true)@PathVariable("id") Long id) {
        checkEntityService.checkExistProductionOrderById(id);
        productionOrderService.delete(id);
        return ResponseEntity.ok().build();
    }

}
