package com.example.flightbook.repository;

import com.example.flightbook.model.UserFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFlightRepository extends JpaRepository<UserFlight, Integer> {
}
