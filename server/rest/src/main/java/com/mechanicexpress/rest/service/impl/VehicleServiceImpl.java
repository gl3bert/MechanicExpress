package com.mechanicexpress.rest.service.impl;

import com.mechanicexpress.rest.model.Vehicle;
import com.mechanicexpress.rest.model.vehicle.*;
import com.mechanicexpress.rest.repository.VehicleRepository;
import com.mechanicexpress.rest.repository.vehicle.*;
import com.mechanicexpress.rest.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation for VehicleService interface.
 * Code for methods.
 * @author Gleb Bereziuk (gl3bert)
 */

@Service
public class VehicleServiceImpl implements VehicleService {
    // Set up repository access.
    private final VehicleRepository vehicleRepository;
    private final ModelRepository modelRepository;
    private final MakeRepository makeRepository;
    private final ColorRepository colorRepository;
    private final StateRepository stateRepository;
    private final YearRepository yearRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelRepository modelRepository,
                              MakeRepository makeRepository, ColorRepository colorRepository,
                              StateRepository stateRepository, YearRepository yearRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelRepository = modelRepository;
        this.makeRepository = makeRepository;
        this.colorRepository = colorRepository;
        this.stateRepository = stateRepository;
        this.yearRepository = yearRepository;
    }

    // Add a new vehicle.
    @Override
    public void addVehicle(VehicleRequest request) {
        Make make = makeRepository.findById(request.getMake()).orElseThrow(() -> new RuntimeException("Make not found"));
        Model model = modelRepository.findById(request.getModel()).orElseThrow(() -> new RuntimeException("Model not found"));
        Year year = yearRepository.findById(request.getYear()).orElseThrow(() -> new RuntimeException("Year not found"));
        Color color = colorRepository.findById(request.getColor()).orElseThrow(() -> new RuntimeException("Color not found"));
        State state = stateRepository.findById(request.getState()).orElseThrow(() -> new RuntimeException("State not found"));
        Vehicle vehicle = new Vehicle(make, model, year, color, state, request.getPlate(), request.getVin());
        System.out.println(vehicle.toString());
        if (vehicleRepository.findMaxVehicleId() != null) {
            vehicle.setVehicleId(vehicleRepository.findMaxVehicleId() + 1);
        }
        else {
            vehicle.setVehicleId(1000);
        }
        vehicleRepository.save(vehicle);
    }

    /* Supplemental methods for populating SQL tables with sample values */

    // Add a list of makes.
    @Override
    public void addMakes(List<String> makes) {
        for (String make : makes) {
            if (!makeRepository.alreadyExists(make)) {
                Make m = new Make(make);
                if (makeRepository.findMaxMakeId() != null) {
                    m.setMakeId(makeRepository.findMaxMakeId() + 1);
                } else {
                    m.setMakeId(1);  // Start with 1 if no makes exist
                }
                makeRepository.save(m);
            }
        }
    }

    // Return make by its name.
    @Override
    public Make getMake(String name) {
        return makeRepository.findByName(name);
    }

    // Get the list of makes.
    @Override
    public List<Make> getMakes() {
        return makeRepository.findAll();
    }

    // Add a list of colors.
    @Override
    public void addColors(List<String> colors) {
        for (String color : colors) {
            if (!colorRepository.alreadyExists(color)) {
                Color c = new Color(color);
                if (colorRepository.findMaxColorId() != null) {
                    c.setColorId(colorRepository.findMaxColorId() + 1);
                } else {
                    c.setColorId(1);
                }
                colorRepository.save(c);
            }
        }
    }

    // Get the list of colors.
    @Override
    public List<Color> getColors() {
        return colorRepository.findAll();
    }

    // Add a list of states.
    @Override
    public void addStates(List<String> states) {
        for (String state : states) {
            if (!stateRepository.alreadyExists(state)) {
                State s = new State(state);
                if (stateRepository.findMaxStateId() != null) {
                    s.setStateId(stateRepository.findMaxStateId() + 1);
                } else {
                    s.setStateId(1);
                }
                stateRepository.save(s);
            }
        }
    }

    // Get the list of states.
    @Override
    public List<State> getStates() {
        return stateRepository.findAll();
    }

    // Add a list of years.
    @Override
    public void addYears(List<Integer> years) {
        for (Integer year : years) {
            if (!yearRepository.alreadyExists(year)) {
                yearRepository.save(new Year(year));
            }
        }
    }

    // Get a list of years.
    @Override
    public List<Year> getYears() {
        return yearRepository.findAll();
    }

    // Add a list of models.
    @Override
    public void addModels(List<Model> models) {
        for (Model model : models) {
            if (!modelRepository.existsByMakeAndModel(model.getName(), model.getMake().getMakeId())) {
                if (modelRepository.findMaxModelId() != null) {
                    model.setModelId(modelRepository.findMaxModelId() + 1);
                }
                else {
                    model.setModelId(1);
                }
                modelRepository.save(model);
            }
        }
    }

    // Get models for a matching makeId.
    @Override
    public List<Model> getModels(int makeId) {
        return modelRepository.findByMakeId(makeId);
    }
}
