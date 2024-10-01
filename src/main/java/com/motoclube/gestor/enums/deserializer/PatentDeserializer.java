package com.motoclube.gestor.enums.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.motoclube.gestor.enums.Patent;

import java.io.IOException;

public class PatentDeserializer extends JsonDeserializer<Patent> {
    @Override
    public Patent deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();

        Patent type = null;

        if (node != null) {
            type = Patent.getById(id);
            if (type != null) {
                return type;
            }
        }

        return type;

    }
}
