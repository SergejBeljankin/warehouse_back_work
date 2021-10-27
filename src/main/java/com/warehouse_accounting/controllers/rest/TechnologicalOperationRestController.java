package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.repositories.TechnologicalOperationRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.TechnologicalOperationService;
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
@RequestMapping("/api/technological_operations")
@Api(tags = "TechnologicalOperation Rest Controller")
@Tag(name = "TechnologicalOperation Rest Controller", description = "API для работы с TechnologicalOperation")
public class TechnologicalOperationRestController {

    private final TechnologicalOperationService technologicalOperationService;
    private final CheckEntityService checkEntityService;
    private final TechnologicalOperationRepository repository;

    public TechnologicalOperationRestController(TechnologicalOperationService technologicalOperationService,
                                                CheckEntityService checkEntityService, TechnologicalOperationRepository repository) {
        this.technologicalOperationService = technologicalOperationService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех TechnologicalOperations",
            response = TechnologicalOperationDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получены все TechnologicalOperations"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<List<TechnologicalOperationDto>> getAll() {
        return ResponseEntity.ok(technologicalOperationService.getAll());
    }

    @GetMapping("{id}")
    @ApiOperation(
            value = "getById",
            notes = "Получение TechnologicalOperations по id",
            response = TechnologicalOperationDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение TechnologicalOperation по id"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<TechnologicalOperationDto> getById(@ApiParam(name = "id", value = "id для получения TechnologicalOperation", required = true)
                                                             @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "TechnologicalOperation");
        return ResponseEntity.ok(technologicalOperationService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание новой TechnologicalOperation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание TechnologicalOperation"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "TechnologicalOperationDto", value = "TechnologicalOperationDto для создания TechnologicalOperation", required = true)
                                    @RequestBody TechnologicalOperationDto technologicalOperationDto) {
        technologicalOperationService.create(technologicalOperationDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Редактирование TechnologicalOperation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное редактирование TechnologicalOperation"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "TechnologicalOperationDto", value = "TechnologicalOperationDto для редактирования TechnologicalOperation", required = true)
                                    @RequestBody TechnologicalOperationDto technologicalOperationDto) {
        checkEntityService.checkExist(technologicalOperationDto.getId(), repository, "TechnologicalOperation");
        technologicalOperationService.update(technologicalOperationDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "delete", notes = "Удаление TechnologicalOperation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление TechnologicalOperation"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<?> delete(@ApiParam(name = "id", value = "id удаляемого TechnologicalOperation")
                                    @PathVariable("id") Long id){
        checkEntityService.checkExist(id, repository, "TechnologicalOperation");
        technologicalOperationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
