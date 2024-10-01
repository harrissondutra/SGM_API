package com.motoclube.gestor.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.motoclube.gestor.enums.serializer.PatentSerializer;
import lombok.Getter;

@Getter
@JsonSerialize(using = PatentSerializer.class)
public enum Patent {
    PROSPERO(10, "X", "Prospero"),
    MEIO_ESCUDO(9, "IX", "Meio Escudo"),
    ESCUDADO(8, "VIII", "Escudado"),
    SUB_DIRETOR_REGIONAL(7, "VII", "Sub Diretor Regional"),
    DIRETOR_REGIONAL(6, "VI", "Diretor Regional"),
    ADM_ESTADUAL(5, "V", "ADM Estadual"),
    DIRETOR_AREA(4, "IV", "Diretor de Área"),
    SARGENTO_ARMAS(40, "IV", "Sargento de Armas"),
    DISCIPLINA_ESTADUAL(3, "III", "Disciplina Estadual"),
    VICE_PRESIDENTE_ESTADUAL(2, "II", "Vice Presidente Estadual"),
    PRESIDENTE_ESTADUAL(1, "I", "Presidente Estadual"),
    NOMADE(0, "N", "Nômade");

    private Integer id;
    private String numeral;
    private String description;

    Patent(Integer id, String numeral, String description) {
        this.id = id;
        this.numeral = numeral;
        this.description = description;
    }

    public static Patent getById(Integer id) {
        for (Patent patent : Patent.values()) {
            if (patent.getId().equals(id)) {
                return patent;
            }
        }
        return null;
    }

    public static Patent getByNumeral(String numeral) {
        for (Patent patent : Patent.values()) {
            if (patent.getNumeral().equals(numeral)) {
                return patent;
            }
        }
        return null;
    }
}
