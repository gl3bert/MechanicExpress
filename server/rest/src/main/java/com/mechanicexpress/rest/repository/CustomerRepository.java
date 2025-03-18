package com.mechanicexpress.rest.repository;

import com.mechanicexpress.rest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for Customer object.
 * Accesses data from MySQL table.
 * @author Gleb Bereziuk (gl3bert)
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT MAX(c.customerId) FROM Customer c")
    Integer findMaxCustomerId();
}
