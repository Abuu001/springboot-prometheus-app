package com.example.springbootprometheusapp.models;

public class AgentCounter {
    private Integer agentsLoggedIn;
    private Integer agentsLoggedOut;
    private Integer agentsReady;
    private Integer agentsNotReady;
    private Integer agentsPending;

    public AgentCounter(Integer agentsLoggedIn, Integer agentsLoggedOut, Integer agentsReady, Integer agentsNotReady,
                        Integer agentsPending) {
        this.agentsLoggedIn = agentsLoggedIn;
        this.agentsLoggedOut = agentsLoggedOut;
        this.agentsReady = agentsReady;
        this.agentsNotReady = agentsNotReady;
        this.agentsPending = agentsPending;
    }

    public Integer getAgentsLoggedIn() {
        return agentsLoggedIn;
    }

    public void setAgentsLoggedIn(Integer agentsLoggedIn) {
        this.agentsLoggedIn = agentsLoggedIn;
    }

    public Integer getAgentsLoggedOut() {
        return agentsLoggedOut;
    }

    public void setAgentsLoggedOut(Integer agentsLoggedOut) {
        this.agentsLoggedOut = agentsLoggedOut;
    }

    public Integer getAgentsReady() {
        return agentsReady;
    }

    public void setAgentsReady(Integer agentsReady) {
        this.agentsReady = agentsReady;
    }

    public Integer getAgentsNotReady() {
        return agentsNotReady;
    }

    public void setAgentsNotReady(Integer agentsNotReady) {
        this.agentsNotReady = agentsNotReady;
    }

    public Integer getAgentsPending() {
        return agentsPending;
    }

    public void setAgentsPending(Integer agentsPending) {
        this.agentsPending = agentsPending;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AgentCounter{");
        sb.append("agentsLoggedIn=").append(agentsLoggedIn);
        sb.append(", agentsLoggedOut=").append(agentsLoggedOut);
        sb.append(", agentsReady=").append(agentsReady);
        sb.append(", agentsNotReady=").append(agentsNotReady);
        sb.append(", agentsPending=").append(agentsPending);
        sb.append('}');
        return sb.toString();
    }
}
