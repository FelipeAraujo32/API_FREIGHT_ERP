package com.freight.freight_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "freight")
@Table(name = "freight_erp")
public class FreightModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID freightId;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private double freightValue;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public FreightModel() {
    }

    public FreightModel(UUID orderId, double freightValue) {
        this.orderId = orderId;
        this.freightValue = freightValue;
    }

    public UUID getFreightId() {
        return freightId;
    }

    public void setFreightId(UUID freightId) {
        this.freightId = freightId;
    }

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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }   
    
    

    
}
