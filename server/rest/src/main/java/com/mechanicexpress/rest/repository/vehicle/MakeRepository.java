package com.mechanicexpress.rest.repository.vehicle;

import com.mechanicexpress.rest.model.vehicle.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Make entity.
 * Provides CRUD operations on the make table.
 * @author Gleb Bereziuk
 */

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {
    @Query("SELECT MAX(m.makeId) FROM Make m")
    Integer findMaxMakeId();

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Make m WHERE m.name = :make")
    boolean alreadyExists(@Param("make") String make);

}
