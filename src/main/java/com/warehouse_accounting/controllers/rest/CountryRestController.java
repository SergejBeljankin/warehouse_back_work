package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CountryDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.CountryService;
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
@RequestMapping("/api/countries")
@Api(tags = "Country Rest Controller")
@Tag(name = "Country Rest Controller", description = "CRUD операции с Country")
public class CountryRestController {

    private final CountryService countryService;

    private final CheckEntityService checkEntityService;

    public CountryRestController(CountryService countryService, CheckEntityService checkEntityService) {
        this.countryService = countryService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех Country",
            response = CountryDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Country"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<CountryDto>> getAll(){
        return ResponseEntity.ok(countryService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Country по id", response = CountryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Country"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<CountryDto> getById(@ApiParam(name = "id", value = "id для получения Country", required = true)
                                              @PathVariable("id") Long id) {
        checkEntityService.checkExistCountryById(id);
        return ResponseEntity.ok(countryService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового Country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Country"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "CountryDto", value = "CountryDto для создания Country", required = true)
                                    @RequestBody CountryDto countryDto) {
        countryService.create(countryDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление Country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление Country"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "CountryDto", value = "CountryDto для обновления Country", required = true)
                                    @RequestBody CountryDto countryDto) {
        checkEntityService.checkExistCountryById(countryDto.getId());
        countryService.update(countryDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Country по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Country"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id удаляемого Country", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistCountryById(id);
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
