package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.WarehouseDto;
import com.warehouse_accounting.services.interfaces.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
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
@RequestMapping("/api")
@Api(value = "WarehouseApi")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }



    @GetMapping(value = "/warehouse", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return all WarehouseDto", notes = "Return List<WarehouseDto>", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = WarehouseDto.class),
            @ApiResponse(code = 404, message = "WarehouseDto not exist"),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    public ResponseEntity<?> getAllWarehouse() {
        List<WarehouseDto> all = warehouseService.getAll();
        return ResponseEntity.ok(all);
    }



    @GetMapping(value = "/warehouse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Return one WarehouseDto by id", notes = "Return WarehouseDto", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = WarehouseDto.class),
            @ApiResponse(code = 404, message = "WarehouseDto not exist"),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    public ResponseEntity<?> getByIdWarehouse(
            @ApiParam(name = "id", value = "Id of WarehouseDto", example = "1", required = true)
            @PathVariable("id") long id) {
        WarehouseDto warehouseDto = warehouseService.getById(id);
        return ResponseEntity.ok(warehouseDto);
    }



    @PostMapping(value = "/warehouse", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create WarehouseDto", notes = "Create WarehouseDto in db", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = WarehouseDto.class),
            @ApiResponse(code = 404, message = "WarehouseDto not exist"),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    public ResponseEntity<?> createWarehouse(
            @ApiParam(name = "WarehouseDto", value = "Wait json object WarehouseDto to create")
            @RequestBody WarehouseDto warehouseDto) {
        warehouseService.create(warehouseDto);
        return ResponseEntity.ok(warehouseDto);
    }



    @PutMapping(value = "/warehouse", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update WarehouseDto", notes = "Update WarehouseDto in db", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = WarehouseDto.class),
            @ApiResponse(code = 404, message = "WarehouseDto not exist"),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    public ResponseEntity<?> updateWarehouse(
            @ApiParam(name = "WarehouseDto", value = "Wait json object WarehouseDto to update")
            @RequestBody WarehouseDto warehouseDto) {
        warehouseService.update(warehouseDto);
        return ResponseEntity.ok(warehouseDto);
    }




    @DeleteMapping(value = "/warehouse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete WarehouseDto", notes = "Update WarehouseDto by id", response = WarehouseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = WarehouseDto.class),
            @ApiResponse(code = 404, message = "WarehouseDto not exist"),
            @ApiResponse(code = 500, message = "Internal server error")}
    )
    public ResponseEntity<?> deleteWarehouse(
            @ApiParam(name = "id", value = "Id WarehouseDto", example = "1", required = true)
            @PathVariable("id") long id) {
        warehouseService.deleteById(id);
        return ResponseEntity.ok().body("User deleted successfully");
    }
}


