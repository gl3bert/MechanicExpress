package com.mechanicexpress.rest.service;

import com.mechanicexpress.rest.model.Customer;

import java.util.List;

/**
 * Service interface for Customer object.
 * Defines methods for implementation.
 * @author Gleb Bereziuk (gl3bert)
 */

public interface CustomerService {
    boolean createCustomer(Customer customer);
    void deleteCustomer(int customerId);
    Customer updateCustomer(int customerId, String firstName, String lastName, String phone, String email);
    Customer getCustomer(int customerId);
    List<Customer> getAllCustomers();
}
