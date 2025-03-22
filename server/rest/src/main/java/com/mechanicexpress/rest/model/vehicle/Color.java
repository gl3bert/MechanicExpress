package com.mechanicexpress.rest.model.vehicle;

import jakarta.persistence.*;

/**
 * Color class.
 * For Vehicle object management.
 * @author Gleb Bereziuk (gl3bert)
 */

@Entity
@Table(name="color")
public class Color {
    @Id
    @Column(name="id")
    private int colorId;

    @Column(name="name", nullable=false, unique=true)
    private String name;

    // Default empty constructor.
    public Color() {}

    // Parameterized constructor.
    public Color(String name) {
        this.name = name;
    }

    // Getter and Setters.
    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
