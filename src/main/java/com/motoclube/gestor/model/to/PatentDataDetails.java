package com.motoclube.gestor.model.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatentDataDetails {
    private Long id;
    private String numeral;
    private String title;
    private String description;
}
