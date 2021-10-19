package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.SupplyDto;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.SupplyService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplys")
@Api(tags = "Supply Rest Controller")
@Tag(name = "Supply Rest Controller", description = "API для работы с приемкой")
public class SupplyRestController {
    private final SupplyService supplyService;
    private final CheckEntityService checkEntityService;

    public SupplyRestController(SupplyService supplyService, CheckEntityService checkEntityService) {
        this.supplyService = supplyService;
        this.checkEntityService = checkEntityService;
    }
    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех приемок",
            response = SupplyDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получены все приемки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<List<SupplyDto>> getAll(){
        return ResponseEntity.ok(supplyService.getAll());
    }


    @GetMapping("{id}")
    @ApiOperation(
            value = "getById",
            notes = "Получение приемки по id",
            response = TechnologicalOperationDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение приемки по id"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<SupplyDto> getById(@ApiParam(name = "id", value = "id для получения приемки", required = true)
                                                   @PathVariable("id") Long id){
        checkEntityService.checkExistSupplyId(id);
        return ResponseEntity.ok(supplyService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание приемки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание приемки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<? extends SupplyDto> create(@ApiParam(name = "SupplyDto", value = "SupplyDto для создания Supply", required = true)
                                                      @RequestBody SupplyDto supplyDto) {
        supplyService.create(supplyDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Редактирование приемки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное редактирование приемки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<? extends SupplyDto> update(@ApiParam(name = "SupplyDto", value = "SupplyDto для редактирования Supply", required = true)
                                                      @RequestBody SupplyDto supplyDto) {
        checkEntityService.checkExistSupplyId(supplyDto.getId());
        supplyService.update(supplyDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "delete", notes = "Удаление приемки")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление приемки"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<? extends SupplyDto> delete(@ApiParam(name = "id", value = "id приемки")
                                    @PathVariable("id") Long id){
        checkEntityService.checkExistSupplyId(id);
        supplyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
