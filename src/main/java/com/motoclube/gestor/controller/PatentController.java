package com.motoclube.gestor.controller;

import com.motoclube.gestor.model.to.PatentData;
import com.motoclube.gestor.model.to.PatentDataDetails;
import com.motoclube.gestor.service.PatentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Patent", description = "Patent controller")
@RequestMapping("/patent")
public class PatentController {

    private final PatentService service;

    public PatentController(PatentService service) {
        this.service = service;
    }

    @GetMapping("/{size}")
    public ResponseEntity<List<PatentData>> getPatents(@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        var patentsPage = service.getPatents(pageable);
        return ResponseEntity.ok(patentsPage.getContent());
    }

    @Operation(summary = "Create patent")
    @PostMapping
    public ResponseEntity<PatentDataDetails> createPatent(@RequestBody PatentData patentData) {
        var patent = service.createPatent(patentData);

        return ResponseEntity.created(null).body(patent);
    }

    @Operation(summary = "Update patent")
    @PutMapping("/updatePatent/{memberId}/{patentId}")
    public ResponseEntity<PatentData> updatePatent(@PathVariable Long memberId, @PathVariable Long patentId) {
        return ResponseEntity.ok(service.updatePatent(memberId, patentId));
    }

    @Operation(summary = "Get patent by id")
    @GetMapping("/getPatentById/{patentId}")
    public ResponseEntity<PatentData> getPatentById(@PathVariable Long patentId) {
        return ResponseEntity.ok(service.getPatentById(patentId));
    }

    @Operation(summary = "Delete patent")
    @DeleteMapping("/deletePatent/{patentId}")
    public ResponseEntity deletePatent(@PathVariable Long patentId) {
        service.deletePatent(patentId);
        return ResponseEntity.ok().build();
    }
}