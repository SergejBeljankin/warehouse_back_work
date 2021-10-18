package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ProductGroupService;
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
@RequestMapping("/api/product_groups")
@Api(tags = "Product Group Rest Controller")
@Tag(name = "Product Group Rest Controller", description = "CRUD операции с объектами")
public class ProductGroupRestController {

    private final ProductGroupService productGroupService;
    private final CheckEntityService checkEntityService;

    public ProductGroupRestController(ProductGroupService productGroupService, 
                                      CheckEntityService checkEntityService) {
        this.productGroupService = productGroupService;
        this.checkEntityService = checkEntityService;
    }


    @GetMapping
    @ApiOperation(value = "Возвращает список ProductGroupDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка ProductGroupDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<ProductGroupDto>> getAll() {
        return ResponseEntity.ok(productGroupService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает ProductGroupDto по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение ProductGroupDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<ProductGroupDto> getById(@ApiParam(name = "id", value = "id для получения ProductGroupDto",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExistProductGroupById(id);
        return ResponseEntity.ok(productGroupService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "Создает ProductGroupDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание ProductGroupDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> create(@ApiParam(name = "ProductGroupDto", value = "объект ProductGroupDto для создания",
            required = true) @RequestBody ProductGroupDto productGroupDto) {
        productGroupService.create(productGroupDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Обновляет ProductGroupDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление ProductGroupDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> update(@ApiParam(name = "ProductGroupDto", value = "объект ProductGroupDto для обновления",
            required = true) @RequestBody ProductGroupDto productGroupDto) {
        checkEntityService.checkExistProductGroupById(productGroupDto.getId());
        productGroupService.update(productGroupDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет ProductGroupDto по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление ProductGroupDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id для удаления ProductGroupDto",
            required = true) @PathVariable("id") Long id) {
        checkEntityService.checkExistProductGroupById(id);
        productGroupService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("parent/{id}")
    @ApiOperation(value = "Нахолдит ProductGroupDto по parentId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение ProductGroupDto"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")})
    public ResponseEntity<List<ProductGroupDto>> getAllByParentId(@ApiParam(name = "id", value = "id для поиска ProductGroupDto по parentId",
            required = true)@PathVariable Long id){
    checkEntityService.checkExistProductGroupById(id);
    return ResponseEntity.ok(productGroupService.getAllIds(id));
    }
}
