package com.freight.freight_api.Services.freghtcalculator;

import org.springframework.stereotype.Component;

@Component
public class FreightCalculatorBetween50To200 implements FreightCalculator{
    private static final double TARIFF = 1.75;

    @Override
    public boolean appliesTo(double distance) {
        return distance > 50 && distance <= 200;
    }

    @Override
    public double calculate(double distance) {
        return distance * TARIFF;
    }
    
}
