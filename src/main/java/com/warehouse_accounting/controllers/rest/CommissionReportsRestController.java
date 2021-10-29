package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CommissionReportsDto;
import com.warehouse_accounting.repositories.CommissionReportsRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.CommissionReportsService;
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
@RequestMapping("/api/commission_reports")
@Api(tags = "CommissionReports Rest Controller")
@Tag(name = "CommissionReports Rest Controller", description = "API для работы с Отчеты комиссионера")
public class CommissionReportsRestController {
    private static final String CHECK_NAME ="CommissionReports";
    private final CommissionReportsService commissionReportsService;
    private final CheckEntityService checkEntityService;
    private final CommissionReportsRepository repository;

    public CommissionReportsRestController(CommissionReportsService commissionReportsService, CheckEntityService checkEntityService, CommissionReportsRepository repository) {
        this.commissionReportsService = commissionReportsService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех отчетов коммиссионера",
            response = CommissionReportsDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешно получены все отчеты коммиссионера"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<List<CommissionReportsDto>> getAll(){
        return ResponseEntity.ok(commissionReportsService.getAll());
    }


    @GetMapping("{id}")
    @ApiOperation(
            value = "getById",
            notes = "Получение отчета коммиссионера по id",
            response = CommissionReportsDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение отчета коммиссионера по id"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<CommissionReportsDto> getById(@ApiParam(name = "id", value = "id для получения отчетов коммиссионера", required = true)
                                               @PathVariable("id") Long id){
        checkEntityService.checkExist(id,repository,CHECK_NAME);
        return ResponseEntity.ok(commissionReportsService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание отчетов коммиссионера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание отчета коммиссионера"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "CommissionReportsDto", value = "CommissionReportsDto для создания отчетов коммиссионера", required = true)
                                                        @RequestBody CommissionReportsDto commissionReportsDto) {
        commissionReportsService.create(commissionReportsDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Редактирование отчетов коммиссионера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное редактирование отчетов коммиссионера"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "CommissionReportsDto", value = "CommissionReportsDto для редактирования отчетов коммиссионера", required = true)
                                                        @RequestBody CommissionReportsDto commissionReportsDto) {
        checkEntityService.checkExist(commissionReportsDto.getId(),repository,CHECK_NAME);
        commissionReportsService.update(commissionReportsDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{id}")
    @ApiOperation(value = "delete", notes = "Удаление отчетов коммиссионера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление отчета коммиссионера"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
    )
    public ResponseEntity<?> delete(@ApiParam(name = "id", value = "id отчета коммиссионера")
                                                        @PathVariable("id") Long id){
        checkEntityService.checkExist(id,repository,CHECK_NAME);
        commissionReportsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
