package com.mechanicexpress.rest.controller;

import com.mechanicexpress.rest.model.Customer;
import com.mechanicexpress.rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Edit customer details
    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable int customerId,
            @RequestParam String first,
            @RequestParam String last,
            @RequestParam String phone,
            @RequestParam String email) {

        Customer updatedCustomer = customerService.updateCustomer(customerId, first, last, phone, email);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete customer by ID.
    @DeleteMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        return "Customer deleted.";
    }

    // Access customer entry by ID.
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    // Access all customers.
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
