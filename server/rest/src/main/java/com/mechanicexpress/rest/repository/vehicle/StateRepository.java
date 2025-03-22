package com.mechanicexpress.rest.repository.vehicle;

import com.mechanicexpress.rest.model.vehicle.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for State entity.
 * Provides CRUD operations on the state table.
 * @author Gleb Bereziuk
 */

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
    @Query("SELECT MAX(s.stateId) FROM State s")
    Integer findMaxStateId();

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM State s WHERE s.name = :state")
    boolean alreadyExists(@Param("state") String state);

}
