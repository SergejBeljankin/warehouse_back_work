//package com.warehouse_accounting.controllers.rest;
//
//import com.warehouse_accounting.models.dto.ReturnDto;
//import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
//import com.warehouse_accounting.services.interfaces.CheckEntityService;
//import com.warehouse_accounting.services.interfaces.ReturnService;
//import io.swagger.annotations.*;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@Api(tags = "Return Rest Controller")
//@Tag(name = "Return Rest Controller", description = "API для работы с возвратами")
//public class ReturnRestController {
//    private final ReturnService returnService;
//    private final CheckEntityService checkEntityService;
//
//    public ReturnRestController(ReturnService returnService, CheckEntityService checkEntityService) {
//        this.returnService = returnService;
//        this.checkEntityService = checkEntityService;
//    }
//
//    @GetMapping
//    @ApiOperation(
//            value = "getAll",
//            notes = "Получение списка всех возвратов",
//            response = ReturnDto.class,
//            responseContainer = "List"
//    )
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Успешно получены все возвраты"),
//            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
//            @ApiResponse(code = 403, message = "Операция запрещена"),
//            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
//    )
//    public ResponseEntity<List<ReturnDto>> getAll(){
//        return ResponseEntity.ok(returnService.getAll());
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation(
//            value = "getById",
//            notes = "Получение возврата по id",
//            response = TechnologicalOperationDto.class
//    )
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Успешное получение возврата по id"),
//            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
//            @ApiResponse(code = 403, message = "Операция запрещена"),
//            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
//    )
//    public ResponseEntity<ReturnDto> getById(@ApiParam(name = "id", value = "id для получения возврата", required = true)
//                                             @PathVariable("id") Long id){
////        checkEntityService.checkExistReturnById(id);
//        return ResponseEntity.ok(returnService.getById(id));
//    }
//
//    @PostMapping
//    @ApiOperation(value = "create", notes = "Создание возврата")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Успешное создание возврата"),
//            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
//            @ApiResponse(code = 403, message = "Операция запрещена"),
//            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
//    )
//    public ResponseEntity<? extends ReturnDto> create(@ApiParam(name = "ReturnDto", value = "ReturnDto для создания Return", required = true)
//                                                      @RequestBody ReturnDto returnDto) {
//        returnService.create(returnDto);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping
//    @ApiOperation(value = "update", notes = "Редактирование возврата")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Успешное редактирование возврата"),
//            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
//            @ApiResponse(code = 403, message = "Операция запрещена"),
//            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
//    )
//    public ResponseEntity<? extends ReturnDto> update(@ApiParam(name = "ReturnDto", value = "ReturnDto для редактирования Return", required = true)
//                                                      @RequestBody ReturnDto returnDto) {
////        checkEntityService.checkExistReturnById(returnDto.getId());
//        returnService.update(returnDto);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("{id}")
//    @ApiOperation(value = "delete", notes = "Удаление возврата")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Успешное удаление возврата"),
//            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
//            @ApiResponse(code = 403, message = "Операция запрещена"),
//            @ApiResponse(code = 404, message = "Данный контроллер не найден")}
//    )
//    public ResponseEntity<? extends ReturnDto> delete(@ApiParam(name = "id", value = "id возврата")
//                                                      @PathVariable("id") Long id){
////        checkEntityService.checkExistReturnById(id);
//        returnService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//}