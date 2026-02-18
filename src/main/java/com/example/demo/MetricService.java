package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collections;

@Service
public class MetricService {

    @Value("${app.data.path.metrics:/workspace/metrics/metrics.json}") // Fallback path if not set
    private String metricsFilePath;

    private final ObjectMapper objectMapper;

    public MetricService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule()); // For handling Java 8 Date/Time types
    }

    public List<Metric> getMetrics() {
        try {
            String content = Files.readString(Paths.get(metricsFilePath));
            // The JSON is an array of Metric objects
            return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, Metric.class));
        } catch (IOException e) {
            // Log the error properly in a real application
            e.printStackTrace();
            return Collections.emptyList(); // Return empty list on error
        }
    }
}
