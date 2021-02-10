package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.CompanyDto;
import com.warehouse_accounting.services.CheckEntityService;
import com.warehouse_accounting.services.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private CheckEntityService checkEntityService;

    @GetMapping("/{id}")
    public CompanyDto getById(@PathVariable long id) {
        checkEntityService.checkExistUnitById(id);
        return companyService.getById(id);
    }

}
