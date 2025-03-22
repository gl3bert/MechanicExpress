package com.mechanicexpress.rest.repository;

import com.mechanicexpress.rest.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Vehicle object.
 * Accesses data from MySQL table.
 * @author Gleb Bereziuk (gl3bert)
 */

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("SELECT MAX(v.vehicleId) FROM Vehicle v")
    Integer findMaxVehicleId();
}
