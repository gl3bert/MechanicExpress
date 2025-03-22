package com.mechanicexpress.rest.model;

import jakarta.persistence.*;

/**
 * CustomerRel class.
 * Connects Customer with Vehicle
 */

@Entity
@Table(name="vehiclerel")
public class VehicleRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="vehicle_id", referencedColumnName="id", nullable=false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName="customer_id", nullable=false)
    private Customer customer;

    public VehicleRel() {}

    public VehicleRel(Vehicle vehicle, Customer customer) {
        this.vehicle = vehicle;
        this.customer = customer;
    }

    // Getters and Setters.
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}