package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.FileDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.FileService;
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
@RequestMapping("/api/file")
@Api(tags = "File Rest Controller")
@Tag(name = "File Rest Controller", description = "CRUD операции с объектами")
public class FileRestController {
    private final FileService fileService;
    private final CheckEntityService checkEntityService;

    @Autowired
    public FileRestController(FileService fileService,
                              CheckEntityService checkEntityService) {
        this.fileService = fileService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все файлы", notes = "Возвращает список FileDto",
            response = FileDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа FileDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<FileDto>> getAll() {
        return ResponseEntity.ok(fileService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает файл с выбранным id", notes = "Возвращает FileDto",
            response = FileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение FileDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<FileDto> getById(@ApiParam(name = "id", value = "Id нужного FileDto", required = true)
                                           @PathVariable("id") Long id) {
        checkEntityService.checkExistFileById(id);
        return ResponseEntity.ok(fileService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданный файл")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление FeedDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "FileDto", value = "Объект FileDto для обновления",
            required = true) @RequestBody FileDto fileDto) {
        checkEntityService.checkExistFeedById(fileDto.getId());
        fileService.update(fileDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Создает переданный файл")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание FileDto",
                    response = FileDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "FileDto", value = "Объект FileDto для создания",
            required = true) @RequestBody FileDto fileDto) {
        fileService.create(fileDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет файл с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление FileDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id FileDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistFileById(id);
        fileService.delete(id);
        return ResponseEntity.ok().build();
    }


}
