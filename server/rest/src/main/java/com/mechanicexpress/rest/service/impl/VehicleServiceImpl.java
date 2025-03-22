package com.mechanicexpress.rest.service.impl;

import com.mechanicexpress.rest.model.Vehicle;
import com.mechanicexpress.rest.model.VehicleRel;
import com.mechanicexpress.rest.model.vehicle.*;
import com.mechanicexpress.rest.repository.CustomerRepository;
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

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return false;
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

    // Add a list of years.
    @Override
    public void addYears(List<Integer> years) {
        for (Integer year : years) {
            if (!yearRepository.alreadyExists(year)) {
                yearRepository.save(new Year(year));
            }
        }
    }

    // Add a list of models.
    @Override
    public void addModel(List<Model> models) {
        modelRepository.saveAll(models);
    }
}
