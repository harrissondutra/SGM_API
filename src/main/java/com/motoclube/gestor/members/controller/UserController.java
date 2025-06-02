package com.motoclube.gestor.members.controller;

import com.motoclube.gestor.members.model.to.AuthRequest;
import com.motoclube.gestor.members.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User Create to access the API")
@RestController
@RequestMapping("/users")
//@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(AuthRequest authRequest) {
        var user = userService.create(authRequest);
        return ResponseEntity.ok(user);
    }
}