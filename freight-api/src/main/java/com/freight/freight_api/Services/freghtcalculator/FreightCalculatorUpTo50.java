package com.freight.freight_api.Services.freghtcalculator;

import org.springframework.stereotype.Component;

@Component
public class FreightCalculatorUpTo50 implements FreightCalculator{
    private static final double TARIFF = 2.00;

    @Override
    public boolean appliesTo(double distance) {
        return distance <= 50;
    }

    @Override
    public double calculate(double distance) {
        return distance * TARIFF;
    }
    
}
