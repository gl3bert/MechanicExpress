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
    @JoinColumn(name="make", referencedColumnName="id", nullable=false)
    private Make make;
    @ManyToOne
    @JoinColumn(name="model", referencedColumnName="id", nullable=false)
    private Model model;
    @ManyToOne
    @JoinColumn(name="year", referencedColumnName="id", nullable=false)
    private Year year;
    @ManyToOne
    @JoinColumn(name="color", referencedColumnName="id", nullable=false)
    private Color color;
    @ManyToOne
    @JoinColumn(name="state", referencedColumnName="id", nullable=false)
    private State state;
    @Column(name="plate_number", nullable=false)
    private String plateNumber;
    @Column(name="vin", nullable=false, unique=true, length=17)
    private String vin;

    // Default empty constructor.
    public Vehicle() {}

    // Parameterized constructor for creation.
    public Vehicle(Make make, Model model, Year year, Color color, State state, String plateNumber, String vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.state = state;
        this.plateNumber = plateNumber;
        this.vin = vin;
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
    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }
}
