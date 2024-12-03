package com.example.flightbook.controller;

import com.example.flightbook.model.Flight;
import com.example.flightbook.model.UserFlight;
import com.example.flightbook.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("api/add/flight")
    public Flight addFlight(@RequestBody Flight flight)
    {
        return flightService.addFlight(flight);
    }

    @GetMapping("api/get/flights")
    public List<Flight> getAllFlights()
    {
        return flightService.getAllFlights();
    }

    @PostMapping("api/book/flight/{flightId}")
    public UserFlight addUser(@RequestBody UserFlight userFlight,@PathVariable int flightId) throws Exception {
        return flightService.bookFlight(userFlight, flightId);
    }
}
