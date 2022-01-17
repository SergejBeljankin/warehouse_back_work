package com.warehouse_accounting.configs;

import com.warehouse_accounting.models.BonusTransaction;
import com.warehouse_accounting.models.MovingFields;
import com.warehouse_accounting.models.TypeOfAdjustment;
import com.warehouse_accounting.models.TypeOfPayment;
import com.warehouse_accounting.models.dto.*;
import com.warehouse_accounting.services.interfaces.*;
import com.warehouse_accounting.util.ConverterDto;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.time.DateUtils;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
public class DataInitializer {

    @Value("${data-init.unit-data}")
    private File unit_init_file;

    private final ApplicationService applicationService;
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
    private final ContractorService contractorService;
    private final ContractorGroupService contractorGroupService;
    private final TypeOfPriceService typeOfPriceService;
    private final BankAccountService bankAccountService;
    private final LegalDetailService legalDetailService;
    private final TypeOfContractorService typeOfContractorService;
    private final AdjustmentService adjustmentService;
    private final ProjectService projectService;
    private final CompanyService companyService;
    private final ContractService contractService;
    private final PaymentService paymentService;
    private final TariffService tariffService;
    private final RequisitesService requisitesService;
    private final SubscriptionService subscriptionService;
    private final ProductGroupService productGroupService;
    private final FeedService feedService;
    private final BonusTransactionService bonusTransactionService;
    private final SupplyService supplyService;
    private final ShipmentService shipmentService;
    private final CommissionReportsService commissionReportsService;
    private final CustomerReturnsService customerReturnsService;

    public DataInitializer(ApplicationService applicationService,
                           RoleService roleService,
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
                           PositionService positionService,
                           ContractorService contractorService,
                           ContractorGroupService contractorGroupService,
                           TypeOfPriceService typeOfPriceService,
                           BankAccountService bankAccountService,
                           LegalDetailService legalDetailService,
                           TypeOfContractorService typeOfContractorService,
                           AdjustmentService adjustmentService,
                           ProjectService projectService,
                           CompanyService companyService,
                           ContractService contractService,
                           PaymentService paymentService,
                           TariffService tariffService,
                           RequisitesService requisitesService,
                           SubscriptionService subscriptionService,
                           ProductGroupService productGroupService,
                           FeedService feedService,
                           SupplyService supplyService,
                           ShipmentService shipmentService,
                           BonusTransactionService bonusTransactionService,
                           CommissionReportsService commissionReportsService,
                           CustomerReturnsService customerReturnsService) {
        this.applicationService = applicationService;
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
        this.contractorService = contractorService;
        this.contractorGroupService = contractorGroupService;
        this.typeOfPriceService = typeOfPriceService;
        this.bankAccountService = bankAccountService;
        this.legalDetailService = legalDetailService;
        this.typeOfContractorService = typeOfContractorService;
        this.adjustmentService = adjustmentService;
        this.projectService = projectService;
        this.companyService = companyService;
        this.contractService = contractService;
        this.paymentService = paymentService;
        this.tariffService = tariffService;
        this.requisitesService = requisitesService;
        this.subscriptionService = subscriptionService;
        this.productGroupService = productGroupService;
        this.feedService = feedService;
        this.bonusTransactionService = bonusTransactionService;
        this.supplyService = supplyService;
        this.shipmentService = shipmentService;
        this.commissionReportsService = commissionReportsService;
        this.customerReturnsService = customerReturnsService;
    }

    @PostConstruct
    public void init() {
        initApplications();
        initRoles();
        initUnits();
        initProduct();
        initTechnologicalMap();
        initTechnologicalOperation();
        initDepartment();
        initImage();
        initPosition();
        initEmployees();
        initContractorGroup();
        initTypeOfContractor();
        initLegalDetail();
        initBankAccount();
        initTypeOfPrice();
        initContractors();
        initCalls();
        initTask();
        initProject();
        initCompany();
        initAdjustments();
        initContract();
        initPayment();
        initTariff();
        initRequisites();
        initSubscription();
        initProductGroup();
        initFeed();
        initBonusTransaction();
        initSupply();
        initShipment();
        initCommissionReports();
    }

