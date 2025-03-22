package com.mechanicexpress.rest.repository.vehicle;

import com.mechanicexpress.rest.model.vehicle.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Model entity.
 * Provides CRUD operations on the model table.
 * @author Gleb Bereziuk
 */

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
