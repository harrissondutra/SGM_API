package com.motoclube.gestor.controller;

import com.motoclube.gestor.model.to.PatentData;
import com.motoclube.gestor.model.to.PatentDataDetails;
import com.motoclube.gestor.service.PatentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get patents")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Patentes listadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Patentes não encontradas")
    })
    @GetMapping("/{size}")
    public ResponseEntity<List<PatentData>> getPatents(@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        var patentsPage = service.getPatents(pageable);
        return ResponseEntity.ok(patentsPage.getContent());
    }

    @Operation(summary = "Create patent")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Patente cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Patente não encontrada")
    })
    @PostMapping
    public ResponseEntity<PatentDataDetails> createPatent(@RequestBody PatentData patentData) {
        var patent = service.createPatent(patentData);

        return ResponseEntity.created(null).body(patent);
    }
    @Operation(summary = "Update patent")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Patente atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Patente não encontrada")
    })
    @PutMapping("/updatePatent/{memberId}/{patentId}")
    public ResponseEntity<PatentData> updatePatent(@PathVariable Long memberId, @PathVariable Long patentId) {
        return ResponseEntity.ok(service.updatePatent(memberId, patentId));
    }

    @Operation(summary = "Get patent by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Patente encontrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Patente não encontrada")
    })
    @GetMapping("/getPatentById/{patentId}")
    public ResponseEntity<PatentData> getPatentById(@PathVariable Long patentId) {
        return ResponseEntity.ok(service.getPatentById(patentId));
    }

    @Operation(summary = "Delete patent")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Patente deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Patente não encontrada")
    })
    @DeleteMapping("/deletePatent/{patentId}")
    public ResponseEntity deletePatent(@PathVariable Long patentId) {
        service.deletePatent(patentId);
        return ResponseEntity.ok().build();
    }
}