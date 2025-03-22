package com.mechanicexpress.rest.controller;

import com.mechanicexpress.rest.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
