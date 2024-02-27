package com.mykytaaa.user.profile.service.e2e.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonSerializationHelper {

    /**
     * ObjectMapper for serializing and deserializing JSON.
     */
    private final ObjectMapper objectMapper;

    /**
     * Converts the given object into a JsonNode using the configured ObjectMapper.
     *
     * @param object The object to convert into a JsonNode.
     * @return The JsonNode representation of the object.
     */
    public JsonNode getObjectAsNode(Object object) {
        return objectMapper.valueToTree(object);
    }
}
