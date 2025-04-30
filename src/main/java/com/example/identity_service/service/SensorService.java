package com.example.identity_service.service;

import com.example.identity_service.dto.request.SensorCreationRequest;
import com.example.identity_service.dto.request.SensorUpdateRequest;
import com.example.identity_service.entity.Sensor;
import com.example.identity_service.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public Sensor createSensor(SensorCreationRequest request) {
        Sensor sensor = new Sensor();

        // Map data từ request vào sensor
        sensor.setSensorType(request.getSensorType());
        sensor.setValue(request.getValue());
        sensor.setUnit(request.getUnit());
        sensor.setStatus(request.getStatus());
        sensor.setTimestamp(request.getTimestamp());

        // Lưu sensor vào database, ID sẽ tự động sinh
        return sensorRepository.save(sensor);
    }

    public Sensor updateSensor (String sensorId, SensorUpdateRequest request) {
        Sensor sensor = getSensor(sensorId);

        sensor.setSensorType(request.getSensorType());
        sensor.setValue(request.getValue());
        sensor.setUnit(request.getUnit());
        sensor.setStatus(request.getStatus());
        sensor.setTimestamp(request.getTimestamp());

        return sensorRepository.save(sensor);
    }

    //xóa sensor
    public void deleteSensor(String sensorId) {
        sensorRepository.deleteById(sensorId);
    }

    //sử dụng method findAll thì sẽ lấy được thông tin tất cả sensor
    public List<Sensor> getSensors() {
        return sensorRepository.findAll();
    }

    //lấy thông tin 1 sensor dựa trên id
    public Sensor getSensor(String id) {
        return sensorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Sensor not found"));
    }
}
