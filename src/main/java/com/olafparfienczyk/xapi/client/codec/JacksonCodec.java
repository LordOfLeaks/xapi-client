package com.olafparfienczyk.xapi.client.codec;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JacksonCodec implements Codec {

    private final ObjectMapper objectMapper;

    public JacksonCodec() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
    }

    public JacksonCodec(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> T decode(String encoded, Class<T> type) throws CodecException {
        try {
            return objectMapper.readValue(encoded, type);
        } catch (IOException e) {
            throw new CodecException("Failed to decode", e);
        }
    }

    @Override
    public String encode(Object obj) throws CodecException {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new CodecException("Failed to encode", e);
        }
    }
}