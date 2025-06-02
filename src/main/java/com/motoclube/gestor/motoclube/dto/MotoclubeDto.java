package com.motoclube.gestor.motoclube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotoclubeDto {
    private Long id;
    private String nome;
    private String sigla;
    private LocalDate dataCriacao;
    private String cidade;
    private String estado;
    private String presidente;
    private String email;
    private String telefone;
    private String logo;
    private Status status;

    public enum Status {
        ATIVO, INATIVO
    }
}
