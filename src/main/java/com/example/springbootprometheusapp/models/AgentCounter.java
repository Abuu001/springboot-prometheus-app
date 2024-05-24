package com.example.springbootprometheusapp.models;

public class AgentCounter {
    private int agentsLoggedIn;
    private int agentsLoggedOut;
    private int agentsReady;
    private int agentsNotReady;
    private int agentsPending;

    public AgentCounter(int agentsLoggedIn, int agentsLoggedOut, int agentsReady, int agentsNotReady,
                        int agentsPending) {
        this.agentsLoggedIn = agentsLoggedIn;
        this.agentsLoggedOut = agentsLoggedOut;
        this.agentsReady = agentsReady;
        this.agentsNotReady = agentsNotReady;
        this.agentsPending = agentsPending;
    }

    public int getAgentsLoggedIn() {
        return agentsLoggedIn;
    }

    public void setAgentsLoggedIn(int agentsLoggedIn) {
        this.agentsLoggedIn = agentsLoggedIn;
    }

    public int getAgentsLoggedOut() {
        return agentsLoggedOut;
    }

    public void setAgentsLoggedOut(int agentsLoggedOut) {
        this.agentsLoggedOut = agentsLoggedOut;
    }

    public int getAgentsReady() {
        return agentsReady;
    }

    public void setAgentsReady(int agentsReady) {
        this.agentsReady = agentsReady;
    }

    public int getAgentsNotReady() {
        return agentsNotReady;
    }

    public void setAgentsNotReady(int agentsNotReady) {
        this.agentsNotReady = agentsNotReady;
    }

    public int getAgentsPending() {
        return agentsPending;
    }

    public void setAgentsPending(int agentsPending) {
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
