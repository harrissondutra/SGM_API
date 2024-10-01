package com.motoclube.gestor.controller;

import com.motoclube.gestor.model.entity.Patent;
import com.motoclube.gestor.model.entity.PositionMember;
import com.motoclube.gestor.model.to.MemberData;
import com.motoclube.gestor.model.to.MemberDto;
import com.motoclube.gestor.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gerenciar Membros", description = "Operações relacionadas a membros")
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @Transactional
    @Operation(summary = "Listar todos os membros", description = "Listar todos os membros cadastrados")
    @GetMapping("/{size}")
    public ResponseEntity<List<MemberDto>> getMembers(@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<MemberDto> membersPage = service.getMembers(pageable);
        return ResponseEntity.ok(membersPage.getContent());
    }

    @Operation(summary = "Cadastrar membro", description = "Cadastrar um novo membro")
    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberData memberData) {
        return ResponseEntity.ok(service.createMember(memberData));
    }

    @Operation(summary = "Atualizar patente", description = "Atualizar a patente de um membro")
    @PutMapping("/{id}/patent/{patentId}")
    public MemberData updatePatent(@PathVariable Long id, @PathVariable Long patentId) {
        return service.updatePatent(id, patentId);
    }

    @Operation(summary = "Atualizar posição", description = "Atualizar a posição de um membro")
    @PutMapping("/{id}/position/{position}")
    public MemberData updatePosition(@PathVariable Long id, @PathVariable PositionMember position) {
        return service.updatePosition(id, position);
    }
}