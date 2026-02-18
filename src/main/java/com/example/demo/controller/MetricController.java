package com.example.demo.controller;

import com.example.demo.service.MetricService;
import com.example.demo.model.Metric;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping
    public List<Metric> getAllMetrics() {
        return metricService.getMetrics();
    }
}
