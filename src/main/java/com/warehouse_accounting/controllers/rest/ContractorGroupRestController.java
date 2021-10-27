package com.warehouse_accounting.controllers.rest;


import com.warehouse_accounting.models.dto.ContractorGroupDto;
import com.warehouse_accounting.models.dto.TypeOfContractorDto;
import com.warehouse_accounting.repositories.ContractorGroupRepository;
import com.warehouse_accounting.repositories.ContractorRepository;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.ContractorGroupService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contractor_groups")
@Api(tags = "ContractorGroup Rest")
@Tag(name = "ContractorGroup Rest", description = "controller for doing some CRUD with ContractorGroup")
public class ContractorGroupRestController {

    private final ContractorGroupService contractorGroupService;
    private final CheckEntityService checkEntityService;
    private final ContractorGroupRepository repository;

    public ContractorGroupRestController(ContractorGroupService contractorGroupService,
                                         CheckEntityService checkEntityService, ContractorGroupRepository repository) {
        this.contractorGroupService = contractorGroupService;
        this.checkEntityService = checkEntityService;
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Все группы контрагентов", notes = "return List<ContractorGroupDto>", response = TypeOfContractorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение листа групп контрагентов", response = TypeOfContractorDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<List<ContractorGroupDto>> getAll() {
        List<ContractorGroupDto> contractorGroupDtos = contractorGroupService.getAll();
        return ResponseEntity.ok(contractorGroupDtos);
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "удалить группу контрагента по ID", notes = "return List<ContractorGroupDto>", response = ContractorGroupDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "группа контрагента удалена", response = ContractorGroupDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<ContractorGroupDto> delete(
            @ApiParam(name = "id", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExist(id, repository, "ContractorGroup");
        contractorGroupService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "получить тип контрагента по ID", response = ContractorGroupDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Группа контрагента найден", response = ContractorGroupDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<ContractorGroupDto> getById(
            @ApiParam(name = "id", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExist(id, repository, "ContractorGroup");
        ContractorGroupDto contractorGroupDto = contractorGroupService.getById(id);
        return ResponseEntity.ok(contractorGroupDto);
    }


    @PostMapping
    @ApiOperation(value = "Редактировать данные типа контрагента", response = ContractorGroupDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контагента найден", response = ContractorGroupDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<ContractorGroupDto> update(
            @ApiParam(name = "update typeofContractor")
            @RequestBody ContractorGroupDto contractorGroupDto) {
        checkEntityService.checkExist(contractorGroupDto.getId(), repository, "ContractorGroup");
        contractorGroupService.update(contractorGroupDto);
        return ResponseEntity.ok().build();
    }


    @PutMapping
    @ApiOperation(value = "Создать  тип контрагента", response = ContractorGroupDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Тип контрагента создан", response = ContractorGroupDto.class),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции"),
            @ApiResponse(code = 500, message = "Ошибка сервера")})
    public ResponseEntity<ContractorGroupDto> create(
            @ApiParam(name = "create type of Contractor")
            @RequestBody ContractorGroupDto contractorGroupDto) {
        contractorGroupService.create(contractorGroupDto);
        return ResponseEntity.ok().build();
    }
}
