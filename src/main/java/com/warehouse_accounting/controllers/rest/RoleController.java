package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.services.interfaces.RoleService;
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
@Api(value = "RoleApi")
public class RoleController {

        private final RoleService roleService;
        public RoleController(RoleService roleService) {
            this.roleService = roleService;
        }



        @GetMapping(value = "/role")
        @ApiOperation(value = "Return all RoleDto", notes = "Return List<RoleDto>", response = RoleDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successful", response = RoleDto.class),
                @ApiResponse(code = 404, message = "RoleDto not exist"),
                @ApiResponse(code = 500, message = "Internal server error")}
        )
        public ResponseEntity<?> getAll() {
            List<RoleDto> all = roleService.getAll();
            return ResponseEntity.ok(all);
        }

        @GetMapping(value = "/role/{id}")
        @ApiOperation(value = "Return one WarehouseDto by id", notes = "Return WarehouseDto", response = RoleDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successful", response = RoleDto.class),
                @ApiResponse(code = 404, message = "RoleDto not exist"),
                @ApiResponse(code = 500, message = "Internal server error")}
        )
        public ResponseEntity<?> getById(
                @ApiParam(name = "id", value = "Id of RoleDto", example = "1", required = true)
                @PathVariable("id") long id) {
            RoleDto roleDto = roleService.getById(id);
            return ResponseEntity.ok(roleDto);
        }

        @PostMapping(value = "/role")
        @ApiOperation(value = "Create RoleDto", notes = "Create RoleDto in db", response = RoleDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successful", response = RoleDto.class),
                @ApiResponse(code = 404, message = "RoleDto not exist"),
                @ApiResponse(code = 500, message = "Internal server error")}
        )
        public ResponseEntity<?> createRole(
                @ApiParam(name = "RoleDto", value = "Wait json object WarehouseDto to create")
                @RequestBody RoleDto roleDto) {
            roleService.create(roleDto);
            return ResponseEntity.ok(roleDto);
        }

        @PutMapping(value = "/role")
        @ApiOperation(value = "Update RoleDto", notes = "Update RoleDto in db", response = RoleDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successful", response = RoleDto.class),
                @ApiResponse(code = 404, message = "RoleDto not exist"),
                @ApiResponse(code = 500, message = "Internal server error")}
        )
        public ResponseEntity<?> updateWarehouse(
                @ApiParam(name = "RoleDto", value = "Wait json object RoleDto to update")
                @RequestBody RoleDto roleDto) {
            roleService.update(roleDto);
            return ResponseEntity.ok(roleDto);
        }

        @DeleteMapping(value = "/role/{id}")
        @ApiOperation(value = "Delete RoleDto", notes = "Update RoleDto by id", response = RoleDto.class)
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successful", response = RoleDto.class),
                @ApiResponse(code = 404, message = "RoleDto not exist"),
                @ApiResponse(code = 500, message = "Internal server error")}
        )
        public ResponseEntity<?> deleteRole(
                @ApiParam(name = "id", value = "Id RoleDto", example = "1", required = true)
                @PathVariable("id") long id) {
            roleService.deleteById(id);
            return ResponseEntity.ok().body("User deleted successfully");
        }
    }