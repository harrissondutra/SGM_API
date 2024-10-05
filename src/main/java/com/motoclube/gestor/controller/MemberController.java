package com.motoclube.gestor.controller;

import com.motoclube.gestor.model.entity.PositionMember;
import com.motoclube.gestor.model.to.MemberData;
import com.motoclube.gestor.model.to.MemberDto;
import com.motoclube.gestor.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membros listados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membros não encontrados")
    })    @GetMapping("/{size}")
    public ResponseEntity<List<MemberDto>> getMembers(@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<MemberDto> membersPage = service.getMembers(pageable);
        return ResponseEntity.ok(membersPage.getContent());
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membro cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @Operation(summary = "Cadastrar membro", description = "Cadastrar um novo membro")
    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberData memberData) {
        return ResponseEntity.ok(service.createMember(memberData));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membro encontrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @Operation(summary = "Buscar membro por ID", description = "Buscar um membro por ID")
    @GetMapping("/findById/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMemberById(id));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @Operation(summary = "Atualizar membro", description = "Atualizar um membro")
    @PutMapping("/updateMember/{id}")
    public ResponseEntity<MemberDto> updateMember(@PathVariable Long id, @RequestBody MemberData memberData) {
        return ResponseEntity.ok(service.updateMember(id, memberData));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @Operation(summary = "Atualizar patente", description = "Atualizar a patente de um membro")
    @PutMapping("/{id}/patent/{patentId}")
    public ResponseEntity<MemberData> updatePatent(@PathVariable Long id, @PathVariable Long patentId) {
        return ResponseEntity.ok(service.updatePatent(id, patentId));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @Operation(summary = "Atualizar posição", description = "Atualizar a posição de um membro")
    @PutMapping("/{id}/position/{position}")
    public ResponseEntity<MemberData> updatePosition(@PathVariable Long id, @PathVariable PositionMember position) {
        return ResponseEntity.ok(service.updatePosition(id, position));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Membro excluído com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Membro não encontrado")
    })
    @Operation(summary = "Ativar ou inativar membro", description = "Ativar ou inativar um membro")
    @PutMapping("/{id}/setStatus/")
    public ResponseEntity<MemberData> updateActive(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateActive(id));
    }
}