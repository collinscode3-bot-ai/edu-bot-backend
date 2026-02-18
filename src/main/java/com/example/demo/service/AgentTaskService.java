package com.example.demo.service;

import com.example.demo.model.AgentTask;
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
public class AgentTaskService {

    @Value("${app.data.path.agentTasks:/workspace/daily_tasks/daily_tasks.json}") // Using daily_tasks.json for agent tasks
    private String agentTasksFilePath;

    private final ObjectMapper objectMapper;

    public AgentTaskService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule()); // For handling Java 8 Date/Time types
    }

    public List<AgentTask> getAgentTasks() {
        try {
            String content = Files.readString(Paths.get(agentTasksFilePath));
            // The JSON is an array of AgentTask objects
            return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, AgentTask.class));
        } catch (IOException e) {
            // Log the error properly in a real application
            e.printStackTrace();
            return Collections.emptyList(); // Return empty list on error
        }
    }
}
