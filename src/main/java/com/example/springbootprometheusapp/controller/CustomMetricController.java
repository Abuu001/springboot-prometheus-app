package com.example.springbootprometheusapp.controller;

import com.example.springbootprometheusapp.models.AgentCounter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomMetricController {

    @Autowired
    MeterRegistry meterRegistry;

    @GetMapping("/customMetric")
    public String createMetric(){
        meterRegistry.counter("my_app_order_increment_counter").increment();
        meterRegistry.timer("my_app_order_time_1").record((new Random().nextInt(20)+1), TimeUnit.SECONDS);
        meterRegistry.timer("my_app_order_time_2").record((new Random().nextInt()+1), TimeUnit.SECONDS);

        meterRegistry.gauge("my_app_gague_1_100",(new Random().nextInt(100)+1));
        return "Hello";
    }


    @PostMapping("/customMetric/agents")
    public String createMetric(@RequestBody AgentCounter agentCounter){
        meterRegistry.counter("agents_ready_counter").increment();
        meterRegistry.counter("agents_logged_in_counter").increment();
        meterRegistry.counter("agents_logged_out_counter").increment();
        meterRegistry.counter("agents_not_ready_counter").increment();
        meterRegistry.counter("agents_pending_counter").increment();

        meterRegistry.gauge("agents_ready_gauge",agentCounter.getAgentsReady());
        meterRegistry.gauge("agents_logged_in_gauge",agentCounter.getAgentsLoggedIn()) ;
        meterRegistry.gauge("agents_logged_out_gauge",agentCounter.getAgentsLoggedOut()) ;
        meterRegistry.gauge("agents_not_ready_gauge",agentCounter.getAgentsNotReady()) ;
        meterRegistry.gauge("agents_pending_gauge",agentCounter.getAgentsPending()) ;

        meterRegistry.timer("agents_ready_timer").record(agentCounter.getAgentsReady(), TimeUnit.SECONDS);
        meterRegistry.timer("agents_logged_in_timer").record(agentCounter.getAgentsLoggedIn(), TimeUnit.SECONDS) ;
        meterRegistry.timer("agents_logged_out_timer").record(agentCounter.getAgentsLoggedOut(), TimeUnit.SECONDS) ;
        meterRegistry.timer("agents_not_ready_timer").record(agentCounter.getAgentsNotReady(), TimeUnit.SECONDS) ;
        meterRegistry.timer("agents_pending_timer").record(agentCounter.getAgentsPending(), TimeUnit.SECONDS) ;

        return "Hello";
    }
}
