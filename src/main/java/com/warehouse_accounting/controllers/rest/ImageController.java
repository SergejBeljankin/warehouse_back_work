package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ImageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "ImageAPI")
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает все изображения", notes = "Возвращает список ImageDto",
            response = ImageDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа изображений"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public List<ImageDto> getAll() {
        return imageService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает изображение с выбранным id", notes = "Возвращает ImageDto",
            response = ImageDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение изображения"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ImageDto getById(@ApiParam(name = "id", value = "Id of ImageDto", required = true)
                            @PathVariable("id") Long id) {
        return imageService.getById(id);
    }

    @PutMapping("/")
    @ApiOperation(value = "Обновляет переданное изображение")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление изображения"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void update(@ApiParam(name = "ImageDto", value = "object of ImageDto for update", required = true)
                       @RequestBody ImageDto imageDto) {
        imageService.update(imageDto);
    }

    @PostMapping("/")
    @ApiOperation(value = "Создает переданное изображение")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание изображения",
                    response = ImageDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void create(@ApiParam(name = "ImageDto", value = "object of ImageDto for create", required = true)
                       @RequestBody ImageDto imageDto) {
        imageService.create(imageDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет изображение с выбранным id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление изображения"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public void deleteById(@ApiParam(name = "id", value = "Id of ImageDto for delete", required = true)
                           @PathVariable("id") Long id) {
        imageService.deleteById(id);
    }
}
