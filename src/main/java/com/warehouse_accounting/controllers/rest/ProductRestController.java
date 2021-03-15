package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ProductService;
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
@RequestMapping("/api/products")
@Api(tags = "Product Rest Controller")
@Tag(name = "Product Rest Controller", description = "API для работы с Product")
public class ProductRestController {

    private final ProductService productService;
    private final CheckEntityService checkEntityService;

    public ProductRestController(ProductService productService, CheckEntityService checkEntityService) {
        this.productService = productService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех Product",
            response = ProductDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Product"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Product по id", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Product"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ProductDto> getById(@ApiParam(name = "id", value = "id для получения Product", required = true)
                                              @PathVariable("id") Long id) {
        checkEntityService.checkExistProductById(id);
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового Product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Product"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "ProductDto", value = "ProductDto для создания Product", required = true)
                                    @RequestBody ProductDto productDto) {
        productService.create(productDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление Product")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление Product"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "ProductDto", value = "ProjectDto для обновления Product", required = true)
                                    @RequestBody ProductDto productDto) {
        checkEntityService.checkExistProductById(productDto.getId());
        productService.update(productDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Product по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Product"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id удаляемого Product", required = true)
                                        @PathVariable("id") Long id) {
        checkEntityService.checkExistProductById(id);
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
