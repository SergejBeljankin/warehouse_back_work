package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.RecycleBinDto;
import com.warehouse_accounting.services.interfaces.RecycleBinService;
import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recycleBin")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RecycleBinRestController {
    RecycleBinService recycleBinService;

    @GetMapping
    ResponseEntity<List<RecycleBinDto>> getAll() {
        return ResponseEntity.ok(recycleBinService.getAll());
    }
    @GetMapping("{id}")
    ResponseEntity<RecycleBinDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(recycleBinService.getById(id));
    }
}
