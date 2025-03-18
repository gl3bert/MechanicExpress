package com.mechanicexpress.rest.service;

import com.mechanicexpress.rest.model.Customer;

/**
 * Service interface for Customer object.
 * Defines methods for implementation.
 * @author Gleb Bereziuk (gl3bert)
 */

public interface CustomerService {
    boolean createCustomer(Customer customer);
    Customer getCustomer(int customerId);
}
