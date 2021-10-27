package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ProjectDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.repositories.ProjectRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ProjectService;
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
@RequestMapping("/api/projects")
@Api(tags = "Project Rest Controller")
@Tag(name = "Project Rest Controller", description = "CRUD операции с Project")
public class ProjectRestController {

    private final ProjectService projectService;
    private final CheckEntityService checkEntityService;
    private final ProjectRepository repository;

    public ProjectRestController(ProjectService projectService, CheckEntityService checkEntityService, ProjectRepository repository) {
        this.projectService = projectService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(
            value = "getAll",
            notes = "Получение списка всех Project",
            response = ProjectDto.class,
            responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение списка Project"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<ProjectDto>> getAll(){
        return ResponseEntity.ok(projectService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getById", notes = "Получение Project по id", response = ProjectDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение Project"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<ProjectDto> getById(@ApiParam(name = "id", value = "id для получения Project", required = true)
                                                  @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Project");
        return ResponseEntity.ok(projectService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "create", notes = "Создание нового Project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное создание Project"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(@ApiParam(name = "ProjectDto", value = "ProjectDto для создания Project", required = true)
                                        @RequestBody ProjectDto projectDto) {
        projectService.create(projectDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation(value = "update", notes = "Обновление Project")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное обновление Project"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(@ApiParam(name = "ProjectDto", value = "ProjectDto для обновления Project", required = true)
                                        @RequestBody ProjectDto projectDto) {
        checkEntityService.checkExist(projectDto.getId(), repository, "Project");
        projectService.update(projectDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteById", notes = "Удаление Project по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное удаление Project"),
            @ApiResponse(code = 404, message = "Данный контроллер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(@ApiParam(name = "id", value = "id удаляемого Project", required = true)
                                            @PathVariable("id") Long id) {
        checkEntityService.checkExist(id, repository, "Project");
        projectService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