    private void initApplications() {
        applicationService.create(ApplicationDto.builder()
                .name("Аналитика BI")
                .description("готовый инструмент для бизнес-анализа (BI) в Yandex.Cloud " +
                        "с использованием средств визуализации DataLens. " +
                        "Приложение содержит готовый набор отчетов, который можно дополнять.")
                .logoId(2L)
                .build()
        );

        applicationService.create(ApplicationDto.builder()
                .name("Интеграция с Treolan")
                .description("поставщиком компьютерного оборудования. " +
                        "Загрузка цен, остатков, описания и фото товара из каталога поставщика. " +
                        "Установка цен закупки.")
                .logoId(3L)
                .build()
        );
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
                    .build());
            taskDtos3.add(new TaskDto().builder()
                    .description("4# Вторая таска для Тех операции 3")
                    .deadline(LocalDateTime.now().plusDays(2))
                    .dateOfCreation(LocalDateTime.now())
                    .documentId(3L)
                    .build());


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
                    .contractorId(1L)
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
                    .tariff(Collections.emptySet())
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

    private void initContractors() {
        try {
            List<TaskDto> taskDtos = new ArrayList<>();
            taskDtos.add(taskService.getById(2L));
            taskDtos.add(taskService.getById(1L));

            contractorService.create(ContractorDto.builder()
                    .id(1L)
                    .name("first_Contractor")
                    .contractorGroupId(1L)
                    .typeOfPriceId(1L)
                    .bankAccountDtos(Collections.EMPTY_LIST)
                    .legalDetailDto(legalDetailService.getById(1L))
                    .taskDtos(taskDtos)
                    .build());
            contractorService.getById(1L).setTaskDtos(taskDtos);
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу Contractors", e);
        }
    }

