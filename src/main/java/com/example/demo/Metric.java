package com.example.demo;

import java.time.LocalDateTime;

public class Metric {

    private String id;
    private String name;
    private double value;
    private String unit;
    private LocalDateTime timestamp;

    // Constructors, getters, and setters

    public Metric() {
    }

    public Metric(String id, String name, double value, String unit, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
