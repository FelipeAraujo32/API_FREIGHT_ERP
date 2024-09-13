package com.freight.freight_api.Services.freghtcalculator;

import org.springframework.stereotype.Component;

@Component
public class FreightcalculatorOver200 implements FreightCalculator{
    
    private static final double TARIFF = 1.50;

    @Override
    public boolean appliesTo(double distance) {
        return distance > 200;
    }

    @Override
    public double calculate(double distance) {
        return distance * TARIFF;
    }

}
