package com.motoclube.gestor.enums.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.motoclube.gestor.enums.Level;

import java.io.IOException;

public class LevelSerializer extends JsonSerializer<Level> {
    @Override
    public void serialize(Level value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("description", value.getDescription());
        gen.writeEndObject();
    }
}
