package com.mechanicexpress.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Customer class.
 * Defines Customer object attributes.
 * @author Gleb Bereziuk (gl3bert)
 */

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "first")
    private String first;
    @Column(name = "last")
    private String last;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    // Default empty constructor.
    public Customer() {}

    // Parameterized constructor for creation.
    public Customer(String first, String last, String phone, String email) {
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters.
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getFirst() { return first; }
    public void setFirst(String first) { this.first = first; }
    public String getLast() { return last; }
    public void setLast(String last) { this.last = last; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
