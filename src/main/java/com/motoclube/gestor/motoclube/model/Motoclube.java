package com.motoclube.gestor.motoclube.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Motoclube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer membros;

    public enum Status {
        ATIVO, INATIVO
    }
}
