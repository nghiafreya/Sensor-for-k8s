package com.example.identity_service.repository;

import com.example.identity_service.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository <Sensor, String> {

}
