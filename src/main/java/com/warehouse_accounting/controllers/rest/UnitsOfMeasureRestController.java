package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.UnitsOfMeasureDto;
import com.warehouse_accounting.repositories.UnitsOfMeasureRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.UnitsOfMeasureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("api/measure")
@Api(tags = "UnitsOfMeasure Rest Controller")
@Tag(name = "UnitsOfMeasure Rest Controller",
        description = "CRUD операции с объектами")
public class UnitsOfMeasureRestController {

    private final UnitsOfMeasureService unitsOfMeasureService;

    private final CheckEntityService checkEntityService;

    private final UnitsOfMeasureRepository repository;


    public UnitsOfMeasureRestController(UnitsOfMeasureService unitsOfMeasureService,
                                        CheckEntityService checkEntityService, UnitsOfMeasureRepository repository) {
        this.unitsOfMeasureService = unitsOfMeasureService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список объектов", notes = "Возвращает список UnitsOfMeasureDto",
            response = UnitsOfMeasureDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<List<UnitsOfMeasureDto>> getAll(){
        return ResponseEntity.ok(unitsOfMeasureService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает объект UnitsOfMeasureDto",
            notes = "Возвращает объект UnitsOfMeasureDto по его ID", response = UnitsOfMeasureDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<UnitsOfMeasureDto> getById(@ApiParam(name = "id",
            value = "Id  нужного UnitsOfMeasureDto",
            required = true)@PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "UnitsOfMeasure");
        return ResponseEntity.ok(unitsOfMeasureService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает объект UnitsOfMeasure")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно создался"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "UnitsOfMeasureDto",
            value = "Объект UnitsOfMeasureDto для создания",
            required = true)@RequestBody UnitsOfMeasureDto measureDto){
        unitsOfMeasureService.create(measureDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет объект UnitsOfMeasureDto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "201", description = "Объект успешно обновился"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "UnitsOfMeasureDto",
            value = "Объект UnitsOfMeasureDto для обновления",
            required = true) @RequestBody UnitsOfMeasureDto measureDto) {
        checkEntityService.checkExist(measureDto.getId(), repository, "UnitsOfMeasure");
        unitsOfMeasureService.update(measureDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет объект UnitsOfMeasureDto с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен"),
            @ApiResponse(responseCode = "204", description = "Cервер успешно обработал запрос, но в ответе были переданы только заголовки без тела сообщения"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id",
            value = "Id UnitsOfMeasureDto для удаления",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "UnitsOfMeasure");
        unitsOfMeasureService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
