package com.motoclube.gestor.controller;

import com.motoclube.gestor.model.to.MemberDto;
import com.motoclube.gestor.model.to.PositionMemberData;
import com.motoclube.gestor.model.to.PositionMemberDataDetails;
import com.motoclube.gestor.service.PositionMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "PositionMember", description = "Posições dos membros")
@RestController
@RequestMapping("/positionMember")
public class PositionMemberController {

    @Autowired
    private PositionMemberService service;

    @Transactional
    @Operation(summary = "Listar todas as posições", description = "Listar todas as posições cadastradas")
    @GetMapping("/{size}")
    public ResponseEntity<List<PositionMemberDataDetails>> getPositionMember(@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<PositionMemberDataDetails> positionPage = service.getPositionMembers(pageable);
        return ResponseEntity.ok(positionPage.getContent());
    }

    @Operation(summary = "Criar uma nova posição", description = "Criar uma nova posição")
    @PostMapping
    public ResponseEntity<PositionMemberDataDetails> createPositionMember(@RequestBody PositionMemberData positionMemberData) {
        return ResponseEntity.created(null).body(service.createPositionMember(positionMemberData));
    }
    @Operation(summary = "Obter posição por ID", description = "Obter posição por ID")
    @GetMapping("/getById/{id}")
    public ResponseEntity<PositionMemberDataDetails> getPositionMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPositionMemberById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePositionMember(@PathVariable Long id) {
        service.deletePositionMember(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PositionMemberDataDetails> updatePositionMember(@PathVariable Long id, @RequestBody PositionMemberData positionMemberData) {
        return ResponseEntity.ok(service.updatePositionMember(id, positionMemberData));
    }
}
