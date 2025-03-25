package com.mechanicexpress.rest.repository;

import com.mechanicexpress.rest.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // Update an existing customer.
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.first = :first, c.last = :last, c.phone = :phone, c.email = :email WHERE c.customerId = :customerId")
    void updateCustomerById(@Param("customerId") int customerId,
                           @Param("first") String first,
                           @Param("last") String last,
                           @Param("phone") String phone,
                           @Param("email") String email);
}
