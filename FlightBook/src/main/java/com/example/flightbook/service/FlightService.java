package com.example.flightbook.service;

import com.example.flightbook.model.Flight;
import com.example.flightbook.model.User;
import com.example.flightbook.model.UserFlight;
import com.example.flightbook.repository.FlightRepository;
import com.example.flightbook.repository.UserFlightRepository;
import com.example.flightbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFlightRepository userFlightRepository;

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }


    public UserFlight bookFlight(UserFlight userFlight, int flightId) throws Exception {
        User user = userFlight.getUser();
        user = userRepository.save(user);

        Flight flight = getFlightById(flightId);

        userFlight.setUser(user);
        userFlight.setFlight(flight);
        return userFlightRepository.save(userFlight);
    }

    private Flight getFlightById(int flightId) throws Exception {
        return flightRepository.findById(flightId).orElseThrow(()->new Exception("invalid flight id"));
    }
}
