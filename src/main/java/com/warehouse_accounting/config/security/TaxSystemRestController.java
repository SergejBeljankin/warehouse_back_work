package com.warehouse_accounting.config.security;

import com.warehouse_accounting.models.dto.TaxSystemDto;
import com.warehouse_accounting.services.interfaces.TaxSystemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
GET api/image - получить список всех складов
GET api/image/3 - получить склад номер 3
PUT api/image - изменить склад
POST api/image - добавить склад
DELETE api/image/3 - удалить склад номер 3
 */

@RestController
@RequestMapping("/api/TaxSystems")
public class TaxSystemRestController {
    private final TaxSystemService taxSystemService;

    public TaxSystemRestController(TaxSystemService taxSystemService) {
        this.taxSystemService = taxSystemService;
    }

    @GetMapping("/")
    public List<TaxSystemDto> getAll() {
        return taxSystemService.getAll();
    }

    @GetMapping("/{id}")
    public TaxSystemDto getById(@PathVariable("id") Long id) {
        return taxSystemService.getById(id);
    }

    @PutMapping("/")
    public void update(@RequestBody TaxSystemDto taxSystemDto) {
        taxSystemService.update(taxSystemDto);
    }

    @PostMapping("/")
    public void create(@RequestBody TaxSystemDto taxSystemDto) {
        taxSystemService.create(taxSystemDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        taxSystemService.deleteById(id);
    }



}
