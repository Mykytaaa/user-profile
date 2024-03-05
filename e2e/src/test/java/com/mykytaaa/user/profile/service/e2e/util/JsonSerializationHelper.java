package com.mykytaaa.user.profile.service.e2e.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonSerializationHelper {

    private final ObjectMapper objectMapper;

    public JsonNode getObjectAsNode(Object object) {
        return objectMapper.valueToTree(object);
    }
}
