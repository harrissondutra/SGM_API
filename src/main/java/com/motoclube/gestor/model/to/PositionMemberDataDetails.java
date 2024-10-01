package com.motoclube.gestor.model.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionMemberDataDetails {
    private Long id;
    private String numeral;
    private String name;
    private String description;
}
