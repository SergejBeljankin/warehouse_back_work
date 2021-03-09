package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.LegalDetail;
import com.warehouse_accounting.models.dto.LegalDetailDto;
import com.warehouse_accounting.services.interfaces.CheckEntityService;
import com.warehouse_accounting.services.interfaces.LegalDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
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
@RequestMapping("/api/legal_details")
@Api(tags = "LegalDetail Rest Controller")
@Tag(name = "LegalDetail Rest Controller", description = "API для работы с юрдической информацией")
public class LegalDetailRestController {
    private final LegalDetailService legalDetailService;
    private final CheckEntityService checkEntityService;

    public LegalDetailRestController(LegalDetailService legalDetailService,
                                     CheckEntityService checkEntityService) {
        this.legalDetailService = legalDetailService;
        this.checkEntityService = checkEntityService;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает список по юрдической информации", notes = "Возвращает список LegalDetailDto", response = LegalDetailDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение листа юрдической информациии"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<List<LegalDetailDto>> getAll() {
        return ResponseEntity.ok(legalDetailService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает юрдическую информацию по id", notes = "Возвращает LegalDetailDto", response = LegalDetailDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение юридической информации"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<LegalDetailDto> getById(
            @ApiParam(name = "id", value = "Значение поля Id объекта которого хотим получить", example = "1", required = true)
            @PathVariable("id") Long id) {
        checkEntityService.checkExistLegalDetailById(id);
        return ResponseEntity.ok(legalDetailService.getById(id));
    }

    @PutMapping
    @ApiOperation(value = "Создает юрдическую информацию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание юридической информации"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> create(
            @ApiParam(name = "LegalDetailDto", value = "Объект LegalDetailDto который нужно обновить в программе")
            @RequestBody LegalDetailDto legalDetailDto) {
        legalDetailService.create(legalDetailDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @ApiOperation(value = "Изменяет юрдическую информацию")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное изменение юридической информации"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> update(
            @ApiParam(name = "LegalDetailDto", value = "Объект LegalDetailDto который нужно сохранить в программе")
            @RequestBody LegalDetailDto legalDetailDto) {
        checkEntityService.checkExistLegalDetailById(legalDetailDto.getId());
        legalDetailService.update(legalDetailDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет юрдическую информацию по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное удаление юридической информации"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    public ResponseEntity<?> deleteById(
            @ApiParam(name = "id", value = "Значение поля Id объекта который хотим удалить", example = "1", required = true)
            @PathVariable("id") long id) {
        checkEntityService.checkExistLegalDetailById(id);
        legalDetailService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    @ApiOperation(value = "Возвращает отфильтрованный список по юрдической информации", notes = "Возвращает отфильтрованный список LegalDetailDto", response = LegalDetailDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное получение листа юрдической информациии"),
            @ApiResponse(responseCode = "404", description = "Данный контролер не найден"),
            @ApiResponse(responseCode = "403", description = "Операция запрещена"),
            @ApiResponse(responseCode = "401", description = "Нет доступа к данной операции")}
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lastName", value = "Значение поля lastName объекта по которому хотим отфильтровать, example: String", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "firstName", value = "Значение поля firstName объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "middleName", value = "Значение поля middleName объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "commentToAddress", value = "Значение поля commentToAddress объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "inn", value = "Значение поля inn объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "okpo", value = "Значение поля okpo объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "ogrnip", value = "Значение поля ogrnip объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "numberOfTheCertificate", value = "Значение поля ogrnip объекта по которому хотим отфильтровать, example: String", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "dateOfTheCertificateBetween", value = "Значение поля dateOfTheCertificate c/по дату для фильтрации, example: 2021-03-01;2021-03-10", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "dateOfTheCertificateEquals", value = "Значение поля dateOfTheCertificate объекта по которому хотим отфильтровать, example: 2021-03-08", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "typeOfContractorName", value = "Значение поля typeOfContractor - name объекта по которому хотим отфильтровать, example: string", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "typeOfContractorId", value = "Значение поля typeOfContractor - id объекта по которому хотим отфильтровать, example: 1", dataType = "string", paramType = "query")
    })
    public ResponseEntity<List<LegalDetailDto>> filterBySpecification(
            @Join(path = "typeOfContractor", alias = "toc")
            @And({
                    @Spec(path = "lastName", spec = Equal.class),
                    @Spec(path = "middleName", spec = Equal.class),
                    @Spec(path = "commentToAddress", spec = Equal.class),
                    @Spec(path = "inn", spec = Equal.class),
                    @Spec(path = "okpo", spec = Equal.class),
                    @Spec(path = "ogrnip", spec = Equal.class),
                    @Spec(path = "numberOfTheCertificate", spec = Equal.class),
                    @Spec(path = "dateOfTheCertificate", params = "dateOfTheCertificateBetween", paramSeparator = '\u003B', config = "yyyy-MM-dd", spec = Between.class),
                    @Spec(path = "dateOfTheCertificate", params = "dateOfTheCertificateEquals", config = "yyyy-MM-dd", spec = Equal.class),
                    @Spec(path = "toc.name", params = "typeOfContractorName", spec = Equal.class),
                    @Spec(path = "toc.id", params = "typeOfContractorId", spec = Equal.class)
            }) Specification<LegalDetail> specification) {
        return ResponseEntity.ok(legalDetailService.getAllBySpecification(specification));
    }
}
