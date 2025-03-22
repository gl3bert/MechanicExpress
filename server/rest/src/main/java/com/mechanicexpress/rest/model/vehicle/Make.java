package com.mechanicexpress.rest.model.vehicle;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="make")
public class Make {
    @Id
    @Column(name="id")
    private int makeId;

    @Column(name="name", nullable=false, unique=true)
    private String name;

    @OneToMany(mappedBy="make", cascade = CascadeType.ALL)
    private List<Model> models;

    // Default empty constructor.
    public Make() {}

    // Parameterized constructor.
    public Make(String name) {
        this.name = name;
    }

    // Getters and Setters.
    public int getMakeId() { return makeId; }
    public void setMakeId(int makeId) { this.makeId = makeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Model> getModels() { return models; }
    public void setModels(List<Model> models) { this.models = models; }
}
