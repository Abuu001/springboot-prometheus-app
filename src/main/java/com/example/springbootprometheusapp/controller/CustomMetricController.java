package com.example.springbootprometheusapp.controller;

import io.micrometer.core.instrument.MeterRegistry;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomMetricController {

    @Autowired
    MeterRegistry meterRegistry;

    @GetMapping("/customMetric")
    public String createMetric(){
        meterRegistry.counter("my_app_order_increment_counter").increment();
        meterRegistry.timer("my_app_order_time").record((new Random().nextInt(100)+1), TimeUnit.SECONDS);
        meterRegistry.gauge("my_app_gague_1_100",(new Random().nextInt(100)+1));
        return "Hello";
    }


}
