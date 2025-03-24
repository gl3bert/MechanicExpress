package com.mechanicexpress.rest.repository.vehicle;

import com.mechanicexpress.rest.model.vehicle.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Model entity.
 * Provides CRUD operations on the model table.
 * @author Gleb Bereziuk
 */

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT MAX(m.modelId) FROM Model m")
    Integer findMaxModelId();

    @Query("SELECT COUNT(m) > 0 FROM Model m WHERE m.name = :modelName AND m.make.makeId = :makeId")
    boolean existsByMakeAndModel(@Param("modelName") String modelName, @Param("makeId") int makeId);

    @Query("SELECT m FROM Model m WHERE m.make.makeId = :makeId")
    List<Model> findByMakeId(@Param("makeId") int makeId);
}
