package com.motoclube.gestor.members.model.response;

import lombok.Builder;

@Builder
public record UserResponseTO(
        Long id,
        String name,
        String email,
        Boolean active
) {
}
