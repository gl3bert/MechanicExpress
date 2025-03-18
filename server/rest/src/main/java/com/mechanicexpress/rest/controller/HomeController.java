package com.mechanicexpress.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController class.
 * Placeholder for home route
 * @author Gleb Bereziuk (gl3bert)
 */

@RestController
public class HomeController {
    // Home page placeholder.
    @GetMapping("/")
    public String home() { return "MechanicExpress: Home Page"; }
}