    private void initContractorGroup() {
        try {
            contractorGroupService.create(ContractorGroupDto.builder()
                    .id(1L)
                    .name("first_ContractorGroup")
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу contractor_grous", e);
        }
    }

    private void initTypeOfPrice() {
        try {
            typeOfPriceService.create(TypeOfPriceDto.builder()
                    .id(1L)
                    .name("firstTypeOfPrice")
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу type_of_prices", e);
        }
    }

    private void initBankAccount() {
        try {
            bankAccountService.create(BankAccountDto.builder()
                    .id(1L)
//                    .name("first_ContractorGroup")
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу bank_accounts", e);
        }
    }

    private void initLegalDetail(){
        try {
            legalDetailService.create(LegalDetailDto.builder()
                    .id(1L)
                    .fullName("firstFullName")
                    .typeOfContractorId(1L)
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу legal_details", e);
        }
    }

    private void initTypeOfContractor() {
        try {
            typeOfContractorService.create(TypeOfContractorDto.builder()
                    .id(1L)
                    .name("firstTypeOfContractorName")
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу type_of_contractors", e);
        }
    }

    private void initAdjustments() {

        adjustmentService.create(AdjustmentDto.builder()
                .id(1L)
                .number("00001")
                .dateTimeAdjustment(LocalDateTime.now())
                .companyId(1L)
                .companyName("Организация1")
                .contractorId(1L)
                .contractorName("first_Contractor")
                .type(TypeOfAdjustment.ACCOUNTBALANCE)
                .currentBalance(BigDecimal.valueOf(1000.00))
                .totalBalance(BigDecimal.valueOf(0.00))
                .adjustmentAmount(BigDecimal.valueOf(1000.00))
                .comment("1 Корректировка")
                .whenСhanged(LocalDateTime.now())
                .build());

        adjustmentService.create(AdjustmentDto.builder()
                .id(2L)
                .number("00002")
                .dateTimeAdjustment(LocalDateTime.now())
                .companyId(1L)
                .companyName("Организация1")
                .contractorId(1L)
                .contractorName("first_Contractor")
                .type(TypeOfAdjustment.CASHBALANCE)
                .currentBalance(BigDecimal.valueOf(1000.00))
                .totalBalance(BigDecimal.valueOf(2000.00))
                .adjustmentAmount(BigDecimal.valueOf(3000.00))
                .comment("2 Корректировка")
                .whenСhanged(LocalDateTime.now())
                .build());

        adjustmentService.create(AdjustmentDto.builder()
                .id(3L)
                .number("00003")
                .dateTimeAdjustment(LocalDateTime.now())
                .companyId(1L)
                .companyName("Организация1")
                .contractorId(1L)
                .contractorName("first_Contractor")
                .type(TypeOfAdjustment.COUNTERPARTY)
                .currentBalance(BigDecimal.valueOf(2000.00))
                .totalBalance(BigDecimal.valueOf(500.00))
                .adjustmentAmount(BigDecimal.valueOf(1500.00))
                .comment("3 Корректировка")
                .whenСhanged(LocalDateTime.now())
                .build());
    }

    private void initPayment() {
        try {
            ContractorDto contractorDto = contractorService.getById(1L);
            CompanyDto companyDto = companyService.getById(1L);
            List<TaskDto> taskDtos = new ArrayList<>();
            taskDtos.add(taskService.getById(1L));
            taskDtos.add(taskService.getById(2L));

            paymentService.create(PaymentDto.builder()
                    .id(1L)
                    .number("1")
                    .amount(BigDecimal.valueOf(10L))
                    .tax(BigDecimal.valueOf(10L))
                    .typeOfPayment(TypeOfPayment.INCOMING_PAYMENT)
                    .projectId(1L)
                    .projectName("Проект")
                    .contractId(1L)
                    .contractNumber("1")
                    .contractorDto(contractorDto)
                    .companyDto(companyDto)
                    .purpose("Цель")
                    .isDone(true)
                    .comment("Комментарий")
                    .documents(new ArrayList<>())
                    .taskDtos(taskDtos)
                    .paymentExpenditureId(1L)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу payments", e);
        }
    }

    private void initCompany() {
        try {
            LegalDetailDto legalDetailDto = legalDetailService.getById(1L);
            companyService.create(CompanyDto.builder()
                    .id(1L)
                    .name("Организация1")
                    .address("Чехова1")
                    .legalDetailDto(legalDetailDto)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу companies", e);
        }
    }

    private void initContract() {
        try {
            BankAccountDto bankAccountDto = bankAccountService.getById(1L);
            ContractorDto contractorDto = contractorService.getById(1L);
            LegalDetailDto legalDetailDto = legalDetailService.getById(1L);
            CompanyDto companyDto = companyService.getById(1L);

            contractService.create(ContractDto.builder()
                    .id(1L)
                    .amount(BigDecimal.valueOf(10L))
                    .bankAccountDto(bankAccountDto)
                    .contractorDto(contractorDto)
                    .legalDetailDto(legalDetailDto)
                    .companyDto(companyDto)
                    .number("1")
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу contracts", e);
        }
    }

    private void initProject() {
        try {
            projectService.create(ProjectDto.builder()
                    .id(1L)
                    .name("Проект1")
                    .description("Описание1")
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу projects", e);
        }
    }

    private void initTariff() {
        try {
            Date dateStart = new Date();
            Date dateEnd = DateUtils.addMonths(dateStart, 12);
            tariffService.create(TariffDto.builder()
                    .id(1L)
                    .tariffName("Базовый")
                    .dataSpace(1)
                    .salePointCount(1)
                    .onlineStoreCount(1)
                    .paidApplicationOptionCount(1)
                    .isCRM(true)
                    .isScripts(true)
                    .extendedBonusProgram(true)
                    .paymentPeriod(1)
                    .totalPrice(1)
                    .dateStartSubscription(dateStart)
                    .dateEndSubscription(dateEnd)
                    .build());

            tariffService.create(TariffDto.builder()
                    .id(1L)
                    .tariffName("Старт")
                    .dataSpace(2)
                    .salePointCount(5)
                    .onlineStoreCount(12)
                    .paidApplicationOptionCount(1)
                    .isCRM(false)
                    .isScripts(true)
                    .extendedBonusProgram(true)
                    .paymentPeriod(1)
                    .totalPrice(1)
                    .dateStartSubscription(dateStart)
                    .dateEndSubscription(dateEnd)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу tariff", e);
        }
    }

    private void initRequisites() {
        try {
            requisitesService.create(RequisitesDto.builder()
                    .id(1L)
                    .organization("JM")
                    .legalAddress("Pobedi street")
                    .INN(123)
                    .KPP(123)
                    .BIK(123)
                    .checkingAccount(123)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу requisites", e);
        }
    }

    private void initSubscription() {
        try {
            Date date = new Date();

            subscriptionService.create(SubscriptionDto.builder()
                    .id(1L)
                    .subscriptionExpirationDate(date)
                    .requisites(requisitesService.getById(1L))
                    .employee(employeeService.getById(1L))
                    .tariff(Collections.emptySet())
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу subscription", e);
        }
    }

    private void initProductGroup() {
        try {
            productGroupService.create(ProductGroupDto.builder()
                    .id(1L)
                    .name("Parent Product")
                    .sortNumber("42")
                    .parentId(2L)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу product_groups", e);
        }

    }

    private void initFeed() {
        try {
            Date date = new Date();
            feedService.create(FeedDto.builder()
                    .id(1L)
                    .feedHead("Заголовок")
                    .feedBody("Тело новости")
                    .feedDate(date)
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу feeds", e);
        }
    }

    private void initBonusTransaction() {
        try {
            bonusTransactionService.create(BonusTransactionDto.builder()
                    .id(1L)
                    .created(LocalDateTime.now())
                    .transactionType(BonusTransaction.TransactionType.EARNING)
                    .bonusValue(500L)
                    .transactionStatus(BonusTransaction.TransactionStatus.COMPLETED)
                    .executionDate(LocalDateTime.now())
                    .bonusProgram("Бонусная программа")
                    .contragent(contractorService.getById(1L))
                    .comment("комментарий")
                    .owner(employeeService.getById(1L))
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу BonusTransaction", e);
        }

    }
private void initSupply(){
    try {
        supplyService.create(SupplyDto.builder()
                .id(1L)
                .dateOfCreation(LocalDateTime.now())
                .contractorId(1L)
                .contractId(1L)
                .companyId(1L)
                .productDtos(List.of(productService.getById(1L),productService.getById(2L)))
                .sum(BigDecimal.valueOf(555))
                .isSent(false)
                .isPrinted(true)
                .comment("text")
                .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу supply", e);
        }
    }

    private void initShipment() {
        try {
            shipmentService.create(ShipmentDto.builder()
                    .id(1L)
                    .dateOfCreation(LocalDateTime.now())
                    .warehouseId(1L)
                    .contractId(1L)
                    .contractorId(1L)
                    .companyId(1L)
                    .sum(BigDecimal.valueOf(777))
                    .productDtos(List.of(productService.getById(2L)))
                    .isSent(true)
                    .isPrinted(true)
                    .comment("Shipment")
                    .consigneeId(1L)
                    .carrierId(1L)
                    .isPaid(true)
                    .deliveryAddress("To the moon")
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу shipment", e);
        }
    }
    private void initCommissionReports(){
        ContractDto contractDto = contractService.getById(1L);
        ContractorDto contractorDto = contractorService.getById(1L);
        CompanyDto companyDto = companyService.getById(1L);
        try {
            commissionReportsService.create(CommissionReportsDto.builder()
                    .id(1L)
                    .dateOfCreation(LocalDateTime.now())
                    .contractDto(contractDto)
                    .contractorDto(contractorDto)
                    .companyDto(companyDto)
                    .sum(BigDecimal.valueOf(555))
                    .paid(BigDecimal.valueOf(333))
                    .isSent(false)
                    .isPrinted(true)
                    .comment("commission")
                    .periodStart(LocalDateTime.now())
                    .reward(BigDecimal.valueOf(132))
                    .build());

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу commissionReports", e);
        }
    }

    private void initCustomerReturns() {
        try {
            customerReturnsService.create(CustomerReturnsDto
                    .builder()
                    .id(1l)
                    .date(LocalDateTime.now())
                    .sum(BigDecimal.valueOf(1000))
                    .isPaid(true)
                    .isSend(true)
                    .comment("polucheno")
                    .warehouseDto(null)
                    .contractDto(contractService.getById(1l))
                    .companyDto(companyService.getById(1l))
                    .contractorDto(contractorService.getById(1l))
                    .productDtos(List.of(productService.getById(1l)))
                    .fileDtos(List.of(null))
                    .taskDtos(List.of(taskService.getById(1l)))
                    .build());
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу CustomerReturns "+ e);
        }
    }
}
