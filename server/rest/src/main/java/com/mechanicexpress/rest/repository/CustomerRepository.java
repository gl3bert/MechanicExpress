package com.mechanicexpress.rest.repository;

import com.mechanicexpress.rest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Customer object.
 * Accesses data from MySQL table.
 * @author Gleb Bereziuk (gl3bert)
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Find last customerId.
    @Query("SELECT MAX(c.customerId) FROM Customer c")
    Integer findMaxCustomerId();

    // Return the list of all customers.
    @Query("SELECT c FROM Customer c")
    List<Customer> findAllCustomers();
}
