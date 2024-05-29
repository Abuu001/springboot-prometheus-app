package com.example.springbootprometheusapp.controller;

import com.example.springbootprometheusapp.models.AgentCounter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomMetricController {

    MeterRegistry meterRegistry;
    private final AtomicInteger agentsReady = new AtomicInteger(0);
    private final AtomicInteger agentsLoggedIn = new AtomicInteger(0);
    private final AtomicInteger agentsLoggedOut = new AtomicInteger(0);
    private final AtomicInteger agentsNotReady = new AtomicInteger(0);
    private final AtomicInteger agentsPending = new AtomicInteger(0);

    @Autowired
    public CustomMetricController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        meterRegistry.gauge("agents_ready_gauge", agentsReady);
        meterRegistry.gauge("agents_logged_in_gauge", agentsLoggedIn);
        meterRegistry.gauge("agents_logged_out_gauge", agentsLoggedOut);
        meterRegistry.gauge("agents_not_ready_gauge", agentsNotReady);
        meterRegistry.gauge("agents_pending_gauge", agentsPending);
    }

    @GetMapping("/customMetric")
    public String createMetric(){
        meterRegistry.counter("my_app_order_increment_counter").increment();
        meterRegistry.timer("my_app_order_time_1").record((new Random().nextInt(20)+1), TimeUnit.SECONDS);
        meterRegistry.timer("my_app_order_time_2").record((new Random().nextInt()+1), TimeUnit.SECONDS);

        meterRegistry.gauge("my_app_gague_1_100",(new Random().nextInt(100)+1));
        return "Hello";
    }


    @PostMapping("/customMetric/agents")
    public String createMetric(@RequestBody AgentCounter agentCounterDto){
        AgentCounter agentCounter = new AgentCounter(agentCounterDto.getAgentsLoggedIn(),
                agentCounterDto.getAgentsLoggedOut(),agentCounterDto.getAgentsReady(),
                agentCounterDto.getAgentsNotReady(),agentCounterDto.getAgentsPending());

        meterRegistry.counter("agents_ready_counter","queueName","Telegram").increment(11);
        meterRegistry.counter("agents_ready_counter","queueName","Whatsapp1").increment(3);
        meterRegistry.counter("agents_logged_in_counter","queueName","Whatsapp").increment();
        meterRegistry.counter("agents_logged_out_counter").increment();
        meterRegistry.counter("agents_not_ready_counter").increment();
        meterRegistry.counter("agents_pending_counter").increment();

 /*       meterRegistry.gauge("agents_ready_gauge",agentCounter.getAgentsReady());
        meterRegistry.gauge("agents_logged_in_gauge",agentCounter.getAgentsLoggedIn()) ;
        meterRegistry.gauge("agents_logged_out_gauge",agentCounter.getAgentsLoggedOut()) ;
        meterRegistry.gauge("agents_not_ready_gauge",agentCounter.getAgentsNotReady()) ;
        meterRegistry.gauge("agents_pending_gauge",agentCounter.getAgentsPending()) ;*/
        agentsReady.set(agentCounter.getAgentsReady());
        agentsLoggedIn.set(agentCounter.getAgentsLoggedIn());
        agentsLoggedOut.set(agentCounter.getAgentsLoggedOut());
        agentsNotReady.set(agentCounter.getAgentsNotReady());
        agentsPending.set(agentCounter.getAgentsPending());

        meterRegistry.timer("agents_ready_timer").record(agentCounter.getAgentsReady().longValue(), TimeUnit.SECONDS);
        meterRegistry.timer("agents_logged_in_timer").record(agentCounter.getAgentsLoggedIn().longValue(), TimeUnit.SECONDS) ;
        meterRegistry.timer("agents_logged_out_timer").record(agentCounter.getAgentsLoggedOut().longValue(), TimeUnit.SECONDS) ;
        meterRegistry.timer("agents_not_ready_timer").record(agentCounter.getAgentsNotReady().longValue(), TimeUnit.SECONDS) ;
        meterRegistry.timer("agents_pending_timer").record(agentCounter.getAgentsPending().longValue(), TimeUnit.SECONDS) ;

        return "Hello";
    }
}
