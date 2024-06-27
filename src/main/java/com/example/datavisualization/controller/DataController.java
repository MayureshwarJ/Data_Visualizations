package com.example.datavisualization.controller;

import com.example.datavisualization.entity.DataEntity;
import com.example.datavisualization.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    // GET endpoint to retrieve all data entities
    @GetMapping
    public ResponseEntity<List<DataEntity>> getAllData() {
        List<DataEntity> dataEntities = dataService.getAllData();
        return ResponseEntity.ok(dataEntities);
    }

    // GET endpoint to retrieve a specific data entity by ID
    @GetMapping("/{id}")
    public ResponseEntity<DataEntity> getDataById(@PathVariable Long id) {
        Optional<DataEntity> dataEntity = dataService.getDataById(id);
        return dataEntity.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST endpoint to create a new data entity
    @PostMapping
    public ResponseEntity<DataEntity> createData(@Valid @RequestBody DataEntity dataEntity) {
        DataEntity createdDataEntity = dataService.createData(dataEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDataEntity);
    }

    // PUT endpoint to update an existing data entity
    @PutMapping("/{id}")
    public ResponseEntity<DataEntity> updateData(@PathVariable Long id, @Valid @RequestBody DataEntity newDataEntity) {
        Optional<DataEntity> updatedDataEntity = dataService.updateData(id, newDataEntity);
        return updatedDataEntity.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE endpoint to delete a data entity by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        boolean deleted = dataService.deleteData(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
