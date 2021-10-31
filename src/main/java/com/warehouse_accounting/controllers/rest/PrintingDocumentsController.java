package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.PrintingDocumentsDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.PrintingDocumentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/printing_documents")
@Api(tags = "PrintingDocuments Rest Controller")
@Tag(name = "PrintingDocuments Rest Controller", description = "API для работы с настройками печати документов")
public class PrintingDocumentsController {
    private final PrintingDocumentsService printingDocumentsService;
    private final CheckEntityService checkEntityService;

    public PrintingDocumentsController(
            PrintingDocumentsService printingDocumentsService, CheckEntityService checkEntityService) {
        this.printingDocumentsService = printingDocumentsService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список настроек печати документов", notes = "Возвращает список PrintingDocumentsDto",
            response = PrintingDocumentsDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек печати документов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<PrintingDocumentsDto>> getAll() {
        return ResponseEntity.ok(printingDocumentsService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает настройки печати документов по id пользователя", notes = "Возвращает PrintingDocumentsDto",
            response =  PrintingDocumentsDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение настроек печати документов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<PrintingDocumentsDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistPrintingDocumentsById(id);
        return ResponseEntity.ok(printingDocumentsService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает настройки печати документов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание настроек печати документов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "PrintingDocumentsDto", value = "Объект PrintingDocumentsDto который нужно сохранить в программе")
            @RequestBody PrintingDocumentsDto printingDocumentsDto) {
        printingDocumentsService.create(printingDocumentsDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет настройки печати документов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение настройки печати документов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "PrintingDocumentsDto", value = "Объект PrintingDocumentsDto который нужно изменить в программе")
            @RequestBody PrintingDocumentsDto printingDocumentsDto) {
        checkEntityService.checkExistPrintingDocumentsById(printingDocumentsDto.getId());
        printingDocumentsService.update(printingDocumentsDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет настройки печати документов по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление настроек печати документов"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistPrintingDocumentsById(id);
        printingDocumentsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
