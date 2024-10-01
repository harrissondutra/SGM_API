package com.motoclube.gestor.enums.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.motoclube.gestor.enums.PositionMember;

import java.io.IOException;

public class PositionMemberDeserializer extends JsonDeserializer<PositionMember> {
    @Override
    public PositionMember deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();

        PositionMember type = null;

        if (node != null) {
            type = PositionMember.getById(id);
            if (type != null) {
                return type;
            }
        }

        return type;
    }
}
