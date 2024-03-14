package com.abhinav.ipldashboard.config;

import com.abhinav.ipldashboard.entity.MatchModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MatchModelSerializer implements Serializer<MatchModel> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No additional configuration needed
    }

    @Override
    public byte[] serialize(String topic, MatchModel data) {
        if (data == null)
            return null;

        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing MatchModel: " + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        // No resources to close
    }
}
