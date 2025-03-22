package com.mechanicexpress.rest.controller;

import com.mechanicexpress.rest.model.vehicle.Make;
import com.mechanicexpress.rest.model.vehicle.Model;
import com.mechanicexpress.rest.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controller for Vehicle class and its supplemental classes.
 * Handles API requests.
 * @author Gleb Bereziuk (gl3bert)
 */

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
    // Set up service access.
    VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }



    /* Handling for adding new supplemental data to the tables */

    @PostMapping("/make/add")
    public void addMakes(@RequestBody List<String> make) {
        vehicleService.addMakes(make);
    }

    @PostMapping("/color/add")
    public void addColors(@RequestBody List<String> colors) {
        vehicleService.addColors(colors);
    }

    @PostMapping("/year/add")
    public void addYears(@RequestBody List<Integer> years) {
        vehicleService.addYears(years);
    }

    @PostMapping("/state/add")
    public void addStates(@RequestBody List<String> states) {
        vehicleService.addStates(states);
    }

    @PostMapping("/model/add")
    public void addModelsBatch(@RequestBody List<Map<String, String>> modelsRequest) {
        List<Model> models = new ArrayList<>();
        for (Map<String, String> request : modelsRequest) {
            String modelName = request.get("model");
            String makeName = request.get("make");
            Make make = vehicleService.getMake(makeName);
            Model model = new Model(modelName, make);
            models.add(model);
        }
        vehicleService.addModels(models);
    }
}
