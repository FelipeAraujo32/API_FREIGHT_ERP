package com.freight.freight_api.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class DistanceCalculatedDto {
    
    @NotNull(message = "Order ID cannot be null")
    private UUID orderId;

    @Min(value = 0, message = "Distance must be positive")
    private double distance;
    
    private String unit;
    
    public UUID getOrderId() {
        return orderId;
    }
    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }


    

}
