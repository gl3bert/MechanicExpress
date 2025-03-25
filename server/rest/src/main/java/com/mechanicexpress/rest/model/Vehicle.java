package com.mechanicexpress.rest.model;

import jakarta.persistence.*;

import com.mechanicexpress.rest.model.vehicle.*;

/**
 * Vehicle class.
 * Defines Vehicle object attributes.
 * Represents a registered vehicle in the system.
 * Author: Gleb Bereziuk (gl3bert)
 */

@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @Column(name="id")
    private int vehicleId;
    @ManyToOne
    @JoinColumn(name="make_id", referencedColumnName="id", nullable=false)
    private Make make;
    @ManyToOne
    @JoinColumn(name="model_id", referencedColumnName="id", nullable=false)
    private Model model;
    @ManyToOne
    @JoinColumn(name="year_id", referencedColumnName="id", nullable=false)
    private Year year;
    @ManyToOne
    @JoinColumn(name="color_id", referencedColumnName="id", nullable=false)
    private Color color;
    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName="id", nullable=false)
    private State state;
    @Column(name="plate", nullable=false)
    private String plate;
    @Column(name="vin", nullable=false, unique=true, length=17)
    private String vin;

    // Default empty constructor.
    public Vehicle() {}

    // Parameterized constructor for creation.
    public Vehicle(Make make, Model model, Year year, Color color, State state, String plate, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.state = state;
        this.plate = plate;
        this.vin = vin;
    }

    // toString.
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", make=" + (make != null ? make.getMakeId() : "null") +
                ", model=" + (model != null ? model.getModelId() : "null") +
                ", year=" + (year != null ? year.getYearId() : "null") +
                ", color=" + (color != null ? color.getColorId() : "null") +
                ", state=" + (state != null ? state.getStateId() : "null") +
                ", plate='" + plate + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }


    // Getters and Setters.
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public Make getMake() { return make; }
    public void setMake(Make make) { this.make = make; }
    public Model getModel() { return model; }
    public void setModel(Model model) { this.model = model; }
    public Year getYear() { return year; }
    public void setYear(Year year) { this.year = year; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }
}
