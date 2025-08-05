package com.example.identity_service.service;

import com.example.identity_service.dto.request.SensorCreationRequest;
import com.example.identity_service.dto.request.SensorUpdateRequest;
import com.example.identity_service.entity.Sensor;
import com.example.identity_service.repository.SensorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SensorSimulator {
    @Autowired
    private SensorService sensorService;
    private int runCount = 0;

    @Scheduled(fixedRate = 200) //200 mili giây
    public void simulateTemperatureSensor() {
        if (runCount > 10) return;
        double value = Math.random() * 50;

        SensorCreationRequest request = new SensorCreationRequest();

        request.setSensorType("temperature");
        request.setValue(value);
        request.setUnit("°C");
        request.setStatus(sensorService.evaluateStatus(request.getSensorType(), value));
        request.setTimestamp(LocalDateTime.now());

        sensorService.createSensor(request); // Tạo mới mỗi lần

        runCount++;
        System.out.println("Simulated sensor run: " + runCount);
    }

    @Scheduled(fixedRate = 200) //200 mili giây
    public void simulateHumiditySensor() {
        if (runCount > 10) return;
        double value = 10 + Math.random() * (100 - 10); //from 10 to 100

        SensorCreationRequest request = new SensorCreationRequest();

        request.setSensorType("humidity");
        request.setValue(value);
        request.setUnit("%");
        request.setStatus(sensorService.evaluateStatus(request.getSensorType(), value));
        request.setTimestamp(LocalDateTime.now());

        sensorService.createSensor(request); // Tạo mới mỗi lần

        runCount++;
        System.out.println("Simulated sensor run: " + runCount);
    }

}
