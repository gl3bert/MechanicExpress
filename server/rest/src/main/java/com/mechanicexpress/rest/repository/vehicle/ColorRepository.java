package com.mechanicexpress.rest.repository.vehicle;

import com.mechanicexpress.rest.model.vehicle.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Color entity.
 * Provides CRUD operations on the color table.
 * @author Gleb Bereziuk
 */

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    @Query("SELECT MAX(c.colorId) FROM Color c")
    Integer findMaxColorId();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Color c WHERE c.name = :color")
    boolean alreadyExists(@Param("color") String color);
}
