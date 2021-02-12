package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ImageDto;
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
import com.warehouse_accounting.services.interfaces.ImageService;

import java.util.List;

@RestController
@Api(tags = "Image Rest Controller")
@Tag(name = "Image Rest Controller", description = "CRUD операции с объектами")
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает все изображения", notes = "Возвращает список ImageDto",
            response = ImageDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа ImageDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<ImageDto>> getAll() {
        return ResponseEntity.ok(imageService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает изображение с выбранным id", notes = "Возвращает ImageDto",
            response = ImageDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение ImageDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<ImageDto> getById(@ApiParam(name = "id", value = "Id нужного ImageDto", required = true)
                            @PathVariable("id") Long id) {
        return ResponseEntity.ok(imageService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Обновляет переданное изображение")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление ImageDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "ImageDto", value = "Объект ImageDto для обновления", required = true)
                       @RequestBody ImageDto imageDto) {
        imageService.update(imageDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Создает переданное изображение")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание ImageDto",
                    response = ImageDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "ImageDto", value = "Объект ImageDto для создания", required = true)
                       @RequestBody ImageDto imageDto) {
        imageService.create(imageDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет изображение с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление ImageDto"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "Id ImageDto для удаления", required = true)
                           @PathVariable("id") Long id) {
        imageService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
