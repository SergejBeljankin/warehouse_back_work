package com.warehouse_accounting.configs;

import com.warehouse_accounting.models.Product;
import com.warehouse_accounting.models.dto.AttributeOfCalculationObjectDto;
import com.warehouse_accounting.models.dto.ContractorDto;
import com.warehouse_accounting.models.dto.ProductDto;
import com.warehouse_accounting.models.dto.ProductGroupDto;
import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.models.dto.TechnologicalMapGroupDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.services.interfaces.ProductService;
import com.warehouse_accounting.services.interfaces.RoleService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapGroupService;
import com.warehouse_accounting.services.interfaces.TechnologicalMapService;
import com.warehouse_accounting.services.interfaces.UnitService;
import com.warehouse_accounting.util.ConverterDto;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

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


    public DataInitializer(RoleService roleService,
                           UnitService unitService,
                           ProductService productService,
                           TechnologicalMapService technologicalMapService,
                           TechnologicalMapGroupService technologicalMapGroupService) {
        this.roleService = roleService;
        this.unitService = unitService;
        this.productService = productService;
        this.technologicalMapService = technologicalMapService;
        this.technologicalMapGroupService = technologicalMapGroupService;

    }

    @PostConstruct
    public void init() {
        initRoles();
        initUnits();
        initProduct();
        initTechnologicalMap();
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

    public void initProduct(){
        try {
            productService.create(
                    ProductDto.builder()
                            .id(1L)
                            .name("Вода")
                            .weight(null)
                            .volume(null)
                            .purchasePrice(null)
                            .description(null)
                            .unitDto(null)
                            .archive(false)
                            .contractorDto(new ContractorDto())
                            .productPricesDto(new ArrayList<>())
                            .taxSystemDto(new TaxSystemDto())
                            .imagesDto(new ArrayList<>())
                            .productGroupDto(new ProductGroupDto())
                            .attributeOfCalculationObjectDto(new AttributeOfCalculationObjectDto())
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
                            .parentTechnologicalMapGroupName(null)
                            .build()
            );
            technologicalMapGroupService.create(
                    TechnologicalMapGroupDto.builder()
                            .name("Группа 2")
                            .code("гр2ст1")
                            .comment("Так себе группа")
                            .parentTechnologicalMapGroupId(null)
                            .parentTechnologicalMapGroupName(null)
                            .build()
            );
            technologicalMapGroupService.create(
                    TechnologicalMapGroupDto.builder()
                            .id(3L)
                            .name("Группа 1-1")
                            .code("гр1ст1_о1")
                            .comment("Не на столько важная группа")
                            .parentTechnologicalMapGroupId(1L)
                            .parentTechnologicalMapGroupName("Группа 1")
                            .build()
            );
        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу TechnologicalMapGroup", e);
        }

        try {

        } catch (Exception e) {
            log.error("Не удалось заполнить таблицу TechnologicalMap", e);
        }
    }
}
