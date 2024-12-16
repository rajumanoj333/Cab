package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CabRegisterController {

    @Autowired
    CabRepo repo;  // Repository for Cab entity

    Logger log = Logger.getAnonymousLogger();

    // Registration endpoint
    @ResponseBody
    @RequestMapping("/register/{fullName}/{password}/{email}/{phoneNumber}")
    public String registerUser(
            @PathVariable("fullName") String fullName,
            @PathVariable("password") String password,
            @PathVariable("email") String email,
            @PathVariable("phoneNumber") String phoneNumber) {

        // Create a new Cab entity and set the properties
        Cab cab = new Cab();
        cab.setFullName(fullName);
        cab.setPassword(password);
        cab.setEmail(email);
        cab.setPhoneNumber(phoneNumber);

        // Save the cab entity to the repository
        repo.save(cab);

        // Log the operation and return a success message
        log.info("Cab registration successful for: " + fullName);
        return "Registration done for " + fullName;
    }
}
