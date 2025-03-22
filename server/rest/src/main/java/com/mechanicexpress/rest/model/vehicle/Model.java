package com.mechanicexpress.rest.model.vehicle;

import jakarta.persistence.*;

/**
 * Model class.
 * For Vehicle object management.
 * @author Gleb Bereziuk (gl3bert)
 */

@Entity
@Table(name="model")
public class Model {
    @Id
    @Column(name="id")
    private int modelId;
    @Column(name="name", nullable=false)
    private String name;
    @ManyToOne
    @JoinColumn(name="make_id", nullable=false)
    private Make make;

    // Default empty constructor.
    public Model() {}

    // Parameterized constructor.
    public Model(String name, Make make) {
        this.name = name;
        this.make = make;
    }

    // Getter and Setters.
    public int getModelId() { return modelId; }
    public void setModelId(int modelId) { this.modelId = modelId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Make getMake() { return make; }
    public void setMake(Make make) { this.make = make; }
}
