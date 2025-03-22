package com.mechanicexpress.rest.model.vehicle;

import jakarta.persistence.*;

@Entity
@Table(name="state")
public class State {
    @Id
    @Column(name="id")
    private int stateId;
    @Column(name="name", nullable=false, unique=true)
    private String name;

    // Default empty constructor.
    public State() {}

    // Parameterized constructor.
    public State(String name) {
        this.name = name;
    }

    // Getters and Setters.
    public int getStateId() { return stateId; }
    public void setStateId(int stateId) { this.stateId = stateId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
