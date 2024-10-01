package com.motoclube.gestor.model.to;

import jakarta.validation.constraints.Email;

public record UserData(
        String name,
        @Email
        String email,
        String password,
        Boolean active
) {
}
