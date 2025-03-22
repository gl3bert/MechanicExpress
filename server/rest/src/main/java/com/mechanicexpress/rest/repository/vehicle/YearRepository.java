package com.mechanicexpress.rest.repository.vehicle;

import com.mechanicexpress.rest.model.vehicle.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Year entity.
 * Provides CRUD operations on the year table.
 * @author Gleb Bereziuk
 */

@Repository
public interface YearRepository extends JpaRepository<Year, Integer> {
    @Query("SELECT MAX(y.yearId) FROM Year y")
    Integer findMaxYearId();

    @Query("SELECT CASE WHEN COUNT(y) > 0 THEN true ELSE false END FROM Year y WHERE y.year = :year")
    boolean alreadyExists(@Param("year") Integer year);

}
