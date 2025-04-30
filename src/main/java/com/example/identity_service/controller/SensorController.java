package com.example.identity_service.controller;

import com.example.identity_service.dto.request.SensorCreationRequest;
import com.example.identity_service.dto.request.SensorUpdateRequest;
import com.example.identity_service.entity.Sensor;
import com.example.identity_service.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @PostMapping
    Sensor createSensor(@RequestBody SensorCreationRequest request) {
        return sensorService.createSensor(request);
    }


    //lấy thông tin sensors
    @GetMapping
    List<Sensor> getSensors() {
        return sensorService.getSensors();
    }

    //Đào thông tin 1 sensor dựa trên ID của nó
    @GetMapping("/{sensorID}")
    Sensor getSensor(@PathVariable("sensorID") String sensorID) {
        return sensorService.getSensor(sensorID);
    }

    //api dùng để update thông tin
    @PutMapping("/{sensorId}")
    Sensor updateSensor(@PathVariable String sensorId, @RequestBody SensorUpdateRequest request) {
        return sensorService.updateSensor(sensorId, request);
    }

    @DeleteMapping("/{sensorId}")
    String deleteSensor(@PathVariable String sensorId) {
        sensorService.deleteSensor(sensorId);
        return "Sensor deleted";
    }
}
