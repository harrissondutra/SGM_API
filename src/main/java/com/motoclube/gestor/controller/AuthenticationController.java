/*
package com.motoclube.gestor.controller;

import com.motoclube.gestor.model.entity.User;
import com.motoclube.gestor.model.to.AuthRequest;
import com.motoclube.gestor.model.to.TokenData;
import com.motoclube.gestor.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Autenticação", description = "Operações relacionadas a autenticação")
@RestController
@RequestMapping("/auth")
@SecurityRequirement(name = "bearer-key")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Operation(summary = "Autenticar usuário", description = "Enviando um AuthRequest, um token será gerado")
    @PostMapping
    public ResponseEntity authenticate(@RequestBody @Valid AuthRequest authRequest) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authRequest.login(), authRequest.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenData(tokenJWT));
    }
}*/
