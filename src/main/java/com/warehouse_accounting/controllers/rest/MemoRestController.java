package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.MemoDto;
import com.warehouse_accounting.repositories.MemoRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.MemoService;
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
@RequestMapping("/api/memos")
@Api(tags = "Memo Rest Controller")
@Tag(name = "Memo Rest Controller", description = "API для проведения CRUD операций с объектами Memo")
public class MemoRestController {

    private final MemoService memoService;
    private final CheckEntityService checkEntityService;
    private final MemoRepository repository;

    public MemoRestController(MemoService memoService, CheckEntityService checkEntityService, MemoRepository repository) {
        this.memoService = memoService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает из базы данных список всех заметок",
                    notes = "Возвращает список MemoDto",
                    response = MemoDto.class,
                    responseContainer = "List")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Успешное получение списка Memo"),
                    @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
                    @ApiResponse(code = 403, message = "Операция запрещена"),
                    @ApiResponse(code = 404, message = "Данный контроллер не найден"),
                    @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<MemoDto>> getAll(){
        return ResponseEntity.ok(memoService.getAll());
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает из базы данных заметку с указанным id",
                    notes = "Возвращает MemoDto",
                    response = MemoDto.class)
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Успешное получение Memo по id"),
                    @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
                    @ApiResponse(code = 403, message = "Операция запрещена"),
                    @ApiResponse(code = 404, message = "Данный контроллер не найден"),
                    @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<MemoDto> getById(
                    @ApiParam(name = "id", value = "id для получения нужной Memo", required = true)
                    @PathVariable("id") Long id){
        checkEntityService.checkExist(id, repository, "Memo");
        return ResponseEntity.ok(memoService.getById(id));
    }
    
    @PostMapping
    @ApiOperation(value = "Создает новую заметку",
                    notes = "Создает Memo")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Успешное создание Memo"),
                    @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
                    @ApiResponse(code = 403, message = "Операция запрещена"),
                    @ApiResponse(code = 404, message = "Данный контроллер не найден"),
                    @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> create(
                    @ApiParam(name = "MemoDto", value = "Объект MemoDto для создания Memo", required = true)
                    @RequestBody MemoDto memoDto){
        memoService.create(memoDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "Редактирует заметку",
                    notes = "Редактирует Memo")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Успешное редактирование Memo"),
                    @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
                    @ApiResponse(code = 403, message = "Операция запрещена"),
                    @ApiResponse(code = 404, message = "Данный контроллер не найден"),
                    @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> update(
                    @ApiParam(name = "MemoDto", value = "Объект MemoDto для редактирования Memo", required = true)
                    @RequestBody MemoDto memoDto){
        checkEntityService.checkExist(memoDto.getId(), repository, "Memo");
        memoService.update(memoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет из базы данных заметку с указанным id",
                    notes = "Удаляет Memo")
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Успешное удаление Memo"),
                    @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
                    @ApiResponse(code = 403, message = "Операция запрещена"),
                    @ApiResponse(code = 404, message = "Данный контроллер не найден"),
                    @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<?> deleteById(
                    @ApiParam(name = "id", value = "id для удаления Memo", required = true)
                    @PathVariable("id") Long id){
        checkEntityService.checkExist(id, repository, "Memo");
        memoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
