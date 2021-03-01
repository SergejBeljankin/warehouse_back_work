package com.warehouse_accounting.configs;

import com.warehouse_accounting.models.dto.RoleDto;
import com.warehouse_accounting.models.dto.UnitDto;
import com.warehouse_accounting.services.interfaces.RoleService;
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
import java.util.Iterator;

@Log4j2
@Component
public class DataInitializer {

    @Value("${data-init.unit-data}")
    private File unit_init_file;

    private final RoleService roleService;
    private final UnitService unitService;

    public DataInitializer(RoleService roleService, 
                           UnitService unitService) {
        this.roleService = roleService;
        this.unitService = unitService;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initUnits();
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

}
