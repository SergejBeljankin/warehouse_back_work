package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.TypeOfPriceDto;
import com.warehouse_accounting.services.interfaces.TypeOfPriceService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfPriceController {

    private final TypeOfPriceService service;

    public TypeOfPriceController(TypeOfPriceService service) {
        this.service = service;
    }

   @GetMapping("/types_of_price")
    public List<TypeOfPriceDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/types_of_price/{id}")
    public TypeOfPriceDto getById(Long id) {
        return service.getById(id);
    }

    @PostMapping("/types_of_price")
    public void create(TypeOfPriceDto typeOfPriceDto) {
        service.create(typeOfPriceDto);
    }

    @PutMapping("/types_of_price")
    public void update(TypeOfPriceDto typeOfPriceDto) {
        service.update(typeOfPriceDto);
    }

    @DeleteMapping("/types_of_price/{id}")
    public void deleteById(Long id) {
        service.deleteById(id);
    }


}



//GET api/types_of_price- получить список всех типов цены
//GET api/types_of_price/3 - получить тип цены номер 3
//POST api/types_of_price- добавить тип цены
//PUT api/types_of_price - изменить тип цены номер 3
//DELETE api/types_of_price/3 - удалить тип цены номер 3