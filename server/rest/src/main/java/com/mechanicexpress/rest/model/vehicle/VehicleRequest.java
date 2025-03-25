package com.mechanicexpress.rest.model.vehicle;

/**
 * VehicleRequest object.
 * Used for parsing new vehicle input.
 * @author Gleb Bereziuk (gl3bert)
 */

public class VehicleRequest {
    private int make;
    private int model;
    private int year;
    private int color;
    private int state;
    private String plate;
    private String vin;

    // Getters and Setters.
    public int getMake() { return make; }
    public void setMake(int make) { this.make = make; }
    public int getModel() { return model; }
    public void setModel(int model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public int getColor() { return color; }
    public void setColor(int color) { this.color = color; }
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }
    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }
}

