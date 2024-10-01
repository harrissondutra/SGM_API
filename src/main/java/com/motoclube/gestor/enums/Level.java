package com.motoclube.gestor.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.motoclube.gestor.enums.serializer.LevelSerializer;
import lombok.Getter;

@Getter
@JsonSerialize(using = LevelSerializer.class)
public enum Level {
    REGIONAL(1, "Regional"),
    ESTADUAL(2, "Estadual"),
    NACIONAL(3, "Nacional"),
    MUNDIAL(4, "Mundial");

    private Integer id;
    private String description;

    Level(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public static Level getById(Integer id) {
        for (Level level : Level.values()) {
            if (level.ordinal() == id) {
                return level;
            }
        }
        return null;
    }
}