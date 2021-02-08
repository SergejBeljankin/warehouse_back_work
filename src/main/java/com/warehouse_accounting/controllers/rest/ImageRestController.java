package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.ImageDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.warehouse_accounting.services.interfaces.ImageService;

import java.util.List;

/*
GET api/image - получить список всех складов
GET api/image/3 - получить склад номер 3
PUT api/image - изменить склад номер 3
POST api/image - добавить склад
DELETE api/image/3 - удалить склад номер 3

https://gitlab.com/Sidorenkomv/warehouse_back/-/merge_requests/70/diffs 08/02/21 19:26
List<ImageDto> getAll();
ImageDto getById(Long id);
void create(ImageDto dto);
void update(ImageDto dto);
void deleteById(Long id);
 */

@RestController
@RequestMapping("/api/image")
public class ImageRestController {
    private final ImageService imageService;

    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public List<ImageDto> getAll() {
        return imageService.getAll();
    }

    @GetMapping("/{id}")
    public ImageDto getById(@PathVariable("id") Long id) {
        return imageService.getById();
    }

    @PutMapping("/")
    public void update(@RequestBody ImageDto imageDto) {
        imageService.update(imageDto);
    }

    @PostMapping("/")
    public void create(@RequestBody ImageDto imageDto) {
        imageDto.create(imageDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        imageService.deleteById(id);
    }

}
