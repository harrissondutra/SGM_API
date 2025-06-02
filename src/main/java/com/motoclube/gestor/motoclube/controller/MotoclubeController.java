package com.motoclube.gestor.motoclube.controller;

import com.motoclube.gestor.motoclube.dto.MotoclubeDto;
import com.motoclube.gestor.motoclube.service.MotoclubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoclubes")
public class MotoclubeController {

    @Autowired
    private MotoclubeService motoclubeService;

    @GetMapping
    public ResponseEntity<List<MotoclubeDto>> listarTodos() {
        return ResponseEntity.ok(motoclubeService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoclubeDto> buscarPorId(@PathVariable Long id) {
        MotoclubeDto dto = motoclubeService.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MotoclubeDto> criar(@RequestBody MotoclubeDto motoclubeDto) {
        MotoclubeDto criado = motoclubeService.criar(motoclubeDto);
        return ResponseEntity.ok(criado);
    }
}
