package com.mechanicexpress.rest.controller;

import com.mechanicexpress.rest.model.Customer;
import com.mechanicexpress.rest.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Customer class.
 * Handles API requests.
 * @author Gleb Bereziuk (gl3bert)
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    // Access Service class.
    CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Add customer entry to the table.
    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return "Customer created. Assigned ID: " + customer.getCustomerId();
    }

    // Access customer entry by ID.
    @GetMapping("{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    // Access all customers.
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
