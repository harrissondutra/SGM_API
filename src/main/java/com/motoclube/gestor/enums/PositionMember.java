package com.motoclube.gestor.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.motoclube.gestor.enums.serializer.PositionMemberSerializer;
import lombok.Getter;

@Getter
@JsonSerialize(using = PositionMemberSerializer.class)
public enum PositionMember {
    ROOT(1, "IV", "Root"),
    PRESIDENT(2, "III", "President");


    private Integer id;
    private String numeral;
    private String description;

    PositionMember(Integer id, String numeral, String description) {
        this.id = id;
        this.numeral = numeral;
        this.description = description;
    }

    public static PositionMember getById(Integer id) {
        for (PositionMember positionMember : PositionMember.values()) {
            if (positionMember.getId().equals(id)) {
                return positionMember;
            }
        }
        return null;
    }

    public static PositionMember getByNumeral(String numeral) {
        for (PositionMember positionMember : PositionMember.values()) {
            if (positionMember.getNumeral().equals(numeral)) {
                return positionMember;
            }
        }
        return null;
    }
}
