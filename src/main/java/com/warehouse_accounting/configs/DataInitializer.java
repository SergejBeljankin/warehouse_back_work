package com.warehouse_accounting.configs;

import com.warehouse_accounting.models.Department;
import com.warehouse_accounting.models.dto.CallDto;
import com.warehouse_accounting.models.dto.DepartmentDto;
import com.warehouse_accounting.models.dto.EmployeeDto;
import com.warehouse_accounting.models.dto.ImageDto;
import com.warehouse_accounting.models.dto.PositionDto;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.models.dto.TaskDto;
import com.warehouse_accounting.models.dto.TechnologicalMapDto;
import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.models.dto.TechnologicalMapMaterialDto;
import com.warehouse_accounting.models.dto.TechnologicalMapProductDto;
import com.warehouse_accounting.models.dto.TechnologicalOperationDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.services.interfaces.CallService;
import com.warehouse_accounting.services.interfaces.DepartmentService;
import com.warehouse_accounting.services.interfaces.EmployeeService;
import com.warehouse_accounting.services.interfaces.ImageService;
import com.warehouse_accounting.services.interfaces.PositionService;
import com.warehouse_accounting.services.interfaces.ProductService;
import com.warehouse_accounting.services.interfaces.RoleService;
import com.warehouse_accounting.services.interfaces.TaskService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapGroupService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapMaterialService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapProductService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapService;
import com.warehouse_accounting.services.interfaces.TechnologicalOperationService;
import com.warehouse_accounting.services.interfaces.UnitService;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Log4j2
@Component
public class DataInitializer {

    @Value("${data-init.unit-data}")
    private File unit_init_file;

    private final RoleService roleService;
    private final UnitService unitService;
    private final ProductService productService;
    private final TechnologicalMapService technologicalMapService;
    private final TechnologicalMapGroupService technologicalMapGroupService;
    private final TechnologicalMapMaterialService technologicalMapMaterialService;
    private final TechnologicalMapProductService technologicalMapProductService;
    private final TechnologicalOperationService technologicalOperationService;
    private final TaskService taskService;
    private final CallService callService;
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final ImageService imageService;
    private final PositionService positionService;


    public DataInitializer(RoleService roleService,
                           UnitService unitService,
                           ProductService productService,
                           TechnologicalMapService technologicalMapService,
                           TechnologicalMapGroupService technologicalMapGroupService,
                           TechnologicalMapMaterialService technologicalMapMaterialService,
                           TechnologicalMapProductService technologicalMapProductService,
                           TechnologicalOperationService technologicalOperationService,
                           TaskService taskService,
                           CallService callService,
                           EmployeeService employeeService,
                           DepartmentService departmentService,
                           ImageService imageService,
                           PositionService positionService) {
        this.roleService = roleService;
        this.unitService = unitService;
        this.productService = productService;
        this.technologicalMapService = technologicalMapService;
        this.technologicalMapGroupService = technologicalMapGroupService;
        this.technologicalMapMaterialService = technologicalMapMaterialService;
        this.technologicalMapProductService = technologicalMapProductService;
        this.technologicalOperationService = technologicalOperationService;
        this.taskService = taskService;
        this.callService = callService;
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.imageService = imageService;
        this.positionService = positionService;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUnits();
        initProduct();
        initTechnologicalMap();
        initTechnologicalOperation();
        initTask();
        initDepartment();
        initImage();
        initPosition();
        initEmployees();
        initCalls();
    }

    private void initRoles() {
        roleService.create(RoleDto.builder()
                .name("admin")
                .sortNumber("sort_admin")
                .build()
        );

        roleService.create(RoleDto.builder()
                .name("user")
                .sortNumber("sort_user")
                .build()
        );
    }

