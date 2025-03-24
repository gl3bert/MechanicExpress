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
    void addVehicle(Vehicle vehicle);

    // Supplemental functions.
    void addMakes(List<String> makes);
    Make getMake(String name);
    List<Make> getMakes();
    void addColors(List<String> color);
    List<Color> getColors();
    void addStates(List<String> state);
    List<State> getStates();
    void addYears(List<Integer> years);
    List<Year> getYears();
    void addModels(List<Model> models);
    List<Model> getModels(int makeId);
}
