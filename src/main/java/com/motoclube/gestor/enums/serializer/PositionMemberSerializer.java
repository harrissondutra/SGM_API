package com.motoclube.gestor.enums.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.motoclube.gestor.enums.PositionMember;

import java.io.IOException;

public class PositionMemberSerializer extends JsonSerializer<PositionMember> {
    @Override
    public void serialize(PositionMember value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("numeral", value.getNumeral());
        gen.writeStringField("description", value.getDescription());
        gen.writeEndObject();
    }
}