    public void initUnits() {
        try (FileInputStream fileInputStream = new FileInputStream(unit_init_file)) {
            XSSFSheet sheet = new XSSFWorkbook(fileInputStream).getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                if (currentRow.getRowNum() == 0) {
                    currentRow = rowIterator.next();
                }
                unitService.create(UnitDto.builder()
                        .shortName(currentRow.getCell(0).getStringCellValue())
                        .fullName(currentRow.getCell(1).getStringCellValue())
                        .sortNumber(String.valueOf((long) currentRow.getCell(2).getNumericCellValue()))
                        .build());
            }
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Units", e);
        }
    }

    public void initProduct() {
        try {
            productService.create(
                    ProductDto.builder()
                            .id(1L)
                            .name("Вода")
                            .build()
            );

            productService.create(
                    ProductDto.builder()
                            .id(2L)
                            .name("Газ в балоне")
                            .build()
            );

            productService.create(
                    ProductDto.builder()
                            .id(3L)
                            .name("Бутылка стеклянная")
                            .build()
            );

            productService.create(
                    ProductDto.builder()
                            .id(4L)
                            .name("Газировка")
                            .build()
            );

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Product", e);
        }
    }

    private void initTechnologicalMap() {
        try {
            technologicalMapGroupService.create(
                    TechnologicalMapGroupDto.builder()
                            .name("Группа 1")
                            .code("гр1ст1")
                            .comment("Очень важная группа")
                            .parentTechnologicalMapGroupId(null)
                            .build()
            );
            technologicalMapGroupService.create(
                    TechnologicalMapGroupDto.builder()
                            .name("Группа 2")
                            .code("гр2ст1")
                            .comment("Так себе группа")
                            .parentTechnologicalMapGroupId(null)
                            .build()
            );
            technologicalMapGroupService.create(
                    TechnologicalMapGroupDto.builder()
                            .id(3L)
                            .name("Группа 1-1")
                            .code("гр1ст1_о1")
                            .comment("Не на столько важная группа")
                            .parentTechnologicalMapGroupId(1L)
                            .build()
            );
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу TechnologicalMapGroup", e);
        }

        try {
            technologicalMapService.create(
                    TechnologicalMapDto.builder()
                            .id(1L)
                            .name("Изготовление газировки")
                            .productionCost(BigDecimal.valueOf(100500))
                            .isArchived(false)
                            .comment("Секретный рецепт производства газировки")
                            .materials(null)
                            .finishedProducts(null)
                            .technologicalMapGroupId(1L)
                            .build()
            );

            technologicalMapService.create(
                    TechnologicalMapDto.builder()
                            .name("Технология - найди сам и реализуй")
                            .productionCost(BigDecimal.valueOf(0))
                            .isArchived(false)
                            .comment("Пришел с идеей - ушел с заданием")
                            .materials(null)
                            .finishedProducts(null)
                            .technologicalMapGroupId(2L)
                            .build()
            );

            TechnologicalMapDto technologicalMap = technologicalMapService.getById(1L);

            List<TechnologicalMapMaterialDto> materialDtos = new ArrayList<>();
            materialDtos.add(new TechnologicalMapMaterialDto().builder()
                    .materialId(productService.getById(1L).getId())
                    .materialName(productService.getById(1L).getName())
                    .count(BigDecimal.valueOf(2))
                    .technologicalMapDto(technologicalMap)
                    .build());
            materialDtos.add(new TechnologicalMapMaterialDto().builder()
                    .materialId(productService.getById(2L).getId())
                    .materialName(productService.getById(2L).getName())
                    .count(BigDecimal.valueOf(1))
                    .technologicalMapDto(technologicalMap)
                    .build());
            materialDtos.add(new TechnologicalMapMaterialDto().builder()
                    .materialId(productService.getById(3L).getId())
                    .materialName(productService.getById(3L).getName())
                    .count(BigDecimal.valueOf(1))
                    .technologicalMapDto(technologicalMap)
                    .build());
            materialDtos.forEach(technologicalMapMaterialService::create);

            List<TechnologicalMapProductDto> productDtos = new ArrayList<>();
            productDtos.add(new TechnologicalMapProductDto().builder()
                    .finishedProductId(productService.getById(4L).getId())
                    .finishedProductsName(productService.getById(4L).getName())
                    .count(BigDecimal.valueOf(1))
                    .technologicalMapDto(technologicalMap)
                    .build());
            //technologicalMapProductService.create(productDtos.get(0));
            productDtos.forEach(technologicalMapProductService::create);

            technologicalMap.setMaterials(materialDtos);
            technologicalMap.setFinishedProducts(productDtos);

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу TechnologicalMap", e);
        }
    }

    private void initTechnologicalOperation() {
        try {

            technologicalOperationService.create(
                    TechnologicalOperationDto.builder()
                            .id(1L)
                            .number("Оп-1")
                            .technologicalOperationDateTime(LocalDateTime.now())
                            .technologicalMapId(technologicalMapService.getById(1L).getId())
                            .technologicalMapName(technologicalMapService.getById(1L).getName())
                            .volumeOfProduction(BigDecimal.valueOf(100))
                            .warehouseForMaterialsId(1L)
                            .warehouseForMaterialsName("Основной склад")
                            .warehouseForProductId(1L)
                            .warehouseForProductName("Основной склад")
                            .build());


            technologicalOperationService.create(
                    TechnologicalOperationDto.builder()
                            .id(2L)
                            .number("Оп-2")
                            .technologicalOperationDateTime(LocalDateTime.now().minusDays(1))
                            .technologicalMapId(technologicalMapService.getById(1L).getId())
                            .technologicalMapName(technologicalMapService.getById(1L).getName())
                            .volumeOfProduction(BigDecimal.valueOf(100))
                            .warehouseForMaterialsId(1L)
                            .warehouseForMaterialsName("Основной склад")
                            .warehouseForProductId(1L)
                            .warehouseForProductName("Основной склад")
                            .build());

            TechnologicalOperationDto operationDto = technologicalOperationService.getById(2L);
            List<TaskDto> taskDtos = new ArrayList<>();
            taskDtos.add(new TaskDto().builder()
                    .description("1# Первая таска для Тех операции 2")
                    .deadline(LocalDateTime.now().plusDays(1))
                    .dateOfCreation(LocalDateTime.now())
                    .documentId(operationDto.getId())
                    .build());
            taskDtos.add(new TaskDto().builder()
                    .description("2# Вторая таска для Тех операции 2")
                    .deadline(LocalDateTime.now().plusDays(2))
                    .dateOfCreation(LocalDateTime.now())
                    .documentId(operationDto.getId())
                    .build());
            taskDtos.forEach(taskService::create);

            operationDto.setTasks(taskDtos);

            List<TaskDto> taskDtos3 = new ArrayList<>();
            taskDtos3.add(new TaskDto().builder()
                    .description("3# Первая таска для Тех операции 3")
                    .deadline(LocalDateTime.now().plusDays(1))
                    .dateOfCreation(LocalDateTime.now())
                    .documentId(operationDto.getId())
                    .build());
            taskDtos3.add(new TaskDto().builder()
                    .description("4# Вторая таска для Тех операции 3")
                    .deadline(LocalDateTime.now().plusDays(2))
                    .dateOfCreation(LocalDateTime.now())
                    .documentId(operationDto.getId())
                    .build());
            taskDtos3.forEach(taskService::create);

            technologicalOperationService.create(
                    TechnologicalOperationDto.builder()
                            .id(3L)
                            .number("Оп-3")
                            .technologicalOperationDateTime(LocalDateTime.now().minusDays(5))
                            .technologicalMapId(technologicalMapService.getById(1L).getId())
                            .technologicalMapName(technologicalMapService.getById(1L).getName())
                            .volumeOfProduction(BigDecimal.valueOf(100))
                            .warehouseForMaterialsId(1L)
                            .warehouseForMaterialsName("Основной склад")
                            .warehouseForProductId(1L)
                            .warehouseForProductName("Основной склад")
                            .tasks(taskDtos3)
                            .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу TechnologicalOperation", e);
        }
    }

    private void initTask() {
        try {
            taskService.create(TaskDto.builder()
                    .description("Первая просто задача")
                    .deadline(LocalDateTime.now().plusDays(3))
                    .dateOfCreation(LocalDateTime.now())
                    .build());

            taskService.create(TaskDto.builder()
                    .description("Вторая задача с документом тех операции 1")
                    .deadline(LocalDateTime.now().plusDays(3))
                    .dateOfCreation(LocalDateTime.now())
                    .documentId(1L)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Tasks", e);
        }
    }

    private void initDepartment() {
        try {
            departmentService.create(DepartmentDto.builder()
                    .id(1L)
                    .name("departmentName")
                    .sortNumber("sortNumber")
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Department", e);
        }
    }

    private void initPosition() {
        try {
            positionService.create(PositionDto.builder()
                    .id(1L)
                    .name("departmentName")
                    .sortNumber("sortNumber")
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Positions", e);
        }
    }

    private void initImage() {
        try {
            imageService.create(ImageDto.builder()
                    .id(1L)
                    .imageUrl("imageUrl")
                    .sortNumber("sortNumber")
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Images", e);
        }
    }

    private void initEmployees() {
        try {
            employeeService.create(EmployeeDto.builder()
                    .id(1L)
                    .lastName("lastName")
                    .firstName("firstName")
                    .middleName("middleName")
                    .sortNumber("sortNumber")
                    .phone("phone")
                    .inn("inn")
                    .description("description")
                    .email("some@mail.ru")
                    .password("password")
                    .department(departmentService.getById(1L))
                    .position(positionService.getById(1L))
                    .image(imageService.getById(1L))
                    .roles(Collections.emptySet())
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Employees", e);
        }
    }


    private void initCalls() {
        try {
            callService.create(CallDto.builder()
                    .id(1L)
                    .callTime(null)
                    .type("someType")
                    .number(1234567890L)
                    .callDuration(100L)
                    .comment("comment")
                    .callRecord("callRecord")
                    .whenChanged(null)
                    .contractorName(null)
                    .contractorId(null)
                    .employeeWhoChangedName("null")
                    .employeeWhoChangedId(1L)
                    .employeeWhoCalledName("null")
                    .employeeWhoCalledId(1L)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Calls", e);
        }
    }

}
