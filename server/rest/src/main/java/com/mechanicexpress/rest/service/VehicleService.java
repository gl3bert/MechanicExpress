package com.mechanicexpress.rest.service;
import com.mechanicexpress.rest.model.Vehicle;
import com.mechanicexpress.rest.model.vehicle.*;

import java.util.List;

/**
 * Service class for Vehicle entity and its supplemental classes.
 * Handles business logic and interacts with Repositories.
 * @author Gleb Bereziuk (gl3bert)
 */

public interface VehicleService {
    boolean addVehicle(Vehicle vehicle);


    // Supplemental functions.
    void addMakes(List<String> makes);
    Make getMake(String name);
    void addColors(List<String> color);
    void addStates(List<String> state);
    void addYears(List<Integer> years);
    void addModels(List<Model> models);
}
