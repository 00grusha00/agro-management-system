package com.agro.model;

public class SensorData {
    private String sensorId;
    private double temperature;
    private double humidity;

    public SensorData() {
    }

    public SensorData(String sensorId, double temperature, double humidity) {
        this.sensorId = sensorId;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}