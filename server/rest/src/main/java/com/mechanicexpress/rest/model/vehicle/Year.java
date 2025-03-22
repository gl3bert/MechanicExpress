package com.mechanicexpress.rest.model.vehicle;

import jakarta.persistence.*;

/**
 * Year class.
 * For Vehicle object management.
 * @author Gleb Bereziuk (gl3bert)
 */

@Entity
@Table(name="Year")
public class Year {
    @Id
    @Column(name="id")
    private int yearId;
    @Column(name="year")
    private int year;

    // Default empty constructor.
    public Year() {}

    // Parameterized constructor.
    public Year(int year) {
        this.yearId = year;
        this.year = year;
    }

    // Getter and Setters.
    public int getYearId() { return yearId; }
    public void setYearId(int yearId) { this.yearId = yearId; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
