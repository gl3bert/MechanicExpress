package com.mechanicexpress.rest.service.impl;

import com.mechanicexpress.rest.model.Customer;
import com.mechanicexpress.rest.repository.CustomerRepository;
import com.mechanicexpress.rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation for CustomerService interface.
 * Code for methods.
 * @author Gleb Bereziuk (gl3bert)
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create customer entry with the provided object; assign ID.
    @Override
    public boolean createCustomer(Customer customer) {
        try {
            customer.setCustomerId(getNextCustomerId());
            customerRepository.save(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Access customer entry by ID.
    @Override
    public Customer getCustomer(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    // Find the next customer ID from existing table.
    public int getNextCustomerId() {
        Integer maxId = customerRepository.findMaxCustomerId();
        return (maxId == null) ? 1000 : maxId + 1;
    }

    // Returns all customers
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }
}
