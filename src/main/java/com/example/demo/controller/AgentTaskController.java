package com.example.demo.controller;

import com.example.demo.service.AgentTaskService;
import com.example.demo.model.AgentTask;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agent-tasks")
public class AgentTaskController {

    private final AgentTaskService agentTaskService;

    public AgentTaskController(AgentTaskService agentTaskService) {
        this.agentTaskService = agentTaskService;
    }

    @GetMapping
    public List<AgentTask> getAllAgentTasks() {
        return agentTaskService.getAgentTasks();
    }
}
