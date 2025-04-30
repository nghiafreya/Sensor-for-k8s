package com.example.identity_service.dto.request;

import java.time.LocalDateTime;

public class SensorUpdateRequest {
    private String sensorType;
    private Double value; //giá trị đo được
    private String unit; //độ C, atm,...
    private String status; //normal, warning, error
    private LocalDateTime timestamp;

    // Getter và Setter
    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

