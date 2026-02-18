package com.example.demo;

import java.time.LocalDateTime;

public class AgentTask {

    private String id;
    private String description;
    private String assignedTo;
    private LocalDateTime dueDate;
    private String status;
    private String priority;

    // Constructors, getters, and setters

    public AgentTask() {
    }

    public AgentTask(String id, String description, String assignedTo, LocalDateTime dueDate, String status, String priority) {
        this.id = id;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
