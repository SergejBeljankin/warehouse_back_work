package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.FeedDto;
import com.warehouse_accounting.models.dto.ImageDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.FeedService;
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
@RequestMapping("/api/feed")
@Api(tags = "Feed Rest Controller")
@Tag(name = "Feed Rest Controller", description = "CRUD операции с объектами")
public class FeedRestController {
    private final FeedService feedService;
    private final CheckEntityService checkEntityService;

    public FeedRestController(FeedService feedService, CheckEntityService checkEntityService) {
        this.feedService = feedService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все новости", notes = "Возвращает список FeedDto",
            response = FeedDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа FeedDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<FeedDto>> getAll() {
        return ResponseEntity.ok(feedService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает новость с выбранным id", notes = "Возвращает FeedDto",
            response = FeedDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение FeedDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<FeedDto> getById(@ApiParam(name = "id", value = "Id нужного FeedDto", required = true)
                                           @PathVariable("id") Long id) {
        checkEntityService.checkExistFeedById(id);
        return ResponseEntity.ok(feedService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданную новость")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление FeedDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "FeedDto", value = "Объект FeedDto для обновления",
            required = true) @RequestBody FeedDto feedDto) {
        checkEntityService.checkExistFeedById(feedDto.getId());
        feedService.update(feedDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Создает переданную новость")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание FeedDto",
                    response = FeedDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "FeedDto", value = "Объект FeedDto для создания",
            required = true) @RequestBody FeedDto feedDto) {
        feedService.create(feedDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет новость с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление FeedDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id FeedDto для удаления", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistFeedById(id);
        feedService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
