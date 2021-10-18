package com.warehouse_accounting.controllers.rest;

import com.warehouse_accounting.models.dto.RecycleBinDto;
import com.warehouse_accounting.services.interfaces.RecycleBinService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recycle-bin")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class RecycleBinRestController {
    RecycleBinService recycleBinService;


    @GetMapping
    ResponseEntity<List<RecycleBinDto>> getAll() {
        return ResponseEntity.ok(recycleBinService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<RecycleBinDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(recycleBinService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RecycleBinDto recycleBinDto) {
        recycleBinService.create(recycleBinDto);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RecycleBinDto recycleBinDto) {
        recycleBinService.update(recycleBinDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        recycleBinService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}



