package com.freight.freight_api.dtos;

import java.util.UUID;

public class FreightModelDto {

    private UUID orderId;

    private double freightValue;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public double getFreightValue() {
        return freightValue;
    }

    public void setFreightValue(double freightValue) {
        this.freightValue = freightValue;
    }

    
}
