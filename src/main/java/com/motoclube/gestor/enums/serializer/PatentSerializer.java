package com.motoclube.gestor.enums.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.motoclube.gestor.enums.Patent;

import java.io.IOException;

public class PatentSerializer extends JsonSerializer<Patent> {
    @Override
    public void serialize(Patent value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("numeral", value.getNumeral());
        gen.writeStringField("description", value.getDescription());
        gen.writeEndObject();
    }
}
